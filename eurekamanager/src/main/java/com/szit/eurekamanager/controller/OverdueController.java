package com.szit.eurekamanager.controller;

import com.alibaba.fastjson.JSONArray;
import com.szit.eurekamanager.pojo.Admin;
import com.szit.eurekamanager.pojo.CreditCard;
import com.szit.eurekamanager.pojo.PageIndexer;
import com.szit.eurekamanager.service.OverdueService;
import com.szit.eurekamanager.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OverdueController {
    @Autowired
    private OverdueService overdueService;

    /**
     * 分页列出逾期信息
     * @param cardNum
     * @param pageIndex
     * @param model
     * @return
     */
    @RequestMapping("/overduelists.html")
    protected String listByPage(@RequestParam(value = "cardNum",required = false) String cardNum, @RequestParam(value = "pageIndex",required = false) Integer pageIndex,
                                Model model,HttpSession session) {

        Admin admin = (Admin)(session.getAttribute("loginAdmin"));
        String url = "welcome";
        if(admin!=null){
            PageIndexer page = new PageIndexer(1, 1, 0, 0);
            if (pageIndex != null) {
                page.setPageIndex(pageIndex);
            }
            List<CreditCard> lists = overdueService.searchOverdueByPage(cardNum, page);

            Date date =new Date();
            // 保存状态
            model.addAttribute("overList", lists);
            model.addAttribute("pi", page);
            model.addAttribute("cardNum", cardNum);
            model.addAttribute("date", date);
            url = "overdue";
        }else{
            model.addAttribute("message","请登录！");
        }
        return url;
    }

    @RequestMapping("/remind.html")
    protected void remind(@RequestParam("phone")String phone, HttpServletResponse response){
        Map<String,String> resultMap = new HashMap<>();
        String host = "https://zwp.market.alicloudapi.com";
        String path = "/sms/sendv2";
        String method = "GET";
        String appcode = "7ab866a47701479e9e89ed1d7128180f";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("content", "【云通知】您的验证码是已逾期。如非本人操作，请忽略本短信");
        querys.put("mobile", phone);
        try {
            HttpResponse res = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(res.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        resultMap.put("result","true");
        response.setContentType("application/json");
        PrintWriter out = null;
        try{
            out = response.getWriter();
        }catch (IOException e){
            e.printStackTrace();
        }
        out.write(JSONArray.toJSONString(resultMap));
        out.flush();
        out.close();
    }
}
