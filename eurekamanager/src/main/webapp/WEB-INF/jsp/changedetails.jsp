<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#remind").bind("click", function () {
                $.ajax({
                    type: "GET",//请求类型
                    url: "/manager/changeremiand.html",//请求的url
                    data: {method: "changeRemind",phone: $("#phone").val()},//请求参数
                    dataType: "json",//ajax接口（请求url）返回的数据类型
                    success: function (data) {//data：返回数据（json对象）
                        if (data.result == "true") {
                            alert("信息已发送！")
                            window.location.href="/manager/changedetails.html?cardNum=${card.cardNum}&changeDate=<fmt:formatDate value="${card.changePeriods.changeDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                        }else{
                            alert("操作失败！")
                            window.location.href="/manager/changedetails.html?cardNum=${card.cardNum}&changeDate=<fmt:formatDate value="${card.changePeriods.changeDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                        }
                    }
                });
            });
        })
    </script>
</head>
<body>
<table cellpadding="0" cellspacing="0" border="1" style="text-align: center">
    <tr>
        <td>分期金额</td>
        <td><fmt:formatNumber value="${card.changePeriods.amount}" pattern="#.00" type="number" /></td>
    </tr>
    <tr>
        <td>分期期数</td>
        <td>${card.changePeriods.periodsId}</td>
    </tr>
    <tr>
        <td>分期日期</td>
        <td><fmt:formatDate value="${card.changePeriods.changeDate}" pattern="yyyy-MM-dd"/></td>
    </tr>
    <tr>
        <td>利息</td>
        <td>
            <c:if test="${card.changePeriods.periodsId==3}"><fmt:formatNumber value="${card.changePeriods.amount*0.0195}" pattern="#.00" type="number" /></c:if>
            <c:if test="${card.changePeriods.periodsId==6}"><fmt:formatNumber value="${card.changePeriods.amount*0.036}" pattern="#.00" type="number" /></c:if>
            <c:if test="${card.changePeriods.periodsId==12}"><fmt:formatNumber value="${card.changePeriods.amount*0.072}" pattern="#.00" type="number" /></c:if>
        </td>
    </tr>
    <tr>
        <td>应还款金额</td>
        <td>
            <c:if test="${card.changePeriods.periodsId==3}"><fmt:formatNumber value="${card.changePeriods.amount*(1+0.0195)}" pattern="#.00" type="number" /></c:if>
            <c:if test="${card.changePeriods.periodsId==6}"><fmt:formatNumber value="${card.changePeriods.amount*(1+0.036)}" pattern="#.00" type="number" /></c:if>
            <c:if test="${card.changePeriods.periodsId==12}"><fmt:formatNumber value="${card.changePeriods.amount*(1+0.072)}" pattern="#.00" type="number" /></c:if>
        </td>
    </tr>
    <tr>
        <td>状态</td>
        <td>
            <c:if test="${card.changePeriods.changeStatus==1}">未还</c:if>
            <c:if test="${card.changePeriods.changeStatus==2}">已还</c:if>
        </td>
    </tr>
</table>
<div>
    <input type="hidden" id="phone" value="${card.baseInfo.iphoneNum}">
    <input type="hidden" id="cardNum" value="${card.cardNum}">
    <input type="button" id="remind" value="提醒还款">
</div>
</body>
</html>