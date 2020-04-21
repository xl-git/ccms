<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<!-- 手机号登录开始-->
<div class="hide">
    <div  class="tea_error_box" style="color: red"></div>
    <div id="message" style="color: red">${message}</div>
    <font style="color: red"></font>
    <form action="/user/phonelogin.html" method="post" class="phone_login_error">
        <div id="telphone">
            <label>手机号：</label>
            <input type="text" id="phone" name="phone" value="" nullmsg="手机号不能为空！" datatype="*11-11" errormsg="手机号有11位！" sucmsg="手机号验证通过！"/>

            <!--ajaxurl="demo/valid.jsp"-->
        </div>

        <div id="code">
            <label>验证码：</label>
            <input type="text" id="phone_code" name="phone_code"  value="" nullmsg="验证码不能为空！" datatype="*6-6" errormsg="验证码有6位数！" sucmsg="验证码验证通过！"/>
            <input type="button" name="securityCode" id="securityCode" value="获取验证码"/>
        </div>
        <div id="login">
            <button type="submit">登录</button>
        </div>
    </form>
</div>
<!-- 导师登录结束-->