<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>当前申请查询</title>

</head>
<body>
<h2>当前申请查询</h2></br>
<div class="search">
    <form method="post"
          action="${pageContext.request.contextPath }/currapply.html">
        <input type="hidden" name="pageIndex" value="1"/>
    </form>
</div>
        <table width="80%">
            <tr>
                <td>序号</td>
                <td>当前账户</td>
                <td>分期金额</td>
                <td>申请时间</td>
            </tr>
            <c:forEach var="changePeriods" items="${lists}" varStatus="index">
            <tr>
                <td>${requestScope.offset+index.index+1}</td>
                <td>${changePeriods.creditCard.cardNum}</td>
                <td>${changePeriods.amount}</td>
                <td><fmt:formatDate value="${changePeriods.changeDate}" pattern="yyyy-MM-dd" /></td>
            </tr>
            </c:forEach>
        </table>
        <input type="hidden" id="totalPageCount" value="${pi.pageCount}"/>
        <c:import url="rollpage.jsp">
            <c:param name="totalCount" value="${totalCount}"/>
            <c:param name="currentPageNo" value="${currentPageNo}"/>
            <c:param name="totalPageCount" value="${totalPageCount}"/>
        </c:import>
    </form>
</body>
</html>