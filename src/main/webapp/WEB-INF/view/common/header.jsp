<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/jspf/taglibs.jsp" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>捷信支付,安全便捷支付！</title>
</head>

<body>
<!--顶部-->
<div class="top_bk">
	<div class="top">
		<!-- <div class="bangzhu">
			<a href="">帮助中心</a>
		</div> -->
		<div class="fankui">
			<a href="">我要反馈</a>	
		</div>
		<div class="tuichu">
			<c:if test="${user.loginName eq null}">
			    <a href="${ctx}/login/">[登录]</a>
			</c:if>
			<c:if test="${user.loginName ne null}">
			    <a href="${ctx}/logout/">[退出]</a>
			</c:if>
			
		</div>
		<c:if test="${user.loginName ne null}">
			<div class="huanying">你好，${user.loginName}，欢迎来到捷信支付！</div>
		</c:if>
		<div class="clearfix"></div>
	</div>
</div>

<!--logo+导航-->
<div class="logo_bk">
	<div class="logo">
		<img src="${ctx}/img/logo.png">
	</div>
	<ul class="nav">
		<li><a href="${ctx}/account/" <c:if test="${orderMenu == 'index' }">class="special" </c:if>>账户首页</a></li>
		<li><a href="${ctx}/account/manage" <c:if test="${orderMenu == 'account' }">class="special" </c:if>>用户管理</a></li>
		<li><a href="${ctx}/order/" <c:if test="${orderMenu == 'order' }">class="special" </c:if>>交易管理</a></li>
		<li><a href="">帮助中心</a></li>
		<div class="clearfix"></div>
	</ul>
	<div class="clearfix"></div>
</div>
	
</body>
</html>
