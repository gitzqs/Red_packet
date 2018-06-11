<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jspf/taglibs.jsp" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>饿了么大红包助手</title>
<link href="${ctx}/css/dl.css" rel="stylesheet" type="text/css">
<script src="${ctx}/js/login/login.js" type="text/javascript"></script>
</head>

<body>
<div class="bk_all">
	<img src="${ctx}/img/dl_bk.jpg" class="bk">
	<img src="${ctx}/img/wmy.png" class="wmy">
	<div class="dl_bk">
		<img src="${ctx}/img/logo.png" class="logo">
		<div id="errorDiv" style="text-align: center;color:red">账号密码错误！</div>
		<div class="zh">
				<h2>账号:</h2>
				<input type="text" class="zhanghao" placeholder="请输入账号" id="loginName">
			</div>
		<div class="mm">
				<h2>密码:</h2>
				<input type="password" class="mima" placeholder="请输入密码" id="loginPwd">
			</div>
		
		<button class="dl" onclick="login()">登录</button>
		<div class="one"><a href="${ctx}/register/">没有账号，点击注册</a></div>
	</div>
	
</div>
</body>
</html>
