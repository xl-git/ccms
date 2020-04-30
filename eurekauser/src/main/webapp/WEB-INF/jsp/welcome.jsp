<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="utf-8" />
    <title>
        信用卡管理系统
    </title>
    <meta name="renderer" content="webkit" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="format-detection" content="telephone=no" />
    <link rel="stylesheet" href="./css/x-admin.css" media="all" />
    <link rel="stylesheet" href="./lib/bootstrap/css/bootstrap.css" media="all" />
</head>
<body>
<style type="text/css">
    legend { display: block; width:100px; border-bottom:0px; font-family: "Microsoft YaHei","Helvetica Neue";}
    legend a{ color:#666;} legend a:hover{ text-decoration:none;}
    .layui-table{ font-family: "Microsoft YaHei","Helvetica Neue";}
</style>
<div class="x-body">
    <blockquote class="layui-elem-quote">
        <sapn>${loginUser.userName}</sapn>欢迎使用信用卡管理系统！
        <span class="f-14"></span> &nbsp;&nbsp;  上次登录时间：
        <span style="color: #FF5722; font-family: 'yjsz';font-size: 2rem">${lasttime}</span>
    </blockquote>
</div>
</body>
</html>