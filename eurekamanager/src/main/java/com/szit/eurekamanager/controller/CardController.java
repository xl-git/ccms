package com.szit.eurekamanager.controller;

import com.szit.eurekamanager.pojo.Admin;
import com.szit.eurekamanager.pojo.CreditCard;
import com.szit.eurekamanager.pojo.OpenStatus;
import com.szit.eurekamanager.pojo.PageIndexer;
import com.szit.eurekamanager.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CardController {
    @Autowired
    CardService cardService;

    /**
     * 登录判断及权限等级获取
     * @param session
     * @return
     */
    protected Integer isLogin(HttpSession session){
        Admin loginAdmin = (Admin) session.getAttribute("loginAdmin");
        Integer grade=null;
        if(loginAdmin!=null){
            grade = loginAdmin.getGrade();

        }
        return grade;
    }


    @GetMapping("openstatuslist.html")
    protected String getOpenStatusList(@RequestParam(value ="pageIndex", required=false) Integer pageIndexer, Model model,HttpSession session){
        String url="openstatus";
        if(isLogin(session)!=null) {
            PageIndexer pi = new PageIndexer(1, 5, 0, 0);
            if (pageIndexer != null) {
                pi.setPageIndex(pageIndexer);
            }
            List<OpenStatus> openStatuses = cardService.getOpenStatusList(pi);
            model.addAttribute("openStatuses", openStatuses);
            model.addAttribute("pi", pi);
        }else{
            model.addAttribute("msg","请登录，<a href='manager/login.html'>前往登录</a>");
            url="error";
        }
        return url;
    }

    @GetMapping("searchOpenStatus/{userId}")
    protected String searchOpenStatus(@PathVariable("userId") Integer userId,Model model){
        System.out.println(userId);
        OpenStatus openStatus=cardService.searchOpenStatus(userId);
        model.addAttribute("openStatus",openStatus);
        return "addcard";
    }

    @RequestMapping("savecard.html")
    protected String saveCard(CreditCard creditCard, Model model, HttpSession session){
        String msg="请先登录后操作,<a href='manager/login.html'>前往登录</a>";
        String url="error";
        System.out.println();
        if(isLogin(session)!=null){
            url="addcard";
            msg="权限不足";
            if(isLogin(session)>1){
                if(cardService.addCard(creditCard)){
                    msg="操作成功";
                }else {
                    msg="操作失败";
                }
            }
        }
        model.addAttribute("msg",msg);
        return url;
    }

    @RequestMapping("deletecard.html")
    protected String delete(Integer userId,Model model,HttpSession session){
        String msg="请先登录后操作,<a href='manager/login.html'>前往登录</a>";
        String url="error";
        System.out.println("张三："+userId);
        if(isLogin(session)!=null){
            msg="权限不足";
            url="addcard";
            if(isLogin(session)>1) {
                if (cardService.cleanCard(userId)) {
                    msg = "操作成功";
                }else {
                    msg="操作失败";
                }
            }
        }
        model.addAttribute("msg",msg);
        return url;
    }


}
