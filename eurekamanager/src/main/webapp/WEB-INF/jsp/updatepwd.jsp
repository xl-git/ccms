<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head lang="en">
	<meta charset="UTF-8">
	<title>信用卡管理系统</title>
</head>
<body>
<script src="./js/jquery-1.8.3.min.js"></script>
<div >
	<div >
		<strong>你现在所在的位置是:</strong>
		<span>交易密码修改页面</span>
	</div>
	<div>
		<form>
			<!--div的class 为error是验证错误，ok是验证成功-->
			<div style="color: red">${message}</div>
			<div>
				<label for="password">旧密码：</label>
				<input type="text" name="password" id="password" value="${card.payPassword}" readonly="readonly"/>
			</div>
			<div>
				<label for="newPassword">新密码：</label>
				<input type="password" name="newPassword" id="newPassword" required/>
				<span id="NewP">*请输入新密码</span>
			</div>
			<div>
				<label for="reNewPassword">确认新密码：</label>
				<input type="password"  name="reNewPassword" id="reNewPassword" required/>
				<span id="RewNewP">*请输入新确认密码，保证和新密码一致</span>
			</div>
			<input type="hidden" id="cardNum" name="cardNum" value="${card.cardNum}">
			<div >
				<!--<a href="#">保存</a>-->
				<input type="button" value="保存" onclick="save()"></input>
			</div>
		</form>
	</div>
</div>
</body>
<script>
	var flag = false;
	$(function () {
		//密码
		$("#newPassword").blur(function () {
			var newPassword = $("#newPassword").val();
			if (newPassword.length < 6) {
				$("#NewP").html("密码过短，至少6位！");
				$("#NewP").css("color", "red");
				flag = false;
			}
			else if (newPassword.length > 6) {
				$("#NewP").html("密码过长，最多6位！");
				$("#NewP").css("color", "red");
				flag = false;
			}
			else {
				$("#NewP").html("密码可用√");
				$("#NewP").css("color", "green");
				flag = true;
			}
			if (newPassword == "") {
				$("#NewP").html("*密码长度必须等于6位");
				$("#NewP").css("color", "rgb(250, 202, 13)");
				flag = false;
			}
		});
		//确认密码
		$("#reNewPassword").blur(function () {
			var reNewPassword = $("#reNewPassword").val();
			var newPassword = $("#newPassword").val();
			if (reNewPassword != "" && reNewPassword != "") {
				if (reNewPassword == newPassword) {
					$("#RewNewP").html("密码一致√");
					$("#RewNewP").css("color", "green");
					flag = true;
				}
				else {
					$("#RewNewP").html("两次密码不一致×");
					$("#RewNewP").css("color", "red");
					flag = false;
				}
			}
			else if (reNewPassword == "") {
				$("#RewNewP").html("*请输入确认密码");
				$("#RewNewP").css("color", "rgb(250, 202, 13)");
				flag = false;
			}
		});
	});

	function save() {
		var reNewPassword = $("#reNewPassword").val();
		if (flag) {
			$.ajax({
				type: "POST",//请求类型
				url: "/manager/updatepwd.html",//请求的url
				data: {method: "updatePwd",reNewPassword: $("#reNewPassword").val(),cardNum: $("#cardNum").val()},//请求参数
				success: function (data) {//data：返回数据（json对象）
					if (data.result == "true") {
						alert("修改成功！")
						location.href = "/manager/findcard.html?cnum=${card.cardNum}"
					}else{
						alert("系统异常，修改失败！")
						location.href = "/manager/updatetradpassword.html"
					}
				}
			})
		}
	}
</script>
</html>
