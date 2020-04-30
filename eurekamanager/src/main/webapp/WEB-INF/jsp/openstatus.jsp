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
            <td>卡类型</td>
            <td>申请时间</td>
            <td>查看</td>
        </tr>
        <c:forEach var="openStatus" items="${openStatuses}" varStatus="status">
            <tr>
               <td>${openStatus.user.userName}</td>
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
                <td><fmt:formatDate value="${openStatus.opDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><a href="/manager/searchOpenStatus/${openStatus.userId}">查看详情</a></td>
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