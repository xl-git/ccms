package com.szit.eurekamanager.controller;

import com.szit.eurekamanager.pojo.*;
import com.szit.eurekamanager.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 访问账户首页面
     * @return
     */
    @RequestMapping("/accountmanage.html")
    protected String accountmanage(HttpSession session,Model model){
        Admin admin = (Admin)(session.getAttribute("loginAdmin"));
        String url = "welcome";
        if(admin!=null){
            url = "redirect:lists.html";
        }else{
            model.addAttribute("message","请登录！");
        }
        return url;
    }

    /**
     * 分页列出账户信息
     * @param cardNum
     * @param pageIndex
     * @param model
     * @return
     */
    @RequestMapping("/lists.html")
    protected String listByPage(@RequestParam(value = "cardNum",required = false) String cardNum,@RequestParam(value = "pageIndex",required = false) Integer pageIndex,
            Model model) {

        PageIndexer page = new PageIndexer(1, 15, 0, 0);
        if (pageIndex != null) {
            page.setPageIndex(pageIndex);
        }
        List<CreditCard> lists = accountService.listByPage(cardNum, page);

        // 保存状态
        model.addAttribute("accountList", lists);
        model.addAttribute("pi", page);
        model.addAttribute("cardNum", cardNum);

        return "accountmanage";
    }

    /**
     * 访问账户详情页面
     * @param cardNum
     * @param model
     * @return
     */
    @RequestMapping("/accountdetails.html")
    protected String accountDetails(@RequestParam String cardNum,Model model){
        CreditCard accountDetail = accountService.getAccountDetails(cardNum);
        model.addAttribute("accountDetail",accountDetail);
        return "accountdetails";
    }

    /**
     * 分页列出历史交易信息
     * @param cardNum
     * @param pageIndex
     * @param model
     * @return
     */
    @RequestMapping("/historytransaction.html")
    protected String listHistory(@RequestParam(value = "cardNum",required = false) String cardNum,@RequestParam(value = "pageIndex",required = false) Integer pageIndex,
                                Model model,HttpSession session) {
        Admin admin = (Admin)(session.getAttribute("loginAdmin"));
        String url = "welcome";
        if(admin!=null){
            PageIndexer page = new PageIndexer(1, 15, 0, 0);
            if (pageIndex != null) {
                page.setPageIndex(pageIndex);
            }
            List<CreditCard> lists = accountService.listHistoryTransactionsByPage(cardNum, page);

            // 保存状态
            model.addAttribute("transactionLists", lists);
            model.addAttribute("pi", page);
            model.addAttribute("cardNum", cardNum);
            url = "historytransaction";
        }else{
            model.addAttribute("message","请登录！");
        }

        return url;
    }

    @RequestMapping("/historydetails.html")
    protected String historyDetails(@RequestParam("transDate") String transDate,
                                    @RequestParam("cardNum") String cardNum, Model model){
        System.out.println(transDate);
        CreditCard card = accountService.searchHistoryDetails(transDate,cardNum);
        Date date = card.getTransaction().getTransDate();
        model.addAttribute("date",date);
        model.addAttribute("card",card);
        return "historydetails";
    }
}
