 <%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>基本账户信息页面</title>
</head>
<body>
<h2>基本账户信息</h2>
<table border="1" cellpadding="0" cellspacing="0">
    <tr>
        <td>
            币种：
        </td>
        <td>
            <input name="currency" type="text" value="${card.currency}"  />
        </td>
    </tr>
    <tr>
        <td>
            信用额度：
        </td>
        <td>
            <input name="lineCredit" type="text" value="${card.lineCredit}"  />
        </td>
    </tr>
    <tr>
        <td>
            <a href="">可用额度：</a>
        </td>
        <td>
            <input name="availableCredit" type="text" value="${card.availableCredit}"  />
        </td>
    </tr>
    <tr>
        <td>
            预借现金可用额度：
        </td>
        <td>
            <input name="cardCash" type="text" value="${card.cardCash}"  />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <a href="">每月账单：</a>
        </td>
    </tr>
    <tr>
        <td>
            本期到期还款日：
        </td>
        <td>
            <fmt:formatDate value="${sysdate}" pattern="yyyy-MM-dd"/>
        </td>
    </tr>
</table>
</body>
</html>