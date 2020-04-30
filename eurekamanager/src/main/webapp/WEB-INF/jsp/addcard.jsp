<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<div>
    <h2>信用卡申请信息</h2>
    <table width="75%">
        <tr>
            <td>姓名</td>
            <td>${openStatus.user.userName}</td>
        </tr>
        <tr>
            <td>卡类型</td>
            <td>
                <c:if test="${openStatus.cardType==1}">
                    普卡
                </c:if>
                <c:if test="${openStatus.cardType==2}">
                    金卡
                </c:if>
                <c:if test="${openStatus.cardType==3}">
                    白金卡
                </c:if>
            </td>
        </tr>
        <tr>
            <td>申请时间</td>
            <td>${openStatus.opDate}</td>
        </tr>
        <tr>
            <td>信用积分</td>
            <td>${openStatus.user.score}</td>
        </tr>
    </table>
</div>
<table>
        <tr>
            <td>
                <form action="/manager/savecard.html">
                    <input type="hidden" name="userId" value="${openStatus.userId}">
                    <input type="hidden" name="cardType" value="${openStatus.cardType}">
                    <input type="hidden" name="status" value="${openStatus.status}">
                    <input type="submit" value="同意">
                </form>
            </td>
            <td>
                <form action="/manager/deletecard.html">
                    <input type="hidden" name="userId" value="${openStatus.userId}">
                    <input type="hidden" name="cardType" value="${openStatus.cardType}">
                    <input type="hidden" name="status" value="${openStatus.status}">
                    <input type="submit" value="不同意">
                </form>
            </td>
        </tr>
</table>
<span style="color: #b5ff8d">${msg}</span>
</body>
</html>