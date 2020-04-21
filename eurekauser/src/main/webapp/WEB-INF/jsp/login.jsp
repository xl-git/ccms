<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>信用卡管理系统</title>
  <link href="./css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="./js/jQuery1.7.js"></script>
<script type="text/javascript" src="./js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="./js/jquery1.42.min.js"></script>
<script type="text/javascript" src="./js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="./js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="./js/common.js"></script>
<script type="text/javascript" src="./js/login.js"></script>
<script type="text/javascript">

</script>
  <script type="text/javascript">
    function refresh(obj) {
      obj.src = "/user/img.html?"+Math.random();
    }
  </script>
</head>

<body>
<div id="tab">
  <ul class="tab_menu">
    <li class="selected">用户名登录</li>
    <li>手机号登录</li>
    <li>用户注册</li>
  </ul>
  <div class="tab_box"> 
    <!-- 用户名登录开始 -->
    <div>
      <div class="stu_error_box" style="color: red"></div>
      <div style="color: red">${message}</div>
      <form action="/user/usernamelogin.html" method="post" class="user_login_error">
        <div id="username">
          <label>用户名：</label>
          <input type="text" id="user_username_hide" name="user_username_hide" value="" nullmsg="用户名不能为空！" datatype="s2-10" errormsg="用户名范围在2~10个字符之间！" sucmsg="用户名验证通过！"/>
          <!--ajaxurl="demo/valid.jsp"--> 
        </div>
        <div id="password">
          <label>密&nbsp;&nbsp;&nbsp;码：</label>
          <input type="password" id="user_password_hide" name="user_password_hide" value="" nullmsg="密码不能为空！" datatype="*6-20" errormsg="密码范围在6~20位之间！" sucmsg="密码验证通过！"/>
        </div>
        <div id="code">
          <label>验证码：</label>
          <input type="text" id="user_code_hide" name="user_code_hide"  value="" nullmsg="验证码不能为空！" datatype="*4-4" errormsg="验证码有6位数！" sucmsg="验证码验证通过！"/>
          <img id="image" name="image" src="/user/img.html" onclick="javascript:refresh(this);"/>
        </div>
        <div id="login">
          <button type="submit">登录</button>
        </div>
      </form>
    </div>
   <!-- 学生登录结束-->
    <jsp:include page="phone.jsp"/>
    <jsp:include page="register.jsp"/>
  </div>
</div>
<div class="bottom">©2020 Leting <a href="javascript:;" target="_blank">关于</a> <span>京ICP证030173号</span><img width="13" height="16" src="images/copy_rignt_24.png" /></div>
<div class="screenbg">
  <ul>
    <li><a href="javascript:;"><img src="images/0.jpg"></a></li>
    <li><a href="javascript:;"><img src="images/1.jpg"></a></li>
    <li><a href="javascript:;"><img src="images/2.jpg"></a></li>
  </ul>
</div>
</body>
</html>
