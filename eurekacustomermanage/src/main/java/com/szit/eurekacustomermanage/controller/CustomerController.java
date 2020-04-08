package com.szit.eurekacustomermanage.controller;

import com.szit.eurekacustomermanage.service.CardService;
import com.szit.eurekacustomermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * 客户管理控制器类
 * @author 肖林
 * @version 1.0 2020-04-04
 */
@Controller
public class CustomerController {
    @Autowired
    private UserService userService;
    @Autowired
    private CardService cardService;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 跳转到用户客户管理首页
     * @return
     */
    @RequestMapping("/customermanage.html")
    protected String customermanage(){
        return "customermanage";
    }



    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public CardService getCardService() {
        return cardService;
    }

    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
