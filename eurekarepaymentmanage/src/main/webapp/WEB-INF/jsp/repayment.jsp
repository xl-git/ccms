<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>还款管理</title>
</head>
<body>
    <h1>欢迎来到还款管理界面</h1>
    <div class="search">
        <form method="post"
              action="${pageContext.request.contextPath }/repayment.html">
            <input type="hidden" name="pageIndex" value="1"/>
        </form>
    </div>
    <table width="80%">
        <tr>
            <td>序号</td>
            <td>信用卡账户</td>
        </tr>
        <c:forEach var="creditCard" items="${creditcards}" varStatus="index">
            <tr>
                <td>${requestScope.offset + index.index + 1}</td>
                <td>${creditCard.cardNum}</td>
                <td><a href="/repaymentmanage/current.html?cardNum=${creditCard.cardNum}">快速还款</a></td>
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
