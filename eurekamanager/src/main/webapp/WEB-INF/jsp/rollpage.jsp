<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<body>
 		<div style="height: 60px">
			<ul style="float: left">
				<li>共${pi.count }条记录&nbsp;&nbsp; ${pi.pageIndex }/${pi.pageCount }页</li>
				<c:if test="${pi.pageIndex > 1}">
					<a href="javascript: page_nav(document.forms[0],1);">首页</a>
					<a href="javascript: page_nav(document.forms[0],'${pi.pageIndex-1}');">上一页</a>
				</c:if>
				<c:if test="${pi.pageIndex < pi.pageCount }">
					<a href="javascript:page_nav(document.forms[0],'${pi.pageIndex+1 }');">下一页</a>
					<a href="javascript:page_nav(document.forms[0],'${pi.pageCount }');">最后一页</a>
				</c:if>
				&nbsp;&nbsp;
			</ul>
		 <span style="float: right;margin-top: 20px;height: 20px"><label>跳转至</label>
	     <input type="text" name="inputPage" id="inputPage" class="page-key" />页
	     <button type="button" class="page-btn" onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
		</span>
		</div> 
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/rollpage.js"></script>
</html>