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
<center>
    <h2>修改Email地址</h2>
    <form action="/customermanage/updateemail.html" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>Email地址：</td>
                <td><input name="queryEmail" type="text" value="${queryEmail}"/></td>
            </tr>
            <tr></tr>
            <tr>
                <td><input type="submit" name="btnSubmit" value="确认修改" /></td>
                <td><input type="reset" name="btnReset" value="取消修改"/></td>
            </tr>
        </table>
        <div style="color: red;">${msg}</div>
    </form>
</center>
</body>
</html>