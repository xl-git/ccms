<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="utf-8">
    <title>在线挂失</title>
</head>

<body>
<form action="${pageContext.request.contextPath }/removecard.html" method="post">
    <table>
        <tr>
            <td>销卡账号：</td>
            <td>
                <input type="text" name="cardNum" value="${querycardNum}">
            </td>
        </tr>
        <tr>
            <td>身份证号码：</td>
            <td>
                <input type="text" name="identityCard" value="${queryidentityCard}">
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type="password" name="payPassword" value="${querypayPassword}">
            </td>
        </tr>
        <tr>
            <td>电话号码：</td>
            <td>
                <input type="text" name="iphoneNum" value="${queryiphoneNum}">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="sub" value="销卡">
            </td>
            <td>
                <input type="reset" name="res" value="取消">
            </td>
        </tr>
    </table>
</form>
</body>
</html