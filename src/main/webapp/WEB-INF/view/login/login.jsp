<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/jspf/taglibs.jsp" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>捷信支付,安全便捷支付！</title>
<link href="${ctx}/css/dl.css" rel="stylesheet" type="text/css">
<script src="${ctx}/js/login/login.js" type="text/javascript"></script>
</head>

<body>
<%@ include file="/WEB-INF/view/common/header.jsp"%> 
<div class="bk">
	<img src="${ctx}/img/bk.jpg">
	<div class="dl_bk">
		<h1>用户登录</h1>
		<div id="errorDiv" class="cw" style="margin-bottom:20px;">
			账户名或登录密码不正确，请重新输入。
		</div>
		<div class="yhm">
			<input type="text" class="xingming" placeholder="请输入用户名" id="loginName">
			<img src="${ctx}/img/yh.png">
		</div>
		<div class="mm" style="margin-top:20px;">
			<input type="password" class="mima" placeholder="请输入密码" id="loginPwd">
			<img src="${ctx}/img/mm.png">
		</div>
		<div class="yz">
			<input type="text" class="yanzheng" placeholder="请输入验证码" id="loginCode">
			<div class="yz_tu">
				<a onclick="changeVerifyCode();">
				<img id="getcode_img" src="${ctx}/verifyCode/generateCode">
				</a>
			</div>
			<div class="clearfix"></div>
		</div>
		<button onclick="login();">登录</button>
		<h2>忘记密码?</h2>
	</div>
	
</div>
</body>
</html>