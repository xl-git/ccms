<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Email地址设置页面</title>
</head>
<body>
    <center>
        <h2>Email地址设置</h2>
        个人账户的Email地址：${contactInfo.email}
        <a href="/customermanage/updateemail.html">修改</a>
    </center>
</body>
</html>