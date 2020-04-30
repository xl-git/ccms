package com.szit.eurekauser.controller;

import com.alibaba.fastjson.JSONArray;
import com.szit.eurekauser.pojo.User;
import com.szit.eurekauser.service.UserService;
import com.szit.eurekauser.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 用户控制器类
 *  @author  刘成发
 *  @version 1.0 2020.04.05
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 判断手机号是否存在
     * @param telphone
     * @param response
     */
    @RequestMapping("/isexisttelphone.html")
    protected void isExistTelphone(@RequestParam String telphone, HttpServletResponse response){
        Map<String,String> resultMap = new HashMap<String,String>();
       User user=userService.searchBytelphone(telphone);
        if(user!=null){
            resultMap.put("result","true");
        }else{
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
     * 通过手机号登录
     * @param phone
     * @param code
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/phonelogin.html")
    protected String phoneLogin(@RequestParam("phone")String phone,@RequestParam("phone_code")String code,
                                Model model,HttpSession session){
        String url="login";
        User user = userService.searchBytelphone(phone);
        if(user!=null) {
            if (code.equals(session.getAttribute("phoneCode"))) {
                session.setAttribute("loginUser", user);
                redisTemplate.opsForValue().set("loginUser",user.getUserName());
                url = "redirect:userindex.html";
            } else {
                model.addAttribute("phone", phone);
                model.addAttribute("message", "验证码错误！");
            }
        }
        return url;
    }

    /**
     * 判断用户名是否存在
     * @param userName
     * @param response
     */
    @RequestMapping(value = "/isexistusername.html",method = RequestMethod.GET)
    protected void isExistUserName(@RequestParam String userName, HttpServletResponse response){
        Map<String,String> resultMap = new HashMap<String,String>();
        boolean flag=userService.searchByUserName(userName);
        if(flag){
            resultMap.put("result","true");
        }else{
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


    public int r(int min,int max) {
        Random random = new Random();
        int num = 0;
        num = random.nextInt(max - min) + min;
        return num;
    }

    /**
     * 生成图片随机验证码
     * @return
     */
    @RequestMapping(value = "/img.html",method = RequestMethod.GET)
    protected void img(HttpSession session ,HttpServletResponse response) throws IOException {
        final char[] str = {'0','1','2','3','4','5','6','7','8','9',
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
                'r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H',
                'I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int width=85;
        int height=30;
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        g.setColor(new Color(200,200,200));
        g.fillRect(0, 0, width, height);
        Random rnd = new Random();
        StringBuffer sb = new StringBuffer("");
        //产生四位数的字母数字验证码，各个数字的颜色也随即
        for(int i=0; i<4; i++) {
            int num = rnd.nextInt(str.length);
            Color c = new Color(rnd.nextInt(256),
                    rnd.nextInt(256),rnd.nextInt(256));
            g.setColor(c);
            g.setFont(new Font("黑体", Font.PLAIN, 20));
            g.drawString(str[num]+"", 10+i*20, 20);
            sb.append(str[num]);
        }

        //划干扰线
        for(int i=0; i<4; i++) {
            Color c = new Color(rnd.nextInt(256),
                    rnd.nextInt(256),rnd.nextInt(256));
            g.setColor(c);
            g.drawLine(rnd.nextInt(width), rnd.nextInt(height),
                    rnd.nextInt(width), rnd.nextInt(height));
        }
         /*
         若是产生四位数字，则nextInt(8999) + 1000;
         然后String.valueOf转换为String
         */
        String s = new String(sb);
        //验证码存入session里，方便在登陆校检页比对
        session.setAttribute("loginCode",s);
        //System.out.println("yam"+session.getAttribute("loginCode"));
        g.dispose();//释放图像的上下文资源
        //输出到页面
        ImageIO.write(bi,"PNG",response.getOutputStream());
        response.getOutputStream().flush();//刷新输出流
        response.getOutputStream().close();//关闭输出流
    }

    /**
     * 获取手机动态验证码
     * @param phone
     * @param res
     */
    @RequestMapping("/getphonecode.html")
    protected void getphonecode(@RequestParam("phone")String phone ,HttpServletResponse res, HttpSession session) {
        String param;
        if(phone!=null && !phone.equals("")) {
            param = num();
            String host = "https://zwp.market.alicloudapi.com";
            String path = "/sms/sendv2";
            String method = "GET";
            String appcode = "7ab866a47701479e9e89ed1d7128180f";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            Map<String, String> querys = new HashMap<String, String>();
            querys.put("content", "【云通知】您的验证码是"+param+"。如非本人操作，请忽略本短信");
            querys.put("mobile", phone);
            session.setAttribute("phoneCode", param);
            System.out.println(session.getAttribute("phoneCode"));
            try {
                HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
                System.out.println(response.toString());
                //获取response的body
                //System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            res.setContentType("application/json");
            PrintWriter out = null;
            try {
                out = res.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.flush();
            out.close();
        }else {
            Map<String,String> resultMap = new HashMap<String,String>();
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
        }
    }

    /**
     * 手机动态码
     * @return
     */
    private String num() {
        int p = new Random().nextInt(899999) + 100000;
        String phoneCode = Integer.toString(p);
        return phoneCode;
    }

    /**
     * 用户注册
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/register.html")
    protected String doRegister(User user, @RequestParam("rusername")String name, @RequestParam("rephone")String phone,
                                @RequestParam("upassword")String password, @RequestParam("sec_code_hide")String code, Model model, HttpSession session){
        user.setUserPwd(password);
        user.setUserName(name);
        user.setTelphone(phone);
        String url="login";
        if(code.equals(session.getAttribute("phoneCode"))){
            boolean flag = userService.register(user);
            if(!flag){
                model.addAttribute("message","注册成功");
                url="login";
            }else{
                model.addAttribute("user",user);
                model.addAttribute("message","系统错误，注册失败！");
            }
        }else{
            model.addAttribute("user",user);
            model.addAttribute("message","手机验证码输入错误！");
        }
        return url;
    }

    /**
     * 访问登录页面
     * @return
     */
    @RequestMapping (value = "/login.html",method = RequestMethod.GET)
    protected String login(){
        return "login";
    }

    /**
     * 用户通过用户名和密码登录
     * @param user
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/usernamelogin.html")
    protected String doLogin(User user,@RequestParam("user_username_hide") String name,@RequestParam("user_password_hide") String userPassword,
                             @RequestParam("user_code_hide") String code, Model model, HttpSession session){
        String url="login";
        user.setUserName(name);
        user.setUserPwd(userPassword);
        if(code.equalsIgnoreCase(session.getAttribute("loginCode").toString())){
            boolean flag=userService.userLogin(user);
            if(flag){
                session.setAttribute("loginUser",user);
                redisTemplate.opsForValue().set("loginUser",user.getUserName());
                url="redirect:userindex.html";
            }else{
                model.addAttribute("user",user);
                model.addAttribute("message","用户名或密码错误，请重新登录！");
            }
        }else{
            model.addAttribute("user",user);
            model.addAttribute("message","验证码错误，请重新输入！");
        }

        return url;
    }
    /**
     * 访问用户主页面
     * @return
     */
    @RequestMapping (value = "/userindex.html",method = RequestMethod.GET)
    protected String userlogin()  {
        return "index";
    }

    @RequestMapping("/welcome.html")
    protected String welcome(HttpSession session,User user,Model model) {
        if(session.getAttribute("loginUser")!=null){
            user.setUserName(((User)session.getAttribute("loginUser")).getUserName());
            userService.update(user);
            String time=((User) session.getAttribute("loginUser")).getLoginDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            model.addAttribute("lasttime",time);
        }
        return "welcome";
    }
}
