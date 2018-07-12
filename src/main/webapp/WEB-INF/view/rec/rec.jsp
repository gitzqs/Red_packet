<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jspf/taglibs.jsp" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>饿了么大红包助手</title>
<link href="${ctx}/css/khcz.css?1" rel="stylesheet" type="text/css">
<script src="${ctx}/js/rec/rec.js" type="text/javascript"></script>
</head>

<body>
<!--顶部-->
<div class="bj"></div>
<div class="xuzhi">
	<p>1.我们网站后台内置了大量的饿了么小号代领你输入的红包链接的小红包，大红包留给您输入的手机号，因此您必须输入你的手机号，和一条没有被领取最大红包的饿了么链接</p>
	<p>2.如果您对程序不是很敏感，依然不知道如何操作可先看下面原理，方便您更加了解如何使用饿了么大包助手</p>
	<p>3.本站原理：本站获取你填写的手机号和你输入的饿了么红包链接，通过程序让我这边的饿了么小号帮您领取小额红包，大额红包让您输入的手机号领取，因此您的饿了么红包链接必须要保证最大红包没有被人领取，且自己没有手动领取你输入的红包链接。</p>
	<div class="close1">
		<img src="${ctx}/img/close.png">
	</div>
</div>
<div class="shibai">
	<p>1.**已支持饿了么短连接领取**</p>
	<p>2.领取时长2-5秒，超过8秒刷新本页面重新填写领取</p>
	<p>3.饿了么限制每个手机号一天只能领5个红包</p>
	<p>4.请确保您填写的链接红包的最大红包没有被人领取</p>
	<p>5.请确保您填写的链接红包自己没有领取过</p>
	<p>6.请确保你填写的链接存在lucky number字段，不存在此字段说明这个红包没有最大红包</p>
	<div class="close1">
		<img src="${ctx}/img/close.png">
	</div>
</div>
<%@ include file="/WEB-INF/view/common/header.jsp"%> 
<div class="eleme_nav">
	<ul>
		<li><a href="${ctx}/rec/" class="special">领取红包</a></li>
		<li><a href="${ctx}/recharge/">积分充值</a></li>
		<li><a href="${ctx}/help/">常见问题</a></li>
		<div class="clearfix"></div>
	</ul>
</div>

<div class="gz">
	<h1>公告</h1>
	<!-- <div class="qq">
		饿了么QQ交流群：<a href="https://jq.qq.com/?_wv=1027&amp;k=5tB3ZCc">xxxxx(点我进群)</a>
	</div>
	<div class="tb">
		淘宝优惠券群：<a href="https://jq.qq.com/?_wv=1027&amp;k=5EAeSkl">xxxxx(点我进群)</a>
	</div>
	<div class="clearfix"></div> -->
	<div class="line2"></div>
	<p>4积分领取一次，100%到账4.6-10元红包，如果不填写手机号直接将领取到最大红包的前一个。（点击领取红包，会有3s左右反应时间！）</p>
	
</div>
<ul class="lhb">
	<c:forEach items="${link}" var="l" varStatus="status">
		<li><a href="${l.LINK}" target="view_window">${l.TITLE }</a></li>
		
		<c:if test="${status.index % 5 == 4 }">
			<div class="clearfix"></div>
		</c:if>
	</c:forEach>
	<div class="clearfix"></div>
</ul>
<div class="one">
	<div class="sj">phone</div>
	<input type="text" placeholder="输入需要领红包的手机号" id="mobile">
	<div class="clearfix"></div>
</div>
<div class="two">
	<div class="url">url</div>
	<textarea placeholder="请输入饿了么拼手气红包链接【请确保链接正确】" id="recUrl"></textarea>
	<div class="clearfix"></div>
	<input type="hidden" id="sleepInput" value="0"> 
</div>
<div class="three">
	<button style="float:left; background-color:#00aaee; margin-left:5%;">领取须知</button>
	<button style="float:left; background-color:#6e7780;">失败须知</button>
	<button style="float:right; background-color:#ef3433; margin-right:5%;" onclick="recHb()">领取红包</button>
	<div class="clearfix"></div>
</div>
<div class="bg">
	<h1>红包记录（最近10条）</h1>
	<div class="line1"></div>
	<ul>
		<li style="font-weight: bold; color:#000;">金额（￥）</li>
		<li style="font-weight: bold; color:#000;">手机号</li>
		<li style="font-weight: bold; color:#000;">领取时间</li>
		<div class="clearfix"></div>
	</ul>
	
	<c:forEach items="${record}" var="list">
	<ul>
		<li>${list.money }</li>
		<li>${list.phone }</li>
		<li>${list.time }</li>
		<div class="clearfix"></div>
	</ul>
	<div class="line1"></div>
	
	</c:forEach>
	
		<div class="clearfix"></div>
	</ul>
</div>
</body>
</html>
