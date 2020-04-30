<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>客户综合查询</title>

</head>
<body>
    <h2>查询到的客户基本账户信息如下：</h2></br>
    <div class="search">
        <form method="post"
              action="${pageContext.request.contextPath }/customerselect.html">
            <input type="hidden" name="pageIndex" value="1"/>
        </form>
    </div>
        <table width="80%" height="20%">
            <tr>
                <th colspan="5">基本账户信息</th>
            </tr>
            <tr>
                <td>序号</td>
                <td>信用卡编号</td>
                <td>信用额度</td>
                <td>可用额度</td>
                <td>本期到账还款日</td>
            </tr>
            <c:forEach var="creditCard" items="${creditCards}" varStatus="index">
            <tr>
                <td>${requestScope.offset+index.index+1}</td>
                <td>${creditCard.id}</td>
                <td>${creditCard.creditLimit}</td>
                <td>${creditCard.useableLimit}</td>
                <td>${creditCard.inDate}号</td>
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