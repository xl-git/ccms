<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>待激活页面</title>
    <script type="text/javascript">
        function checkForm(){
            var flag=true;
            var message=document.getElementById(message).value;
            if(message!='null'){
                alert(message);
                flag=false;
            }
            return flag;
        }
    </script>
</head>
<body οnlοad="checkForm()">
    <input type="hidden" id="message" value="${message}">
    <div class="search">
        <form method="post" action="${pageContext.request.contextPath }/noactivate.html">
            <input type="hidden" name="pageIndex" value="1"/>
        </form>
    </div>
        <table cellpadding="0" cellspacing="0" border="1" style="text-align: center">
            <tr>
                <td>序 号</td>
                <td>用户卡号</td>
                <td>用户姓名</td>
                <td>身份证号</td>
                <td>手机号</td>
                <td>状态</td>
                <td>操作</td>
            </tr>
            <c:forEach var="noactivate" items="${noactivates}" varStatus="status">
                <tr>
                    <td>${requestScope.offset+status.index+1}</td>
                    <td>${noactivate.cardNum}</td>
                    <td>${noactivate.name}</td>
                    <td>${noactivate.identityCard}</td>
                    <td>${noactivate.iphoneNum}</td>
                    <td>${noactivate.status}</td>
                    <td>
                        <a href="/manager/activating.html?cardNum=${noactivate.cardNum}">
                            <input type="button" value="激活" >
                        </a>
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