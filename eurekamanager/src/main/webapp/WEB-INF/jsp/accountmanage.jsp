<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>账户管理</title>
</head>
<body>
    <div>
        <div class="search">
            <form method="post" action="${pageContext.request.contextPath }/lists.html">
                <input type="hidden" name="pageIndex" value="1"/>
                卡号：<input type="text" id="cardNum" name="cardNum" value="${cardNum}"/><input type="submit" value="搜索"/>
            </form>
        </div>
        <table cellpadding="0" cellspacing="0" border="1" style="text-align: center" >
            <tr>
                <td>序 号</td>
                <td>用户姓名</td>
                <td>身份证号</td>
                <td>卡号</td>
                <td>详情</td>
            </tr>
            <c:forEach var="account" items="${accountList }" varStatus="status">
                <tr>
                    <td>${requestScope.offset+status.index+1}</td>
                    <td>
                        <input type="text" value="${account.baseInfo.name }" readonly="readonly">
                    </td>
                    <td>
                        <input type="text" value="${account.baseInfo.identityCard}" readonly="readonly">
                    </td>
                    <td>
                        <input type="text" id="cnum" name="cnum" value="${account.cardNum}"readonly="readonly" >
                    </td>
                    <td>
                        <a href="/manager/accountdetails.html?cardNum=${account.cardNum}"><input type="button" value="用户信息详情"></a>
                        <a href="/manager/historytransaction.html?cardNum=${account.cardNum}"><input type="button"  value="交易历史详情"></a>
                    </td>
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