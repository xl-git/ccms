package com.szit.eurekacardmanage.controller;

import com.alibaba.fastjson.JSONArray;
import com.szit.eurekacardmanage.pojo.*;
import com.szit.eurekacardmanage.service.CardService;
import com.szit.eurekacardmanage.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 卡片管理控制层
 */
@Controller
public class CardController {
    @Autowired
    private CardService cardService;
    @Autowired
    private RedisTemplate redisTemplate;



    protected void getLoginUser(HttpSession session){
        String name=(String) redisTemplate.opsForValue().get("loginUser");
        User user=cardService.getUserByUserName(name);
        if(user!=null){
            session.setAttribute("user",user);
        }
    }
    /**
     * 办卡跳转
     * @param model
     * @param type 1：普卡、2：金卡、3：白金卡
     * @return
     */
    @GetMapping(value="cardadd/{type}")
    protected String addCard(Model model, @PathVariable("type") int type, HttpSession session){
        this.getLoginUser(session);
        session.setAttribute("type",type);
        return "cardadd";
    }

    /**
     * 保存卡片申请信息
     * @param baseInfo 基本信息
     * @param unitInfo 单位信息
     * @param contactInfo 联系人信息
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("savecard.html")
    protected String saveCard(String CadoDemo,BaseInfo baseInfo, UnitInfo unitInfo, ContactInfo contactInfo,HttpSession session,Model model){
        String msg="验证码错误！";
        System.out.println(baseInfo.getIdentityCard());
        if(CadoDemo.equals(session.getAttribute("phoneCode"))){
                msg="提交申请失败";
            if(cardService.addOpenStatus((User)session.getAttribute("user"),(int)session.getAttribute("type"),contactInfo,unitInfo,baseInfo)){
                msg="成功提交申请";
            }
        }
        model.addAttribute("msg",msg);
        return "cardadd";
    }


    /**
     * 卡片管理页面跳转
     * @param status
     * @return
     */
    @RequestMapping("cardsystem/{status}")
    protected String cardSystem(@PathVariable("status") int status){
        String url="";
        if(status==1){
            url="cardlose";
        }else if(status==2){
            url="removecard";
        }else{
            url="updatepaypassword";
        }
        return url;
    }

    /**
     * 卡片挂失
     * @param creditCard
     * @param identityCard
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("cardlose.html")
    protected String cardLose(CreditCard creditCard, String identityCard,HttpSession session,Model model){
        if((User)session.getAttribute("user")==null){
            this.getLoginUser(session);
        }
        creditCard.setUserId(((User) session.getAttribute("user")).getId());
        String msg="填写信息有误";
        if(this.cardService.updateCardStatusIdByCardNum(creditCard,identityCard)!=0){
            msg="操作成功";
        }
        model.addAttribute("msg",msg);
        return "cardlose";
    }

    /**
     * 销卡
     * @param creditCard
     * @param identityCard
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("removecard.html")
    protected String removeCard(CreditCard creditCard, String identityCard,HttpSession session,Model model){
        if((User)session.getAttribute("user")==null){
            this.getLoginUser(session);
        }
        creditCard.setUserId(((User) session.getAttribute("user")).getId());
        String msg="填写信息有误";
        if(this.cardService.updateCardStatusIdByCardNum(creditCard,identityCard)!=0){
            msg="操作成功";
        }
        model.addAttribute("msg",msg);
        return "removecard";
    }


    @RequestMapping("updatepaypassword.html")
    protected String updatePayPassword(HttpSession session,String cardNum, String oldPassword, String newPassword, Integer userId){
        if((User)session.getAttribute("user")==null){
            this.getLoginUser(session);
        }
        String msg="填写信息有误";
        if(this.cardService.updatePayPasswordByCardNum(cardNum,oldPassword,newPassword,userId)>0){
            msg="操作成功";
        }
        return "updatepaypassword";
    }

    /**
     * 获取手机动态验证码
     * @param phone
     * @param res
     */
    @RequestMapping("/getphonecode.html")
    protected void getphonecode(@RequestParam("phone")String phone , HttpServletResponse res, HttpSession session) {
        String param;
        System.out.println("手机："+phone);
        Map<String,String> resultMap = new HashMap<String,String>();
        if(phone!=null && !phone.equals("")) {
            param = num();
            String host = "https://zwp.market.alicloudapi.com";
            String path = "/sms/sendv2";
            String method = "GET";
            String appcode = "7ab866a47701479e9e89ed1d7128180f";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            Map<String, String> querys = new HashMap<String, String>();
            querys.put("content", "【云通知】您的验证码是"+param+"。如非本人操作，请忽略本短信");
            querys.put("mobile", phone);
            session.setAttribute("phoneCode", param);
            System.out.println(session.getAttribute("phoneCode"));
            try {
                HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
                System.out.println(response.toString());
                //获取response的body
                //System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            res.setContentType("application/json");
            resultMap.put("result","true");
        }else {
            resultMap.put("result","false");
            res.setContentType("application/json");
        }
        PrintWriter out = null;
        try {
            out = res.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.write(JSONArray.toJSONString(resultMap));
        out.flush();
        out.close();
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


}
