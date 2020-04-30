<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="utf-8">
    <title>修改交易密码</title>
</head>

<body>
<form action="${pageContext.request.contextPath }/updatepaypassword.html" method="post">
    <table>
        <tr>
            <td>卡号：</td>
            <td>
                <input type="text" name="cardNum" value="">
            </td>
        </tr>

        <tr>
            <td>原始密码：</td>
            <td>
                <input type="password" name="oldPassword" value="">
            </td>
        </tr>
        <tr>
            <td>新密码：</td>
            <td>
                <input type="password" name="newPassword" value="">
            </td>
        </tr>
        <tr>
            <td>确认新密码：</td>
            <td>
                <input type="password" name="payPassword" value="">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="sub" value="确认修改">
            </td>
            <td>
                <input type="reset" name="res" value="取消">
            </td>
        </tr>
    </table>
</form>
</body>
</html>