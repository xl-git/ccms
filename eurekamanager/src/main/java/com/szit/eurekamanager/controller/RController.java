package com.szit.eurekamanager.controller;

import com.szit.eurekamanager.pojo.*;
import com.szit.eurekamanager.service.RService;
import com.szit.eurekamanager.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @authorp
 */
@Controller
public class RController {
    @Autowired
    private RService rService;


    @RequestMapping("/repayment.html")
    public String repayment(Model model, @RequestParam(value = "cardNum" ,required = false) String cardNum,
                            @RequestParam(value = "identityId",required = false) String indentityId,@RequestParam(value = "pageIndex" ,required = false
    )Integer pageIndex){
        String url="";

        PageIndexer page = new PageIndexer(1, 1, 0, 0);
        if (pageIndex != null) {
            page.setPageIndex(pageIndex);
        }

        List<Repayment> repayments=rService.getRepayments(cardNum,indentityId,page);

        //最迟还款日

        model.addAttribute("cardNum",cardNum);
        model.addAttribute("indentityId",indentityId);
        model.addAttribute("pi",page);
        model.addAttribute("repayments",repayments);

        url="repayment";
        return url;
    }

    /**
     *
     * 手机接收验证码
     * @param phone
     * @param res
     * @param session
     */
    @RequestMapping("/getphonecode.html")
    protected String getphonecode(@RequestParam(value = "phone")String phone , HttpServletResponse res, HttpSession session) {
        String url="success";
        String host = "https://zwp.market.alicloudapi.com";
        String path = "/sms/sendv2";
        String method = "GET";
        String appcode = "9ca44a091f7a420a9d39cb4e82ea5fc5";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("content","【云通知】您的验证码是还钱。如非本人操作，请忽略本短信");
        querys.put("mobile", phone);
//        session.setAttribute("param",param);

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }




    public RService getrService() {
        return rService;
    }

    public void setrService(RService rService) {
        this.rService = rService;
    }

    //    public void aVoid(){
//        new DateTime(new Date()).plusMonths(1);
//    }
}
