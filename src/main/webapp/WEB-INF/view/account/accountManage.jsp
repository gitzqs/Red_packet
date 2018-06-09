<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/jspf/taglibs.jsp" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>捷信支付,安全便捷支付！</title>
<link href="${ctx}/css/zhgl.css" rel="stylesheet" type="text/css">
</head>

<body>
<!--顶部-->
<%@ include file="/WEB-INF/view/common/header.jsp"%> 
<!--具体-->
<div class="juti">
<div class="top_kuai">
	<div class="mokuai1">
		<h1>${am.childTotal}</h1>
		<h2>用户总数</h2>
	</div>
	<div class="mokuai1">
		<h1>${am.todayAdd}</h1>
		<h2>今日新增</h2>
	</div>
	<div class="mokuai1">
		<h1>${am.todayActive}</h1>
		<h2>今日活跃</h2>
	</div>
	<div class="mokuai2">
		<div class="mokuai3">
			<h3>账户总余额</h3>
			<h4>￥${am.accountAmount}</h4>
			<div class="clearfix"></div>
		</div>
		<div class="mokuai3" style="margin-top:10px;">
			<h3>充值总金额</h3>
			<h4>￥${am.rechargeAmount }</h4>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="clearfix"></div>
</div>

<div class="nav4">
	<h2>用户列表</h2>
	<h1 style="margin-left:10px;">用户名：</h1>
	<input type="text">
	<h1 style="margin-left:30px;">手机号：</h1>
	<input type="text">
	<div class="chaxun"><a href="">删除</a></div>
	<div class="chaxun"><a href="">编辑</a></div>
	<div class="chaxun"><a href="">新增</a></div>
	<div class="clearfix"></div>
</div>
<div class="dingdan">
				
				<div class="biaoge">
					<ul class="special">
						<li style="width:20%">用户名称</li>
						<li style="width:20%">手机号</li>
						<li style="width:20%">邮箱</li>
						<li style="width:12%">账户余额</li>
						<li style="width:12%">注册时间</li>
						<li>操作</li>
						
						<div class="clearfix"></div>
					</ul>
					<div class="line4"></div>
					<ul class="one">
						<li style="width:20%">201828002090675</li>
						<li style="width:20%">13654259952</li>
						<li style="width:20%">1308011522@qq.com</li>
						<li style="width:12%; font-weight:bold; color:#ff8a00">￥188.00</li>
						<li style="width:12%; line-height:18px; padding-top:10px;">2018-04-04<br>12:06:32</li>
						<li style="color:#ff8a00;"><a href="">详情</a></li>
						
						<div class="clearfix"></div>
					</ul>
					<div class="line4"></div>
					<ul class="one">
						<li style="width:20%">201828002090675</li>
						<li style="width:20%">13654259952</li>
						<li style="width:20%">1308011522@qq.com</li>
						<li style="width:12%; font-weight:bold; color:#ff8a00">￥188.00</li>
						<li style="width:12%; line-height:18px; padding-top:10px;">2018-04-04<br>12:06:32</li>
						<li style="color:#ff8a00;"><a href="">详情</a></li>
						
						<div class="clearfix"></div>
					</ul>
					<div class="line4"></div>
					<ul class="one">
						<li style="width:20%">201828002090675</li>
						<li style="width:20%">13654259952</li>
						<li style="width:20%">1308011522@qq.com</li>
						<li style="width:12%; font-weight:bold; color:#ff8a00">￥188.00</li>
						<li style="width:12%; line-height:18px; padding-top:10px;">2018-04-04<br>12:06:32</li>
						<li style="color:#ff8a00;"><a href="">详情</a></li>
<!--						<li style="color:#ff8a00; font-weight:bold;">￥188.00</li>-->
						
						<div class="clearfix"></div>
					</ul>
					<div class="line4"></div>
					<ul class="one">
						<li style="width:20%">201828002090675</li>
						<li style="width:20%">13654259952</li>
						<li style="width:20%">1308011522@qq.com</li>
						<li style="width:12%; font-weight:bold; color:#ff8a00">￥188.00</li>
						<li style="width:12%; line-height:18px; padding-top:10px;">2018-04-04<br>12:06:32</li>
						<li style="color:#ff8a00;"><a href="">详情</a></li>
<!--						<li style="color:#ff8a00; font-weight:bold;">￥188.00</li>-->
						
						<div class="clearfix"></div>
					</ul>
					<div class="line4"></div>
					<ul class="one">
						<li style="width:20%">201828002090675</li>
						<li style="width:20%">13654259952</li>
						<li style="width:20%">1308011522@qq.com</li>
						<li style="width:12%; font-weight:bold; color:#ff8a00">￥188.00</li>
						<li style="width:12%; line-height:18px; padding-top:10px;">2018-04-04<br>12:06:32</li>
						<li style="color:#ff8a00;"><a href="">详情</a></li>
<!--						<li style="color:#ff8a00; font-weight:bold;">￥188.00</li>-->
						
						<div class="clearfix"></div>
					</ul>
					<div class="line4"></div>			
				</div>
				<div class="tiaozhuan">
					<div class="anniu" style="padding-top:11px; height:8px; padding-bottom:11px;"><img src="${ctx}/img/xia.png"></div>
					<div class="anniu" style="padding-top:11px; height:8px; padding-bottom:11px;"><img src="${ctx}/img/right.png"></div>
					<div class="anniu2">2</div>
					<div class="anniu" style="background-color:#00aaee; color:white;">1</div>
					<div class="anniu" style="padding-top:11px; height:8px; padding-bottom:11px;"><img src="${ctx}/img/left.png"></div>
					<div class="anniu" style="padding-top:11px; height:8px; padding-bottom:11px;"><img src="${ctx}/img/shang.png"></div>
					<div class="zi" style="width:auto; color:#888; background-color:white; margin-right:14px;">共有10条，每页显示5条</div>
				</div>
				
			</div>
</div>
</body>
</html>
