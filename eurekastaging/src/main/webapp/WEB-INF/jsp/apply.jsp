<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>分期申请</title>

</head>
<body>
<h2>请选择您需要进行分期申请的信用卡账户：</h2></br>
<div class="search">
    <form method="post"
          action="${pageContext.request.contextPath }/apply.html">
        <input type="hidden" name="pageIndex" value="1"/>
    </form>
</div>
<table width="80%" height="20%">
    <tr>
        <th colspan="5">信用卡账户分期</th>
    </tr>
    <tr>
        <td>信用卡编号</td>
        <td>信用卡账号</td>
        <td>分期申请</td>
    </tr>
    <c:forEach var="creditCard" items="${creditCards}">
        <tr>
            <td>${creditCard.id}</td>
            <td>${creditCard.cardNum}</td>
            <td><a href="/staging/applyinfo?id=${creditCard.id}">申请分期</a></td>
        </tr>
    </c:forEach>
</table>
<input type="hidden" id="totalPageCount" value="${pi.pageCount}"/>
<c:import url="rollpage.jsp">
    <c:param name="totalCount" value="${totalCount}"/>
    <c:param name="currentPageNo" value="${currentPageNo}"/>
    <c:param name="totalPageCount" value="${totalPageCount}"/>
</c:import>
<div>${msg}</div>
</body>
</html>