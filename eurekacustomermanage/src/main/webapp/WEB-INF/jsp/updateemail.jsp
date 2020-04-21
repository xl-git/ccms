<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Email地址修改页面</title>
</head>
<body>
<h2>修改Email地址</h2>
<form action="/updateemail.html" method="post" enctype="multipart/form-data">
    <table border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>
                Email地址：
            </td>
            <td>
                <input id="email" name="email" type="text" value="${c.email}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" name="btnSubmit" value="确认修改" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>