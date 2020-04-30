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

@Controller
@RequestMapping(value = "/accountManage")
public class CreditCardController {

    @Autowired
    private UserService userService;

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 账户查询
     * @param
     * @param model
     * @return
     */
    @GetMapping(value = "/accountQuery.html")
    public String accountQuery(Model model){
        String url="accountQuery";
        String key= "loginUser";
        String userName = stringRedisTemplate.opsForValue().get(key);
        User user = userService.getUserByUserName(userName);
        CreditCard creditCard = creditCardService.getCreditCardByUserId(user.getId());
        double alreadyMoney = creditCardService.getMoneyByDate(creditCard.getId());
        double money = creditCardService.getMoneyByDate(creditCard.getId());
        model.addAttribute("creditCard",creditCard);
        model.addAttribute("alreadyMoney",alreadyMoney);
        model.addAttribute("money",money);
        return url;
    }

    /**
     * 已出账单查询
     * @param model
     * @return
     */
    @GetMapping(value = "/alreadyAccount.html")
    public String alreadyQuery(Model model){

        return "alreadyAccount";
    }

    /**
     * 已出账单明细信息
     * @param model
     * @return
     */
    @GetMapping(value = "/accountDetail.html")
    public String accountDetail(Model model){

        return "accountDetail";
    }




    /**
     * 未出账单查询
     * @param model
     * @return
     */
    @GetMapping(value = "/notAccount.html")
    public String notAccount(Model model){

        return "notAccount";
    }

}
