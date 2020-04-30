package com.szit.eurekacustomermanage.controller;

import com.szit.eurekacustomermanage.pojo.*;
import com.szit.eurekacustomermanage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 客户管理控制器类
 *
 * @author 肖林
 * @version 1.0 2020-04-04
 */
@Controller
public class CustomerController {
    @Autowired
    private UserService userService;
    @Autowired
    private CreditCardService creditCardService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private BaseInfoService baseInfoService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private OpenStatusService openStatusService;
    @Autowired
    private ContactInfoService contactInfoService;


    /**
     * 跳转到基本账户信息页面
     *
     * @return
     */
    @RequestMapping("/customerselect.html")
    public String customerselect(@RequestParam(value = "pageIndex", required = false) Integer pageIndex,Model model) {
        String url = "";
        String username = (String) redisTemplate.opsForValue().get("loginUser");
        User user = userService.getUserByUserName(username);

        PageIndexer page = new PageIndexer(1, 2, 0, 0);
        if (pageIndex != null) {
            page.setPageIndex(pageIndex);
        }

        System.out.println("用户名：" + user.getUserName());
        if (user != null) {
            List<CreditCard> creditCards = creditCardService.getCreditCardsByUserId(user.getId(),page);
            model.addAttribute("creditCards", creditCards);
            model.addAttribute("user",user);
            model.addAttribute("pi",page);
            url = "customerselect";
        }
        return url;
    }

    @RequestMapping("/cardinfo.html")
    public String cardinfo(@RequestParam(value = "pageIndex", required = false) Integer pageIndex,Model model) {
        String url = "";
        String username = (String) redisTemplate.opsForValue().get("loginUser");
        User user = userService.getUserByUserName(username);

        PageIndexer page = new PageIndexer(1, 2, 0, 0);
        if (pageIndex != null) {
            page.setPageIndex(pageIndex);
        }

        System.out.println("用户名：" + user.getUserName());
        if (user != null) {
            List<CreditCard> creditCards = creditCardService.getCreditCardsByUserId(user.getId(),page);
            model.addAttribute("creditCards", creditCards);
            model.addAttribute("user",user);
            model.addAttribute("pi",page);
            url = "cardinfo";
        }
        return url;
    }


    /**
     * 跳转到网上申请进度查询页面
     *
     * @return
     */
    @RequestMapping("/onlinepro.html")
    public String onlinepro(@RequestParam(value = "queryIdentityCard",required = false) String queryIdentityCard, @RequestParam(value = "pageIndex", required = false) Integer pageIndex,Model model) {
        BaseInfo baseInfo=baseInfoService.getBaseInfoByIdentityCard(queryIdentityCard);
        PageIndexer page = new PageIndexer(1, 5, 0, 0);
        if (pageIndex != null) {
            page.setPageIndex(pageIndex);
        }

        if (baseInfo!= null) {
            System.out.println("666");
            List<OpenStatus> openStatuss=openStatusService.getOpenStatusByUserId(baseInfo.getUserId(),page);
            User u=userService.getUserById(baseInfo.getUserId());
            model.addAttribute("openStatuss", openStatuss);
            System.out.println(openStatuss.size());
            model.addAttribute("queryIdentityCard", queryIdentityCard);
            model.addAttribute("baseInfo", baseInfo);
            model.addAttribute("pi",page);
            model.addAttribute("u",u);
        }
        return "onlinepro";
    }

    /**
     * 跳转到邮箱设置页面
     *
     * @return
     */
    @RequestMapping("/emailset.html")
    protected String emailset(Model model) {
        String username = (String) redisTemplate.opsForValue().get("loginUser");
        User user = userService.getUserByUserName(username);
        ContactInfo contactInfo = contactInfoService.getContactInfoByUserId(user.getId());
        model.addAttribute("contactInfo", contactInfo);
        return "emailset";
    }

    /**
     * 跳转到修改Email页面
     *
     * @return
     */
    @RequestMapping("/updateemail.html")
    protected String updateemail(@RequestParam(value = "queryEmail" ,required = false) String queryEmail, Model model) {
        System.out.println(queryEmail);
        String msg="";
        String url = "updateemail";
        String username = (String) redisTemplate.opsForValue().get("loginUser");
        User user = userService.getUserByUserName(username);
        if(queryEmail!=null){
            boolean flag=contactInfoService.updateEmail(queryEmail,user.getId());
            if (flag) {
                msg="修改成功！";
                url = "redirect:/emailset.html";
            }
            msg="系统异常，修改失败！";
        }
        model.addAttribute("msg",msg);
        model.addAttribute("queryEmail",queryEmail);
        return url;
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

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BaseInfoService getBaseInfoService() {
        return baseInfoService;
    }

    public void setBaseInfoService(BaseInfoService creditCardInfoService) {
        this.baseInfoService = baseInfoService;
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public OpenStatusService getOpenStatusService() {
        return openStatusService;
    }

    public void setOpenStatusService(OpenStatusService openStatusService) {
        this.openStatusService = openStatusService;
    }

    public ContactInfoService getContactInfoService() {
        return contactInfoService;
    }

    public void setContactInfoService(ContactInfoService contactInfoService) {
        this.contactInfoService = contactInfoService;
    }
}
