package com.szit.eurekamanager.controller;

import com.alibaba.fastjson.JSONArray;
import com.szit.eurekamanager.pojo.*;
import com.szit.eurekamanager.service.AdminService;
import com.szit.eurekamanager.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 访问工作人员登录页面
     * @return
     */
    @RequestMapping("/login.html")
    protected String login(){
        return "workerlogin";
    }


    /**
     * 工作人员登录
     * @param admin
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/dologin.html")
    protected String dologin(Admin admin, @RequestParam("anum")String anum,
                             @RequestParam("aPassword") String password, Model model, HttpSession session){
        admin.setAdminName(anum);
        admin.setAdminPwd(password);
        System.out.println(anum);
        System.out.println(password);
        String url="workerlogin";
        if(anum!=null && !anum.equals("")){
            if(password!=null && !password.equals("")){
                boolean flag=adminService.adminLogin(admin);
                if(flag){
                    session.setAttribute("loginAdmin",admin);
                    url="redirect:workermain.html";
                }else{
                    model.addAttribute("admin",admin);
                    model.addAttribute("message","账号或密码错误，请重新输入！");
                }
            }else {
                model.addAttribute("message","请输入密码！");
            }
        }else {
            model.addAttribute("message","请输入账号！");
        }

        return url;
    }

    /**
     * 访问工作人员主页
     * @return
     */
    @GetMapping("/workermain.html")
    protected String visitWorkerMain(){
        return "index";
    }

    /**
     * 访问工作人员主页
     * @return
     */
    @GetMapping("/welcome.html")
    protected String welcome(){
        return "welcome";
    }

    /**
     * 访问修改页面
     * @return
     */
    @RequestMapping("/update.html")
    protected String update(HttpSession session ,Model model){
        Admin admin = (Admin)(session.getAttribute("loginAdmin"));
        String url = "welcome";
        if(admin!=null){
            url = "update";
        }else{
            model.addAttribute("message","请登录！");
        }
        return url;
    }

    /**
     * 访问激活页面
     * @return
     */
    @RequestMapping("/activation.html")
    protected String activate(){
        return "activation";
    }

    /**
     * 通过账号查找信用卡信息
     * @param cardNum
     */
    @RequestMapping("/findcard.html")
    protected String findCard(@RequestParam(value = "cnum",required = false) String cardNum, Model model){
        CreditCard card = adminService.searchCard(cardNum);
        model.addAttribute("cardNum",cardNum);
        model.addAttribute("card",card);
        return "update";

    }

    /**
     * 访问修改密码页面
     * @return
     */
    @RequestMapping("/updatetradpassword.html")
    protected String updateTradPassword(@RequestParam("cnum") String cnum, Model model){
        CreditCard card = adminService.searchCard(cnum);
        model.addAttribute("card",card);
        return "updatepwd";
    }

    /**
     * 修改交易密码
     * @param card
     * @param tradPassword
     * @param model
     * @param session
     * @param response
     */
    @RequestMapping("/updatepwd.html")
    protected void updatePwd(CreditCard card, @RequestParam("reNewPassword")Integer tradPassword,
                             Model model,@RequestParam("cardNum") String cardNum, HttpSession session, HttpServletResponse response){
        Map<String,String> resultMap = new HashMap<String,String>();
        card.setPayPassword(tradPassword);
        card.setCardNum(cardNum);
        if(adminService.updatePwd(card)){
            resultMap.put("result","true");
        }else{
            session.setAttribute("message","系统异常，修改失败！");
            resultMap.put("result","false");
        }
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

    /**
     * 访问修改资料页面
     * @return
     */
    @RequestMapping("/updatematerial.html")
    protected String updateMaterial(@RequestParam("cnum") String cnum, Model model){
        CreditCard card = adminService.searchCard(cnum);
        model.addAttribute("card",card);
        return "updatematerial";

    }

    @RequestMapping("/doupdatematerial.html")
    protected void doUpdateMaterial(@RequestParam("email")String email,CreditCard creditCard,@RequestParam("cnum")String cardNum
                                      ,BaseInfo baseInfo,UnitInfo unitInfo,HttpServletRequest request,Model model,HttpServletResponse response) throws IOException {
        baseInfo.setFamilyAddress(request.getParameter("familyAddress"));
        baseInfo.setHomeAddress(request.getParameter("homeAddress"));
        baseInfo.setIphoneNum(request.getParameter("iphoneNum"));
        baseInfo.setEducation(request.getParameter("education"));
        unitInfo.setUnitAddress(request.getParameter("unitAddress"));
        unitInfo.setUnitIphone(request.getParameter("unitIphone"));
        creditCard.setCardNum(request.getParameter("cnum"));
        String url="";
        if(!adminService.updateEmail(email,cardNum) || !adminService.updateBaseInfo(baseInfo,creditCard)
                || !adminService.updateUnit(unitInfo,creditCard)){
            response.getWriter().write("<script>alert('系统异常，修改失败！'); window.location='updatematerial.html'; window.close();</script>");

        }
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        if(adminService.relieve(cardNum)){
            response.getWriter().write("<script>alert('修改成功！'); window.location='findcard.html'; window.close();</script>");
        }

        response.getWriter().flush();
    }


    /**
     * 访问挂失页面
     * @return
     */
    @RequestMapping("/losehandle.html")
    protected String losehandel(HttpSession session ,Model model){
        Admin admin = (Admin)(session.getAttribute("loginAdmin"));
        String url = "welcome";
        if(admin!=null){
            url = "losehandle";
        }else{
            model.addAttribute("message","请登录！");
        }
        return url;
    }

    /**
     * 查找信用卡挂失信息
     * @param identityCard
     * @param model
     * @return
     */
    @RequestMapping("/findlose.html")
    protected String findlose(@RequestParam(value = "identityCard" ,required = false)String identityCard,@RequestParam(value = "pageIndex",required = false) Integer pageIndex,
                              Model model){
        String url = "losehandle";
        String message = "未找到信息，请重新输入！";
        PageIndexer page = new PageIndexer(1, 1, 0, 0);
        if (pageIndex != null) {
            page.setPageIndex(pageIndex);
        }
        List<CreditCard> creditCards = adminService.searchCardByIdentityCard(identityCard,page);
        if(creditCards!=null){
            model.addAttribute("pi", page);
            model.addAttribute("cards",creditCards);
            model.addAttribute("identityCard",identityCard);
            message = "找到信息如下:";
            url = "losehandle";
        }
        model.addAttribute("message",message);
        return url;
    }

    /**
     * 查找信用卡冻结信息
     * @param identityCard
     * @param model
     * @return
     */
    @RequestMapping("/findfreeze.html")
    protected String findfreeze(@RequestParam("identityCard")String identityCard,@RequestParam(value = "pageIndex",required = false) Integer pageIndex,
                                Model model){
        String url = "freeze";
        String message = "未找到信息，请重新输入！";
        PageIndexer page = new PageIndexer(1, 1, 0, 0);
        if (pageIndex != null) {
            page.setPageIndex(pageIndex);
        }
        List<CreditCard> creditCards = adminService.searchCardByIdentityCard(identityCard,page);
        if(creditCards!=null){
            model.addAttribute("pi", page);
            model.addAttribute("cards",creditCards);
            model.addAttribute("identityCard",identityCard);
            message = "找到信息如下:";
            url = "freeze";
        }
        model.addAttribute("message",message);
        return url;
    }

    /**
     * 查找信用卡销户信息
     * @param identityCard
     * @param model
     * @return
     */
    @RequestMapping("/findcancel.html")
    protected String findcancel(@RequestParam("identityCard")String identityCard,@RequestParam(value = "pageIndex",required = false) Integer pageIndex,
                                Model model){
        String url = "cancel";
        String message = "未找到信息，请重新输入！";
        PageIndexer page = new PageIndexer(1, 1, 0, 0);
        if (pageIndex != null) {
            page.setPageIndex(pageIndex);
        }
        List<CreditCard> creditCards = adminService.searchCardByIdentityCard(identityCard,page);
        if(creditCards!=null){
            model.addAttribute("pi", page);
            model.addAttribute("cards",creditCards);
            model.addAttribute("identityCard",identityCard);
            message = "找到信息如下:";
            url = "cancel";
        }
        model.addAttribute("message",message);
        return url;
    }

    /**
     * 查找信用卡激活信息
     * @param cardNum
     * @param model
     * @return
     */
    @RequestMapping("/findactivate.html")
    protected String findactivate(@RequestParam(value = "cardNum",required = false)String cardNum,Model model){
        String url = "activate";
        String message = "未找到信息，请重新输入！";
        CreditCard creditCard = adminService.searchCard(cardNum);
        if(creditCard!=null){
            model.addAttribute("card",creditCard);
            model.addAttribute("cardNum",cardNum);
            message = "找到信息如下:";
            url = "activate";
        }
        model.addAttribute("message",message);
        return url;
    }

    /**
     * 挂失
     * @param cardNum
     * @return
     */
    @RequestMapping("/lossing.html")
    protected String lossing(@RequestParam("cardNum")String cardNum,@RequestParam("phone")String phone,
                             @RequestParam("identityCard")String identityCard, Model model){
        String url = "losehandle";
        if(adminService.loseHandle(cardNum)) {
            String host = "https://zwp.market.alicloudapi.com";
            String path = "/sms/sendv2";
            String method = "GET";
            String appcode = "7ab866a47701479e9e89ed1d7128180f";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            Map<String, String> querys = new HashMap<String, String>();
            querys.put("content", "【云通知】您的验证码是已挂失。如非本人操作，请忽略本短信");
            querys.put("mobile", phone);
            try {
                HttpResponse res = HttpUtils.doGet(host, path, method, headers, querys);
                System.out.println(res.toString());
                //获取response的body
                //System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (Exception e) {
                e.printStackTrace();
            }

            url= "redirect:findlose.html?identityCard="+identityCard;
        }else {
            model.addAttribute("message","系统错误，操作失败！");
        }
            return url;
    }

    /**
     * 解除挂失
     * @param cardNum
     * @return
     */
    @RequestMapping("/relievelose.html")
    protected String relievelose(@RequestParam("cardNum")String cardNum,@RequestParam("identityCard")String identityCard,Model model){
        String url = "losehandle";
        if(adminService.relieve(cardNum)){
            url= "redirect:findlose.html?identityCard="+identityCard;
        }
        return url;
    }

    /**
     * 访问销户页面
     * @return
     */
    @RequestMapping("/cancel.html")
    protected String cancel(HttpSession session ,Model model){
        Admin admin = (Admin)(session.getAttribute("loginAdmin"));
        String url = "welcome";
        if(admin!=null){
            if(admin.getGrade()==3){
                url = "cancel";
            }else{
                model.addAttribute("message","管理员权限不足！");
            }
        }else{
            model.addAttribute("message","请登录！");
        }
        return url;
    }

    /**
     * 销户
     * @param cardNum
     * @return
     */
    @RequestMapping("/canceling.html")
    protected String canceling(@RequestParam("cardNum")String cardNum,@RequestParam("phone")String phone,
                             @RequestParam("identityCard")String identityCard, Model model){
        String url = "cancel";
        if(adminService.cancel(cardNum)) {
            String host = "https://zwp.market.alicloudapi.com";
            String path = "/sms/sendv2";
            String method = "GET";
            String appcode = "7ab866a47701479e9e89ed1d7128180f";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            Map<String, String> querys = new HashMap<String, String>();
            querys.put("content", "【云通知】您的验证码是已销户。如非本人操作，请忽略本短信");
            querys.put("mobile", phone);
            try {
                HttpResponse res = HttpUtils.doGet(host, path, method, headers, querys);
                System.out.println(res.toString());
                //获取response的body
                //System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (Exception e) {
                e.printStackTrace();
            }

            url= "redirect:findcancel.html?identityCard="+identityCard;
        }else {
            model.addAttribute("message","系统错误，操作失败！");
        }
        return url;
    }

    /**
     * 访问冻结页面
     * @return
     */
    @RequestMapping("/freeze.html")
    protected String freeze(HttpSession session ,Model model){
        Admin admin = (Admin)(session.getAttribute("loginAdmin"));
        String url = "welcome";
        if(admin!=null){
            if(admin.getGrade()==2 ||admin.getGrade()==3){
                url = "freeze";
            }else{
                model.addAttribute("message","管理员权限不足！");
            }
        }else{
            model.addAttribute("message","请登录！");
        }
        return url;
    }

    /**
     * 冻结
     * @param cardNum
     * @return
     */
    @RequestMapping("/freezing.html")
    protected String freezing(@RequestParam("cardNum")String cardNum,@RequestParam("phone")String phone,
                            @RequestParam("identityCard")String identityCard,Model model){
        String url = "freeze";
        if(adminService.freeze(cardNum)){
            String host = "https://zwp.market.alicloudapi.com";
            String path = "/sms/sendv2";
            String method = "GET";
            String appcode = "7ab866a47701479e9e89ed1d7128180f";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            Map<String, String> querys = new HashMap<String, String>();
            querys.put("content", "【云通知】您的验证码是已冻结。如非本人操作，请忽略本短信");
            querys.put("mobile", phone);
            try {
                HttpResponse res = HttpUtils.doGet(host, path, method, headers, querys);
                System.out.println(res.toString());
                //获取response的body
                //System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (Exception e) {
                e.printStackTrace();
            }

            url= "redirect:findfreeze.html?identityCard="+identityCard;
        }else {
            model.addAttribute("message","系统错误，操作失败！");
        }
        return url;
    }

    /**
     * 解冻
     * @param cardNum
     * @return
     */
    @RequestMapping("/relievefreeze.html")
    protected String relieveFreeze(@RequestParam("cardNum")String cardNum,@RequestParam("identityCard")String identityCard,Model model){
        String url = "freeze";
        if(adminService.relieve(cardNum)){
            url= "redirect:findfreeze.html?identityCard="+identityCard;
        }
        return url;
    }

    /**
     * 访问激活页面
     * @return
     */
    @RequestMapping("/activate.html")
    protected String activate(HttpSession session ,Model model){
        Admin admin = (Admin)(session.getAttribute("loginAdmin"));
        String url = "welcome";
        if(admin!=null){
            url = "activate";
        }else{
            model.addAttribute("message","请登录！");
        }
        return url;
    }

    /**
     * 激活
     * @param cardNum
     * @return
     */
    @RequestMapping("/actiavtion.html")
    protected void actiavtion(@RequestParam("cardNum")String cardNum,@RequestParam("phone")String phone,HttpServletResponse res){
        Map<String,String> resultMap = new HashMap<String,String>();
        if(adminService.relieve(cardNum)){
            String param;
            String host = "https://zwp.market.alicloudapi.com";
            String path = "/sms/sendv2";
            String method = "GET";
            String appcode = "7ab866a47701479e9e89ed1d7128180f";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            Map<String, String> querys = new HashMap<String, String>();
            querys.put("content", "【云通知】您的验证码是已激活。如非本人操作，请忽略本短信");
            querys.put("mobile", phone);
            try {
                HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
                System.out.println(response.toString());
                //获取response的body
                //System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (Exception e) {
                e.printStackTrace();
            }

            resultMap.put("result","true");
            res.setContentType("application/json");
            PrintWriter out = null;
            try{
                out = res.getWriter();
            }catch (IOException e){
                e.printStackTrace();
            }
            out.write(JSONArray.toJSONString(resultMap));
            out.flush();
            out.close();
        }else {
            resultMap.put("result","false");
        }
    }


    @RequestMapping("/noactivate.html")
    protected String noactivate(Model model,@RequestParam(value = "message",required = false)String message,
                                @RequestParam(value = "pageIndex",required = false) Integer pageIndex){
        PageIndexer page = new PageIndexer(1, 15, 0, 0);
        if (pageIndex != null) {
            page.setPageIndex(pageIndex);
        }

        List<Noactivate> noactivates = adminService.ActivateLists(page);
        if(noactivates!=null) {
            model.addAttribute("pi", page);
            model.addAttribute("message", message);
            model.addAttribute("noactivates", noactivates);
        }
        return "noactivate";
    }

    /**
     *
     * @param cardNum
     * @return
     */
    @RequestMapping("/activating.html")
    protected void act(@RequestParam("cardNum")String cardNum,Model model,HttpServletResponse response) throws IOException {
        String url = "noactivate";
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        if(adminService.relieve(cardNum)){
            response.getWriter().write("<script>alert('激活成功！'); window.location='noactivate.html'; window.close();</script>");
        }

        response.getWriter().flush();
    }

    /**
     * 操作成功页面
     * @return
     */
    @RequestMapping("/success.html")
    protected String success(){
        return "success";
    }

}
