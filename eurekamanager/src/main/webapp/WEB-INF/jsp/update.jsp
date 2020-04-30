<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>修改</title>
		<style type="text/css">
			#up{
				margin: auto;
				text-align: center;
			}
		</style>
	</head>
	<body style="text-align: center">
		<div id="up">
			<form action="/manager/findcard.html" method="post">
				<div>
					<input type="text" placeholder="请输入卡号" id="cnum" name="cnum" value="${cardNum}"/>
					<input type="submit" value="搜索" />
				</div>
                <p></p>
				<div>
					<table cellpadding="0" cellspacing="0" border="0" style="text-align: center;margin: 0 auto;">
						<tr>
							<td>账户卡号:</td>
                            <td><input type="text" value="${card.cardNum}" readonly="readonly" /></td>
                        </tr>
                        <tr>
							<td>账户姓名:</td>
                            <td><input type="text" value="${card.baseInfo.name}" readonly="readonly" /></td>
                        </tr>
                        <tr>
							<td>登录密码:</td>
                            <td><input type="text" value="${card.user.userPwd}" readonly="readonly" /></td>
                        </tr>
                        <tr>
							<td>手机号码:</td>
                            <td><input type="text" value="${card.user.telphone}" readonly="readonly" /></td>
						</tr>
					</table>
                    <div>
                        <a href="/manager/updatetradpassword.html?cnum=${card.cardNum}">修改密码</a>
                        <a href="/manager/updatematerial.html?cnum=${card.cardNum}">修改资料</a>
                    </div>
				</div>
			</form>
		</div>
	</body>
</html>
