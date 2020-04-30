package com.szit.eurekarepaymentmanage.controller;

import com.szit.eurekarepaymentmanage.pojo.*;
import com.szit.eurekarepaymentmanage.service.RepaymentService;

import com.szit.eurekarepaymentmanage.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 还款管理控制类
 * @author 艾邓枫
 * @version 1.0 2020-04-08
 */
@Controller
public class RepaymentController1 {
    @Autowired
    private RepaymentService repaymentService;
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 还款管理首页
     * @return
     */
    @RequestMapping("/repayment.html")
    protected String repayment(@RequestParam(value = "pageIndex",required = false) Integer pageIndex,Model model, HttpServletRequest request){
        String url="";
        String username=(String) redisTemplate.opsForValue().get("loginUser");
        User user=repaymentService.getUserByUserName(username);

        PageIndexer page = new PageIndexer(1, 2, 0, 0);
        if (pageIndex != null) {
            page.setPageIndex(pageIndex);
        }

        if (user!=null){
            List<CreditCard> creditCards=repaymentService.getCardById(user.getId(),page);
            model.addAttribute("creditcards",creditCards);
            model.addAttribute("pi",page);
            url="repayment";
        }
        return url;
    }


    @RequestMapping("/current.html")
    protected String current(@RequestParam() String cardNum,HttpSession session){
        String url="";
        User user=repaymentService.getUserByUserName((String) redisTemplate.opsForValue().get("loginUser"));
        List<DebitCard> debitCards=repaymentService.getDebitCardById(user.getId());
        if(user!=null){
            CreditCard creditCard=repaymentService.getCreditCardByCardNum(cardNum);
            Overdue overdue=repaymentService.getOverdueById(creditCard.getId());
            ChangePeriods changePeriods=repaymentService.getChangePeriodsById(creditCard.getId());
            long time = overdue.getOverdueDate().getTime();
            long time1 = new Date().getTime();
            long time3 = time1-time;
            System.out.println(time3);
            //转为天
            long i = (time3/1000/60/60/24);
            //逾期利息
            double ormount=overdue.getOverdueAmount()*overdue.getOverdueRate()*i;
            System.out.println(ormount);
            //逾期金额
            double oamount=ormount+overdue.getOverdueAmount();
            System.out.println(oamount);


            //分期金额
            double camount = 0;
            //分期利息
            double ccamount=0;
            if(changePeriods.getPeriodsId()==3){
                ccamount=changePeriods.getAmount()/changePeriods.getPeriodsId()*0.0195;
                camount=ccamount+changePeriods.getAmount();
            }else if(changePeriods.getPeriodsId()==6){
                ccamount=changePeriods.getAmount()/changePeriods.getPeriodsId()*0.036;
                camount=ccamount+changePeriods.getAmount();
            }else if(changePeriods.getPeriodsId()==12){
                ccamount=changePeriods.getAmount()/changePeriods.getPeriodsId()*0.072;
                camount=ccamount+changePeriods.getAmount();
            }else {
                System.out.println("没有此分期期数！");
            }
            //未分期逾期金额
            double namount=creditCard.getCreditLimit()-creditCard.getUseableLimit()-overdue.getOverdueAmount()-creditCard.getChangeLimit();
            //本期账单
            double gross=oamount+camount+namount;
            Date nowdate=new Date();
            session.setAttribute("gross",gross);

            session.setAttribute("debitCards",debitCards);
            session.setAttribute("creditCard",creditCard);
            session.setAttribute("changePeriods",changePeriods);
            session.setAttribute("nowdate",nowdate);
            session.setAttribute("ormount",ormount);
            session.setAttribute("ccamount",ccamount);
            url="repaymentmanage";
        }
        return url;
    }
    @RequestMapping("/addrepayment.html")
    public String addrepayment(HttpSession session,String nowcode,Model model,double current) {
        String url="";
        String message="";
        session.setAttribute("current",current);
        if(nowcode.equals(session.getAttribute("param"))){
            url="debitcard";
            message="验证通过!";

        }else {
            message="验证码错误!";
            url="repaymentmanage";
            session.getAttribute("gross");
        }
        session.setAttribute("message",message);

        return url;
    }

    /**
     *
     * 手机接收验证码
     * @param phone
     * @param res
     * @param session
     */
    @RequestMapping("/getphonecode.html")
    protected void getphonecode(@RequestParam(value = "phone")String phone , HttpServletResponse res, HttpSession session) {
        String param = num();
        String host = "https://zwp.market.alicloudapi.com";
        String path = "/sms/sendv2";
        String method = "GET";
        String appcode = "9ca44a091f7a420a9d39cb4e82ea5fc5";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("content", "【云通知】您的验证码是"+param+"。如非本人操作，请忽略本短信");
        querys.put("mobile", phone);
        session.setAttribute("param",param);

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 手机动态码
     * @return
     */
    private String num() {
        int p = new Random().nextInt(899999) + 100000;
        String phoneCode = Integer.toString(p);
        return phoneCode;
    }

    /**
     * 跳转到借记卡页面
     * @param pasd
     * @param session
     * @return
     */
    @RequestMapping("/debitcard.html")
    protected String debitcard(HttpSession session,int pasd,String debitCardId){
        String url="";
        DebitCard debitCard=repaymentService.getDebitCardByDid(debitCardId);
        ChangePeriods changePeriods= (ChangePeriods) session.getAttribute("changePeriods");
        CreditCard creditCard= (CreditCard) session.getAttribute("creditCard");
        Date nowdate= (Date) session.getAttribute("nowdate");
        double ormount= (double) session.getAttribute("ormount");
        double ccamount= (double) session.getAttribute("ccamount");
        double crrunt= (double) session.getAttribute("current");
        if(pasd==debitCard.getPayPassword()){
            Repayment repayment = new Repayment();
            repayment.setRmoney(crrunt);
            repayment.setDuedate(nowdate);
            repayment.setDebitCardId(debitCard.getId());
            repayment.setCardId(creditCard.getId());
            repayment.setChangePeriodsId(changePeriods.getId());//向还款表插入数据)
            if(debitCard.getBalance()>=crrunt){
                if(repaymentService.addRepayment(repayment)){
                    //更改信用卡数据

                    double t=crrunt-ormount-ccamount;
                    double total=t+creditCard.getUseableLimit();
                    creditCard.setUseableLimit(total); //可用额度
                    if(repaymentService.alterCreditCard(creditCard)){
                        double a=debitCard.getBalance()-crrunt;
                        debitCard.setBalance(a);
                        if(repaymentService.alterDebitCard(debitCard)){
                            url="succeed";
                        }else {
                            String message1="还款失败,请重新还款!";
                            url="debitcard";
                        }

                    }else {
                        String message1="还款失败,请重新还款!";
                        url="debitcard";
                    }

                }
            }else {
                String message1="还款失败,请重新还款!";
                url="debitcard";
            }




        }else {
            String message1="还款失败,请重新还款!";
            url="debitcard";
        }
        return url;
    }


    /**
     * 跳转到还款明细页面
     * @param pageIndex
     * @param model
     * @return
     */
    @RequestMapping("/detail.html")
    protected String detail(@RequestParam(value = "pageIndex",required = false) Integer pageIndex,Model model){
        String url="";
        String username=(String) redisTemplate.opsForValue().get("loginUser");
        User user=repaymentService.getUserByUserName(username);

        PageIndexer page = new PageIndexer(1, 2, 0, 0);
        if (pageIndex != null) {
            page.setPageIndex(pageIndex);
        }

        if (user!=null){
            List<Repayment> repayments=repaymentService.getAll(user.getId(),page);
            System.out.println(repayments.size());
            model.addAttribute("repayments",repayments);
            model.addAttribute("pi",page);
            url="repayment";
        }
        return "detail";
    }

    public RepaymentService getRepaymentService() {
        return repaymentService;
    }

    public void setRepaymentService(RepaymentService repaymentService) {
        this.repaymentService = repaymentService;
    }
}
