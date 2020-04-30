package com.szit.eurekaaccountmanage.controller;

import com.szit.eurekaaccountmanage.pojo.CreditCard;
import com.szit.eurekaaccountmanage.pojo.User;
import com.szit.eurekaaccountmanage.service.CreditCardService;
import com.szit.eurekaaccountmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(value = "/accountManage")
public class UserController {

    //private static final String REST_URL_PREFIX="http://localhost:8001";
    //使用了Riboon以后，访问地址改为访问服务名
    private static final String REST_URL_PREFIX="http://eurekauser";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private CreditCardService creditCardService;

    /**
     * 账户总览
     * @param model
     * @return
     */
    @GetMapping(value = "/index.html")
    public String index(Model model){
        String key="loginUser";
        String url = "error";
        String userName = stringRedisTemplate.opsForValue().get(key);
        //判断缓存中是否有用户
        /*if(userName == null || "".equals(userName)){
            String url="/login.html";
            return restTemplate.getForObject(REST_URL_PREFIX + url, String.class);
        }*/
//        if(userName == null || "".equals(userName)){
//            return url;
//        }
        User user = userService.getUserByUserName(userName);
        CreditCard creditCard = creditCardService.getCreditCardByUserId(user.getId());
        double alreadyMoney = creditCardService.getAlreadyMoneyByDate(creditCard.getId());
        String cardNum = creditCard.getCardNum();
        String head = cardNum.substring(0, 4);
        String end = cardNum.substring(12);
        String newNum = head+"********"+end;
        creditCard.setCardNum(newNum);
        model.addAttribute("creditCard",creditCard);
        model.addAttribute("alreadyMoney",alreadyMoney);
        url = "index";
        return url;
    }

}
