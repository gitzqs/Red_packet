<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/jspf/taglibs.jsp" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>捷信支付,安全便捷支付！</title>
<link href="${ctx}/css/jygl.css" rel="stylesheet" type="text/css">
<link href="${ctx}/css/common/common.css" rel="stylesheet" type="text/css">
<script src="${ctx}/js/order/order.js" type="text/javascript"></script>
<script src="${ctx}/js/common/page.js" type="text/javascript"></script>
</head>

<body>
<!--顶部-->
<%@ include file="/WEB-INF/view/common/header.jsp"%> 

<!--具体-->
<div class="juti">
<div class="nav2">
	<input type="hidden" id="searchType" value="1">
	<ul class="list1">
		<li id="rechargeBg1" ><a id="rechargeBg2" href="javascript:selectType(1);">充值记录</a></li>
		<li id="withdrowBg1"><a id="withdrowBg2" href="javascript:selectType(2);">提现记录</a></li>
		<li id="payBg1"><a id="payBg2" href="javascript:selectType(3);">支付记录</a></li>
		<div class="clearfix"></div>
	</ul>
</div>
<div class="nav4">
	<h1>订单状态：</h1>
	<select class="choose" id="statusQ">
  		<option value="" selected>请选择</option>
  		<option value="NO">未完成</option>
  		<option value="YES">已完成</option>
	</select>
	<h1 style="margin-left:30px;">支付时间范围：</h1>
	<input type="date" id="beginTime">
	<h1 style="padding-left:30px; padding-right:30px;">至</h1>
	<input type="date" id="endTime">
	<div class="chaxun"><a href="javascript:page(0);">查询</a></div>
	<div class="clearfix"></div>
</div>
<div class="dingdan">
				<h2>交易记录</h2>
				<h3><a href="">下载</a></h3>
				<div class="clearfix"></div>
				<div class="biaoge">
					<div class="line4"></div>
					
					<ul class="special">
						<li style="width:12%">交易流水号</li>
						<li style="width:12%">产品名称</li>
						<li style="width:12%">创建时间</li>
						<li style="width:12%">交易金额</li>
						<li style="width:12%">支付时间</li>
						<li style="width:12%">交易状态</li>
						<li style="width:12%">备注</li>
						<div class="clearfix"></div>
					</ul>
					<!-- 列表 -->
					<div class='line4'></div>
					<div id="listDiv">
					
					</div>
					
					<div id="paramsDiv" style="display:none">
						<input type="text" value="TRADE_NO"/>
						<input type="text" value="OBJECT_NAME"/>
						<input type="text" value="BEGIN_TIME"/>
						<input type="text" value="AMOUNT"/>
						<input type="text" value="END_TIME"/>
						<input type="text" value="STATUS"/>
						<input type="text" value="DESCRIPTION"/>
					</div>
				
				<!-- 列表尾部 -->
				<div class="tiaozhuan" id="bottomNav">
					<%-- <a href="javacript:alert('1');" class="anniu"><img class="anniu_img" src="${ctx}/img/xia.png"></a>
					<a href="javacript:alert('2');" class="anniu"><img class="anniu_img" src="${ctx}/img/right.png"></a>
					<div><input class="anniu_input" type="text" value="1"></div>
					<a href="javacript:alert('3');" class="anniu"><img class="anniu_img" src="${ctx}/img/left.png"></a>
					<a href="javacript:alert('4');" class="anniu"><img class="anniu_img" src="${ctx}/img/shang.png"></a>
					<div class="anniu_zi">1~10条，共1113条</div>  --%>
				</div>
				
			</div>
</div>
</div>
</body>
</html>
