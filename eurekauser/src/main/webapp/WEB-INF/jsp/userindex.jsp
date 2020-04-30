<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<title>用户主页</title>
	<link type="text/css" rel="stylesheet" href="./css/style.css" />
	<script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="./js/userindex.js"></script>
</head>

<body>
	<div style="height: 25px">
		<div style="float: right">
			<input type="button" id="login" name="login" value="登录">
			<input type="button" id="register" name="register" value="注册">
		</div>
		<div>欢迎您，${loginUser.userName}进入信用卡管理系统
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上次登录时间：${lasttime}
		</div>
	</div>
	<div>
  	<div style="width: 100%">
		<div class="userm" align="center" style="width:16%">
			<a id="submeau" href="javascript:;" >客户管理</a>
			<div id="myDiv" style="display: none">
				<li class="no_circle"><a>客户综合查询</a></li>
				<li class="no_circle"><a>网上申请进度查询</a></li>
				<li class="no_circle"><a>Email地址设置</a></li>
			</div>
		</div>
		<div class="userm" align="center" style="width:16%">
			<a id="submeau2" href="javascript:;" >账户管理</a>
			<div id="myDiv2" style="display: none">
				<li class="no_circle"><a>账户总览</a></li>
				<li class="no_circle"><a>账户查询</a></li>
				<li class="no_circle"><a>客户资料修改</a></li>
				<li class="no_circle"><a>已出账单查询</a></li>
				<li class="no_circle"><a>未出账单查询</a></li>
			</div>
		</div>
		<div class="userm" align="center" style="width:16%">
			<a id="submeau3" href="javascript:;" >分期管理</a>
			<div id="myDiv3" style="display: none">
				<li class="no_circle"><a>分期交易查询</a></li>
				<li class="no_circle"><a>账单分期已出账</a></li>
			</div>
		</div>
		<div class="userm" align="center" style="width:16%">
			<a id="submeau4" href="javascript:;" >还款管理</a>
			<div id="myDiv4" style="display: none">
				<li class="no_circle"><a>快速还款</a></li>
				<li class="no_circle"><a>还款明细查询</a></li>
			</div>
		</div>
		<div class="userm" align="center" style="width:16%">
			<a id="submeau5" href="javascript:;" >卡片管理</a>
			<div id="myDiv5" style="display: none">
				<li class="no_circle"><a>卡片额度调整</a></li>
				<li class="no_circle"><a>交易密码管理</a></li>
				<li class="no_circle"><a>信用卡挂失</a></li>
				<li class="no_circle"><a>销卡申请</a></li>
			</div>
		</div>
		<div class="userm" align="center" style="width:10%">
			<a id="submeau6" href="javascript:;" >办&nbsp;&nbsp;卡</a>
			<div id="myDiv6" style="display: none">
				<li class="no_circle"><a>普卡</a></li>
				<li class="no_circle"><a>金卡</a></li>
				<li class="no_circle"><a>白金卡</a></li>
			</div>
		</div>
  	</div>
	<div id="operation">
		<div>最近操作：</div>
		<div>温馨提示：</div>
  	</div>
	  
 </div>
</body>
</html>
