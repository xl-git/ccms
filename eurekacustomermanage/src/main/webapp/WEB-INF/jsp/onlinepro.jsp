<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>网上申请进度查询</title>
</head>
<body>
    <h2>网上申请进度查询</h2>
    <form action="/customermanage/onlinepro.html" method="post" enctype="multipart/form-data">
                    证件类型：
                    <select>
                        <option value="0">
                            请选择
                        </option>
                        <option value="1">
                            身份证
                        </option>
                        <option value="1">
                            外籍护照
                        </option>
                        <option value="1">
                            军官证
                        </option>
                        <option value="1">
                            港澳通行证
                        </option>
                        <option value="1">
                            其他样式
                        </option>
                    </select>
                    证件号码：
                    <input name="queryIdentityCard" type="text" value="${queryIdentityCard}"/>
                    <input type="hidden" name="pageIndex" value="1"/>
                    <input type="submit" name="btnSubmit" value="申请进度查询" />
    </form>
    <c:if test="${queryIdentityCard!=null}">
    <table width="80%" height="20%">
        <tr>
            <th colspan="5">申请进度</th>
        </tr>
        <tr>
            <td>序号</td>
            <td>申请人</td>
            <td>申请时间</td>
            <td>卡的类型</td>
            <td>申请状态</td>
        </tr>
        <c:forEach var="openStatus" items="${openStatuss}">
            <tr>
                <td>${openStatus.id}</td>
                <td>${u.userName}</td>
                <td><fmt:formatDate value="${openStatus.opDate}" pattern="yyyy-MM-dd"/></td>
                <td>
                    <c:if test="${openStatus.cardType==1}">普卡</c:if>
                    <c:if test="${openStatus.cardType==2}">金卡</c:if>
                    <c:if test="${openStatus.cardType==3}">白金卡</c:if>
                </td>
                <td>
                    ${openStatus.status}
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
</body>
</html>