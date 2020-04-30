<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>冻结</title>
</head>

<body>
<div>
    <form action="/manager/findfreeze.html" method="post">
        <div>
            <input type="hidden" name="pageIndex" value="1"/>
            <label>身份证号：</label>
            <input type="text"  id="identityCard" name="identityCard" value="${identityCard}" >
            <input type="submit" value="搜索">
        </div>
        <div style="color: red">${message}</div>
        <c:set var="identityCard" scope="page" value="${identityCard}"/>
        <c:if test="${identityCard != null}">
            <table cellpadding="0" cellspacing="0" border="1" style="text-align: center" >
                <tr>
                    <td>序号</td>
                    <td>用户卡号</td>
                    <td>用户姓名</td>
                    <td>身份证号</td>
                    <td>手机号</td>
                    <td>状态</td>
                    <td>操作</td>
                </tr>
                <c:forEach var="card" items="${cards}" varStatus="status">
                    <tr>
                        <td>${requestScope.offset+status.index+1}</td>
                        <td>${card.cardNum}</td>
                        <td>${card.baseInfo.name}</td>
                        <td>${card.baseInfo.identityCard}</td>
                        <td>${card.baseInfo.iphoneNum}</td>
                        <td style="color: red">${card.cardStatus.status}</td>
                        <td>
                            <a href="/manager/freezing.html?cardNum=${card.cardNum}&phone=${card.baseInfo.iphoneNum}&identityCard=${card.baseInfo.identityCard}">
                                <input type="button" value="冻结" ></a>
                            <a href="/manager/relievefreeze.html?cardNum=${card.cardNum}&identityCard=${card.baseInfo.identityCard}">
                                <input type="button" value="解冻"></a>
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
        </c:if>
    </form>
</div>
</body>
</html>