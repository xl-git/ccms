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
<h2>查询到的账户下卡片信息如下：</h2></br>
<div class="search">
    <form method="post"
          action="${pageContext.request.contextPath }/customerselect.html">
        <input type="hidden" name="pageIndex" value="1"/>
    </form>
</div>
        <table width="80%" height="20%">
            <tr>
                <th colspan="5">账户下卡片信息</th>
            </tr>
            <tr>
                <td>序号</td>
                <td>信用卡编号</td>
                <td>卡号</td>
                <td>卡别（种类）</td>
                <td>持卡人</td>
                <td>开卡状态</td>
            </tr>
            <c:forEach var="creditCard" items="${creditCards}" varStatus="index">
            <tr>
                <td>${requestScope.offset+index.index+1}</td>
                <td>${creditCard.id}</td>
                <td>${creditCard.cardNum}</td>
                <td>
                    <c:if test="${creditCard.cardType==1}">普卡</c:if>
                    <c:if test="${creditCard.cardType==2}">金卡</c:if>
                    <c:if test="${creditCard.cardType==3}">白金卡</c:if>
                </td>
                <td>${user.userName}</td>
                <td>
                    <c:if test="${creditCard.cardStatusId==1}">未开卡</c:if>
                    <c:if test="${creditCard.cardStatusId==2}">已开卡</c:if>
                    <c:if test="${creditCard.cardStatusId==3}">异常</c:if>
                    <c:if test="${creditCard.cardStatusId==4}">冻结</c:if>
                    <c:if test="${creditCard.cardStatusId==5}">挂失</c:if>
                    <c:if test="${creditCard.cardStatusId==6}">销户</c:if>
                </td>
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