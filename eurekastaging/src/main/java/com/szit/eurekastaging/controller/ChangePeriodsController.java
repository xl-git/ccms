package com.szit.eurekastaging.controller;

import com.szit.eurekastaging.pojo.ChangePeriods;
import com.szit.eurekastaging.pojo.CreditCard;
import com.szit.eurekastaging.pojo.PageIndexer;
import com.szit.eurekastaging.pojo.User;
import com.szit.eurekastaging.service.ChangePeriodsService;
import com.szit.eurekastaging.service.CreditCardService;
import com.szit.eurekastaging.service.TransactionService;
import com.szit.eurekastaging.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 客户管理控制器类
 *
 * @author 刘志强
 * @version 1.0 2020-04-20
 */
@Controller
public class ChangePeriodsController {
    @Autowired
    private UserService userService;
    @Autowired
    private CreditCardService creditCardService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ChangePeriodsService changePeriodsService;

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/apply.html")
    protected String apply(@RequestParam(value = "pageIndex", required = false) Integer pageIndex, Model model){
        String url="";
        String msg="";
        String username=(String)redisTemplate.opsForValue().get("loginUser");
        User user=userService.getByuserName(username);
        PageIndexer page = new PageIndexer(1, 2, 0, 0);
        if (pageIndex != null) {
            page.setPageIndex(pageIndex);
        }

        if(user!=null){
            List<CreditCard> creditCards=creditCardService.getByuserId(user.getId(),page);
            if(creditCards.size()>0){
                model.addAttribute("creditCards",creditCards);
                model.addAttribute("pi",page);
                model.addAttribute("user",user);
                url="apply";
            }else{
                msg="您还未办理任何信用卡，请点击链接先进行办卡！<a href='http://localhost:8003/cardmanage/cardadd/1'>申请办卡</a>";
            }
        }else {
            msg="您还未登录，请先登录!";
        }
        model.addAttribute("msg",msg);
        return url;
    }

    @GetMapping(value = "applyinfo")
    protected String applyInfo(Integer id, Model model){
        //最大可分期金额
        double money=transactionService.getTransMoneyByCardId(id);
        CreditCard creditCard=creditCardService.getCardById(id);
        model.addAttribute("month", Calendar.getInstance().get(Calendar.MONTH) + 1);
        model.addAttribute("money",money);
        model.addAttribute("maxpaymoney",money*0.9);
        model.addAttribute("creditCard",creditCard);
        return "applyinfo";
    }

    @RequestMapping("doapply.html")
    protected String doApply(ChangePeriods changePeriods, Model model){
        int flag=changePeriodsService.addChangePeriods(changePeriods);
        System.out.println("cid"+changePeriods.getCardId());
        String msg="申请成功";
        if(flag==0){
            msg="分期失败";
        }
        model.addAttribute("msg",msg);
        return "applyinfo";
    }


    @RequestMapping("/currapply.html")
    protected String curapply(Model model){
        Date date=new Date();
       List<ChangePeriods> lists=changePeriodsService.getChangePeriodsBychangeDate(date);
        model.addAttribute("lists",lists);
        return "currapply";
    }

    @RequestMapping("/hisapply.html")
    protected String hisapply(Model model,@RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                              @RequestParam(value = "lowdate", required = false) String low,
                                @RequestParam(value = "highdate", required = false) String high){
        PageIndexer page = new PageIndexer(1, 2, 0, 0);
        if (pageIndex != null) {
            page.setPageIndex(pageIndex);
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date lowdate=null;
        Date highdate=null;
        try {
            if(low!=null&low!=""){
                lowdate = simpleDateFormat.parse(low);
            }
            if(high!=null&high!=""){
                highdate = simpleDateFormat.parse(high);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String username=(String)redisTemplate.opsForValue().get("loginUser");
        User user=userService.getByuserName(username);
        List<ChangePeriods> lists=changePeriodsService.getChangePeriodsBycardId(user.getId(),lowdate,highdate,page);
        model.addAttribute("lists",lists);
        model.addAttribute("low",low);
        model.addAttribute("high",high);
        model.addAttribute("pi",page);
        return "hisapply";
    }



    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public CreditCardService getCreditCardService() {
        return creditCardService;
    }

    public void setCreditCardService(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
