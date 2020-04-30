<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8" />
<title>登录</title>
<link rel="stylesheet" href="./css/index.css" />
</head>

<body>

<div class="top">信用卡后台管理登录</div>

<div class="content">
	<form action="/manager/dologin.html">
		<div class="login">

				<div class="title">信用卡后台管理&nbsp;·&nbsp;登录</div>
				<div class="line">
					账号:
					<input placeholder="请输入账号" type="text" name="anum" value="" />
				</div>
				<div class="line">
					密码:
					<input placeholder="请输入密码" type="password" name="aPassword" value=""/>
				</div>
				<button type="submit" class="logBut">登&nbsp;&nbsp;录</button>
				<div>${message}</div>
		</div>
	</form>
</div>
</body>
</html>