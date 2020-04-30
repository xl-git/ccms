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
    <title>还款明细页面</title>
</head>
<body>
<div class="search">
    <form method="post"
          action="${pageContext.request.contextPath }/detail.html">
        <input type="hidden" name="pageIndex" value="1"/>
    </form>
</div>
        <table width="80%">
            <tr>
                <td>序号</td>
                <td>卡号</td>
                <td>还款金额</td>
                <td>还款日期</td>
                <td>还款借记卡号</td>
            </tr>
            <c:forEach var="repayment" items="${repayments}" varStatus="index">
            <tr>
                <td>${requestScope.offset+index.index+1}</td>
                <td>${repayment.creditCard.cardNum}</td>
                <td>${repayment.rmoney}</td>
                <td><fmt:formatDate value="${repayment.duedate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${repayment.debitCard.debitCardId}</td>
            </tr>
            </c:forEach>
        </table>
<input type="hidden" id="totalPageCount" value="${pi.pageCount}"/>
<c:import url="rollpage.jsp">
    <c:param name="totalCount" value="${totalCount}"/>
    <c:param name="currentPageNo" value="${currentPageNo}"/>
    <c:param name="totalPageCount" value="${totalPageCount}"/>
</c:import>
</body>
</html>
