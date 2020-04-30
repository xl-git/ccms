<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/24
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>还款操作页面</title>
</head>
<body>
<div class="search">
    <form method="post"
          action="${pageContext.request.contextPath }/repayment.html">
        卡号：<input name="cardNum" type="text" value="${cardNum}">
        身份证号：<input name="identityId" type="text" value="${identityId}">
        <input type="hidden" name="pageIndex" value="1"/>
        <input type="submit" value="搜索">
    </form>
</div>
        <table width="80%">
            <tr>
                <td>序号</td>
                <td>姓名</td>
                <td>卡号</td>
                <td>身份证</td>
                <td>还款金额</td>
                <td>还款日期</td>
                <td>申请日期</td>
                <td>操作</td>
            </tr>
            <tr>
                <c:forEach var="repayment" items="${repayments}" varStatus="index">
                    <td>${requestScope.offset + index.index + 1}</td>
                    <td>${repayment.baseInfo.name}</td>
                    <td>${repayment.creditCard.cardNum}</td>
                    <td>${repayment.baseInfo.identityCard}</td>
                    <td>${repayment.rmoney}</td>
                    <td><fmt:formatDate value="${repayment.duedate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${repayment.changePeriods.changeDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><a href="/manager/getphonecode.html?phone=${repayment.baseInfo.iphoneNum}">提醒还款</a></td>
                </c:forEach>
            </tr>
        </table>
<input type="hidden" id="totalPageCount" value="${pi.pageCount}"/>
<c:import url="rollpage.jsp">
    <c:param name="totalCount" value="${pi.count}"/>
    <c:param name="currentPageNo" value="${pi.pageIndex}"/>
    <c:param name="totalPageCount" value="${pi.pageCount}"/>
</c:import>
</body>
</html>
