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
    <h2>Email地址设置</h2>
    <table border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>
                个人账户的Email地址：
            </td>
            <td>
                <input name="email" type="text" value="${card.email}">
            </td>
            <td>
                <a href="updateemail.html">修改</a>
            </td>
        </tr>
        <tr>
            <td>
                绑定手机号：
            </td>
            <td>
                <input type="text" name="phone" value="${creditCardInfo.phone}">
            </td>
        </tr>
    </table>
</body>
</html>