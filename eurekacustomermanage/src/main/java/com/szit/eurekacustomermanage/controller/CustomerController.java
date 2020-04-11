package com.szit.eurekacustomermanage.controller;

import com.szit.eurekacustomermanage.pojo.Card;
import com.szit.eurekacustomermanage.pojo.CreditCardInfo;
import com.szit.eurekacustomermanage.pojo.User;
import com.szit.eurekacustomermanage.service.CardService;
import com.szit.eurekacustomermanage.service.CreditCardInfoService;
import com.szit.eurekacustomermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

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
    @Autowired
    private CreditCardInfoService creditCardInfoService;

    /**
     * 跳转到用户客户管理首页
     * @return
     */
    @RequestMapping("/customermanage.html")
    protected String customermanage(){
        return "customermanage";
    }

    /**
     * 跳转到基本账户信息页面
     * @return
     */
    @RequestMapping("/accountinfo.html")
    protected String accountinfo(Model model, HttpServletRequest request){
        String url="";
        User user=(User)request.getSession().getAttribute("loginUser");
        if(user!=null){
            Card card=cardService.getCardByUid(user.getUid());
            model.addAttribute("card",card);
            url= "accountinfo";
        }
        return url;
    }

    /**
     * 跳转到账户下卡片信息页面
     * @return
     */
    @RequestMapping("/cardinfo.html")
    protected String cardinfo(Model model, HttpServletRequest request){
        String url="";
        User user=(User)request.getSession().getAttribute("loginUser");
        if(user!=null){
            Card card=cardService.getCardByUid(user.getUid());
            model.addAttribute("card",card);
            model.addAttribute("user",user);
            url= "cardinfo";
        }
        return url;
    }

    /**
     * 跳转到网上申请进度查询页面
     * @return
     */
    @RequestMapping("/onlinepro.html")
    protected String onlinepro(@RequestParam String certificateNum, Model model){
        String url="onlinepro";
        CreditCardInfo creditCardInfo=creditCardInfoService.getCreditCardInfoByCertificateNum(certificateNum);
        if(creditCardInfo!=null){
            Card card=cardService.getCardByCcid(creditCardInfo.getCcid());
            model.addAttribute("creditCardInfo",creditCardInfo);
            model.addAttribute("certificateNum",certificateNum);
            model.addAttribute("card",card);
            url="redirect:/onlineview.html";
        }
        return url;
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

    public CreditCardInfoService getCreditCardInfoService() {
        return creditCardInfoService;
    }

    public void setCreditCardInfoService(CreditCardInfoService creditCardInfoService) {
        this.creditCardInfoService = creditCardInfoService;
    }
}
