<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#remind").bind("click", function () {
                $.ajax({
                    type: "GET",//请求类型
                    url: "/manager/remind.html",//请求的url
                    data: {method: "remind",phone: $("#phone").val()},//请求参数
                    dataType: "json",//ajax接口（请求url）返回的数据类型
                    success: function (data) {//data：返回数据（json对象）
                        if (data.result == "true") {
                            alert("信息发送成功！")
                            window.location.href="/manager/overduelists.html"
                        }else{
                            window.location.href="/manager/losehandle.html"
                        }
                    }
                });
            });
        })
    </script>
</head>
<body>
    <div>
        <div class="search">
            <form method="post" action="${pageContext.request.contextPath }/overduelists.html">
                <input type="hidden" name="pageIndex" value="1"/>
                卡号：<input type="text" id="cardNum" name="cardNum" value="${cardNum}"/><input type="submit" value="搜索"/>
            </form>
        </div>
        <table cellpadding="0" cellspacing="0" border="1" style="text-align: center" >
            <tr>
                <td>序 号</td>
                <td>姓 名</td>
                <td>卡 号</td>
                <td>身份证号</td>
                <td>手机号</td>
                <td>逾期金额</td>
                <td>逾期日期</td>
                <td>应还款金额</td>
                <td>操 作</td>
            </tr>
            <c:forEach var="overdue" items="${overList}" varStatus="status">
                <tr>
                    <td>${requestScope.offset+status.index+1}</td>
                    <td>${overdue.baseInfo.name}</td>
                    <td>${overdue.cardNum}</td>
                    <td>${overdue.baseInfo.identityCard}</td>
                    <td><input type="text" id="phone" value="${overdue.baseInfo.iphoneNum}" readonly="readonly"></td>
                    <td><fmt:formatNumber value="${overdue.overdue.overdueAmounts}" pattern="#.00" type="number" /></td>
                    <input type="hidden" <fmt:formatDate  var="endDay"  type="date"  value="${date}" pattern="yyyy-MM-dd"/>>
                    <input type="hidden" <fmt:formatDate  var="startDay" type="date"  value="${overdue.overdue.overdueDate}" pattern="yyyy-MM-dd"  />>
                    <input type="hidden" <fmt:parseDate var="e" value="${endDay}" pattern="yyyy-MM-dd"></fmt:parseDate>>
                    <input type="hidden" <fmt:parseDate var="s" value="${startDay}" pattern="yyyy-MM-dd"></fmt:parseDate>>
                    <input type="hidden" <fmt:formatNumber value="${(e.getTime()-s.getTime())/1000/60/60/24}" pattern="#0" var="num"/>>
                    <td><fmt:formatDate value="${overdue.overdue.overdueDate}" pattern="yyyy-MM-dd"/></td>
                    <td><fmt:formatNumber value="${overdue.overdue.overdueAmounts+overdue.overdue.overdueAmounts*0.0005*num}" pattern="#.00" type="number" /></td>
                    <td><input type="button" id="remind" value="提醒"></td>
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