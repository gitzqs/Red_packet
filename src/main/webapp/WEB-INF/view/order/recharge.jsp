<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jspf/taglibs.jsp" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>饿了么大红包助手</title>
<link href="${ctx}/css/lqhb.css" rel="stylesheet" type="text/css">
<script src="${ctx}/js/order/order.js" type="text/javascript"></script>
</head>

<body>
<!--顶部-->
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<div class="eleme_nav">
	<ul>
		<li><a href="${ctx}/rec/">领取红包</a></li>
		<li><a href="${ctx}/recharge/" class="special">积分充值</a></li>
		<li><a href="${ctx}/help/">常见问题</a></li>
		<div class="clearfix"></div>
	</ul>
</div>

<div class="jf">
	<h1>您当前的积分为：${score}</h1>
</div>
<div class="one">
	<div class="kh">充值金额</div>
	<input type="text" placeholder="充值1元可以兑换10积分" id="amount">
	<div class="clearfix"></div>
</div>

<div class="three">
	<button style="float:right; background-color:#00aaee; margin-right:5%;margin-top: -5%;" onclick="recharge()">点击充值</button>
</div>
<div id="imgDiv">
	<img id="qrImg" alt="" src="">
</div>
<div class="bg">
	<h1>充值记录（最近10条）</h1>
	<div class="line1"></div>
	<ul>
		<li style="font-weight: bold; color:#000;">订单号</li>
		<li style="font-weight: bold; color:#000;">充值金额</li>
		<li style="font-weight: bold; color:#000;">充值时间</li>
		<div class="clearfix"></div>
	</ul>
		
	<div class="line1"></div>
	<c:forEach items="${list }" var="list">
	<ul>
		<li>${list.TRADE_NO }</li>
		<li>${list.PAY_AMOUNT }</li>
		<li>${list.PAY_TIME }</li>
		<div class="clearfix"></div>
	</ul>
	<div class="line1"></div>
	</c:forEach>
		
		
	
	</div>
</body>
</html>
