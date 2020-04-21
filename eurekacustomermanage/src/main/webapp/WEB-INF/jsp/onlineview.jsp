<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>网上申请进度查询显示页面</title>
</head>
<body>
<h2>网上申请进度查询信息如下：</h2>
    <table border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>
                序号：
            </td>
            <td>
                <input type="text" name="cid" value="${card.cid}">
            </td>
        </tr>
        <tr>
            <td>
                卡号：
            </td>
            <td>
                <input  name="cNum" type="text" value="${card.cNum}"/>
            </td>
        </tr>
        <tr>
            <td>
                类型：
            </td>
            <td>
                <input type="text" name="cType" value="${card.cType}" />
            </td>
        </tr>
        <tr>
            <td>
                持卡人姓名：
            </td>
            <td>
                <input type="text" name="cardHolderName" value="${creditCardInfo.cardHolderName}">
            </td>
        </tr>
        <tr>
            <td>
                手机号：
            </td>
            <td>
                <input type="text" name="phone" value="${creditCardInfo.phone}">
            </td>
        </tr>
        <tr>
            <td>
                开卡状态：
            </td>
            <td>
                <input type="text" name="openStatus" value="${card.openStatus}">
            </td>
        </tr>
    </table>
</body>
</html>