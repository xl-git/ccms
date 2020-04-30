<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>分期申请信息</title>

</head>
<body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/applyinfo.js"></script>
<h2>请填写以下分期申请的信息：</h2></br>
<form action="${pageContext.request.contextPath }/doapply.html" method="post">
    <input type="hidden" name="cardId" value="${creditCard.id}">
    <input type="hidden" id="lendmoney" value="${money}">
<table>
    <tr>
        <td>信用卡账号:</td>
        <td>${creditCard.cardNum}</td>
    </tr>
    <tr>
        <td>账户总金额:</td>
        <td>${creditCard.creditLimit}</td>
    </tr>
    <tr>
        <td>账单月份:</td>
        <td>${month}</td>
    </tr>
    <tr>
        <td>最高可分期金额:</td>
        <td>${maxpaymoney}</td>
    </tr>
    <tr>
        <td>可选期数:</td>
        <td>
            <select name="periodsId">
                <option value="1">
                    三期
                </option>
                <option value="2">
                    六期
                </option>
                <option value="3">
                    九期
                </option>
            </select>
        </td>
    </tr>
    <tr>
        <td>申请分期金额:</td>
        <td>
            <input type="text" id="amount" name="amount" />
        </td>
    </tr>
    <tr>
        <td>账单剩余应还:</td>
        <td>
            <span id="money">${money}</span>
        </td>
    </tr>
</table>
    <input type="submit" value="提交">
</form>
<span>${msg}</span>
</body>
</html>