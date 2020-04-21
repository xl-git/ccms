<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<!-- 教务登录开始-->
<div class="hide">
    <div class="sec_error_box" style="color: red"></div>
    <div id="messages" style="color: red">${message}</div>
    <font style="color: red"></font>
    <form action="/user/register.html" method="post" class="sec_login_error">
        <div id="username">
            <label>用户名：</label>
            <input type="text" id="rusername" name="rusername" value="" nullmsg="用户名不能为空！" datatype="s2-10" errormsg="用户名范围在2~10个字符之间！" sucmsg="用户名验证通过！"/>
            <!--ajaxurl="demo/valid.jsp"-->
        </div>
        <div id="password">
            <label>密&nbsp;&nbsp;&nbsp;码：</label>
            <input type="password" id="upassword" name="upassword" value="" nullmsg="密码不能为空！" datatype="*6-20" errormsg="密码范围在6~20位之间！" sucmsg="密码验证通过！"/>
        </div>
        <div id="rpassword">
            <label>确认密码：</label>
            <input type="password" id="repassword" name="repassword" value="" nullmsg="确认密码不能为空！" datatype="*6-20" errormsg="" sucmsg="密码验证通过！"/>
        </div>
        <div id="telphone">
            <label>手机号：</label>
            <input type="text" id="rephone" name="rephone" value="" nullmsg="手机号不能为空！" datatype="*11-11" errormsg="手机号为11个字符！" sucmsg="手机号验证通过！"/>
            <!--ajaxurl="demo/valid.jsp"-->
        </div>
        <div id="code">
            <label>验证码：</label>
            <input type="text" id="sec_code_hide" name="sec_code_hide"  value="" nullmsg="验证码不能为空！" datatype="*6-6" errormsg="验证码有6位数！" sucmsg="验证码验证通过！"/>
            <input type="button" name="securityCode2" id="securityCode2" value="获取验证码">
        </div>
        <div id="login">
            <button type="submit">注册</button>
        </div>
    </form>
</div>
<!-- 教务登录结束-->