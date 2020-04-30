<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<div>
    <div class="search">
        <form method="post" action="${pageContext.request.contextPath }/changelists.html">
            <input type="hidden" name="pageIndex" value="1"/>
            卡号：<input type="text" id="cardNum" name="cardNum" value="${cardNum}"/><input type="submit" value="搜索"/>
        </form>
    </div>
    <table cellpadding="0" cellspacing="0" border="1" style="text-align: center">
        <tr>
            <td>序 号</td>
            <td>姓 名</td>
            <td>卡 号</td>
            <td>分期总额</td>
            <td>分期期数</td>
            <td>分期日期</td>
            <td>详 情</td>
        </tr>
        <c:forEach var="change" items="${changeList}" varStatus="status">
            <tr>
                <td>${requestScope.offset+status.index+1}</td>
                <td>${change.baseInfo.name}</td>
                <td>${change.cardNum}</td>
                <td>${change.changePeriods.amount}</td>
                <td>${change.changePeriods.periodsId}</td>
                <td><fmt:formatDate value='${change.changePeriods.changeDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
                <td><a href="/manager/changedetails.html?cardNum=${change.cardNum}&changeDate=<fmt:formatDate value='${change.changePeriods.changeDate}' pattern='yyyy-MM-dd HH:mm:ss'/>">详情</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<input type="hidden" id="totalPageCount" value="${pi.pageCount}"/>
<c:import url="rollpage.jsp">
    <c:param name="totalCount" value="${totalCount}"/>
    <c:param name="currentPageNo" value="${currentPageNo}"/>
    <c:param name="totalPageCount" value="${totalPageCount}"/>
</c:import>
</body>
</html>