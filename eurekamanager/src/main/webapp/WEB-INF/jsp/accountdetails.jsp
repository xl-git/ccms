<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>账户详情</title>
</head>
<body>
    <div>
        <form>
            <table cellpadding="0" cellspacing="0" border="1" style="text-align: center">
                <tr>
                    <td>账 号</td>
                    <td>${accountDetail.cardNum}</td>
                </tr>
                <tr>
                    <td>用户姓名</td>
                    <td>${accountDetail.baseInfo.name}</td>
                </tr>
                <tr>
                    <td>身份证号</td>
                    <td>${accountDetail.baseInfo.identityCard}</td>
                </tr>
                <tr>
                    <td>交易密码</td>
                    <td>${accountDetail.payPassword}</td>
                </tr>
                <tr>
                    <td>手机号码</td>
                    <td>${accountDetail.baseInfo.iphoneNum}</td>
                </tr>
                <tr>
                    <td>住 址</td>
                    <td>${accountDetail.baseInfo.homeAddress}</td>
                </tr>
                <tr>
                    <td>信用卡额度</td>
                    <td><fmt:formatNumber value="${accountDetail.useableLimit}" pattern="#0.00" type="number"/></td>
                </tr>
                <tr>
                    <td>婚姻状况</td>
                    <td><c:if test="${accountDetail.baseInfo.marriage==1}">未婚</c:if>
                        <c:if test="${accountDetail.baseInfo.marriage==2}">已婚</c:if>
                        <c:if test="${accountDetail.baseInfo.marriage==3}">离异</c:if>
                        <c:if test="${accountDetail.baseInfo.marriage==4}">丧偶</c:if>
                    </td>
                </tr>
                <tr>
                    <td>受教育程度</td>
                    <td>
                        <c:if test="${accountDetail.baseInfo.education==1}">小学</c:if>
                        <c:if test="${accountDetail.baseInfo.education==2}">初中</c:if>
                        <c:if test="${accountDetail.baseInfo.education==3}">高中</c:if>
                        <c:if test="${accountDetail.baseInfo.education==4}">专科</c:if>
                        <c:if test="${accountDetail.baseInfo.education==5}">本科</c:if>
                        <c:if test="${accountDetail.baseInfo.education==6}">研究生及以上</c:if>
                    </td>
                </tr>
                <tr>
                    <td>安全问题</td>
                    <td>${accountDetail.question.question}</td>
                </tr>
                <tr>
                    <td>预留答案</td>
                    <td>${accountDetail.baseInfo.answer}</td>
                </tr>
                <tr>
                    <td>年收入</td>
                    <td><fmt:formatNumber value="${accountDetail.unitInfo.yearIncome}" pattern="#0.00" type="number"/></td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>