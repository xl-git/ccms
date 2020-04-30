<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<div>
			<form action="/manager/doupdatematerial.html" method="post">
				<table>
					<tr>
						<th>卡号：</th>
						<th><input type="text" id="cnum" name="cnum" value="${card.cardNum}" readonly="readonly" /></th>
					</tr>
					<tr>
						<th>用户姓名：</th>
						<th><input type="text" value="${card.baseInfo.name}" readonly="readonly" /></th>
					</tr>
					<tr>
						<th>身份证号：</th>
						<th><input type="text" value="${card.baseInfo.identityCard}" readonly="readonly" /></th>
					</tr>
					<tr>
						<th>手机号码：</th>
						<th><input type="text" id="iphoneNum" name="iphoneNum" value="${card.baseInfo.iphoneNum}"  /></th>
					</tr>
					<tr>
						<th>受教育程度：</th>
						<td>
                            <c:if test="${card.baseInfo.education==1}"><input type="text"   value="小学" readonly="readonly"/></c:if>
                            <c:if test="${card.baseInfo.education==2}"><input type="text"   value="初中" readonly="readonly"/></c:if>
                            <c:if test="${card.baseInfo.education==5}"><input type="text"   value="本科" readonly="readonly"/></c:if>
                            <c:if test="${card.baseInfo.education==3}"><input type="text"   value="高中"readonly="readonly"/></c:if>
                            <c:if test="${card.baseInfo.education==4}"><input type="text"   value="专科"readonly="readonly"/></c:if>
                            <c:if test="${card.baseInfo.education==6}"><input type="text"   value="研究生及以上"readonly="readonly"/></c:if>
                        </td>
                        <td>
                            <select id="education" name="education">
								<option value ="${card.baseInfo.education}">请选择</option>
                                <option value ="1">小学</option>
                                <option value ="2">初中</option>
                                <option value="3">高中</option>
                                <option value="4">专科</option>
                                <option value="5">本科</option>
                                <option value="6">研究生及以上</option>
                            </select>
						</td>
					</tr>
					<tr>
						<th>Email地址：</th>
						<th><input type="text" id="email" name="email" value="${card.contactInfo.email}"/></th>
					</tr>
					<tr>
						<th>单位电话：</th>
						<th><input type="text" id="unitIphone" name="unitIphone" value="${card.unitInfo.unitIphone}"  /></th>
					</tr>
					<tr>
						<th>家庭住址：</th>
						<th><input type="text" id="homeAddress" name="homeAddress" value="${card.baseInfo.homeAddress}"  /></th>
					</tr>
					<tr>
						<th>办公地址：</th>
						<th><input type="text" id="unitAddress" name="unitAddress" value="${card.unitInfo.unitAddress}"  /></th>
					</tr>
					<tr>
						<th>户籍地址：</th>
						<th><input type="text"id="familyAddress" name="familyAddress" value="${card.baseInfo.familyAddress}"  /></th>
					</tr>
				</table>
				<input type="submit" value="确定修改"/>
			</form>
			<div style="color: red">${message}</div>
		</div>
	</body>
</html>
