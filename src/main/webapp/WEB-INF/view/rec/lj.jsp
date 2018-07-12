<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jspf/taglibs.jsp" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>饿了么大红包助手</title>
<script src="${ctx}/js/lj.js"></script>
<link href="${ctx}/css/lj.css" rel="stylesheet" type="text/css">
</head>

<body>
<!--顶部-->
<div class="bu_all">	
	<div class="lb">
	<ul class="lb_bt">
		<li class="bt_one">标题</li>
		<li class="bt_two">链接</li>
		<li class="bt_three">操作</li>
		<div class="clearfix"></div>
	</ul>
	<c:forEach items="${link}" var="l" >
	<ul class="lb_nr">
		<li class="nr_one">${l.TITLE}</li>
		<li class="nr_two">${l.LINK }</li>
		<li class="nr_three">
			<a href="javascript:delLink(${l.ID});"><img src="${ctx}/img/sc.png"></a>
		</li>
		<div class="clearfix"></div>
	</ul>
	</c:forEach>	
</div>
	<div class="xz">新增</div>
	<div class="clearfix"></div>
</div>
<div class="list">
	<div class="sr_bt">标题</div>
	<input type="text">
	<div class="clearfix"></div>
	<div class="sr_lj">链接</div>
	<textarea placeholder="请输入饿了么拼手气红包链接【请确保链接正确】"></textarea>
	<div class="clearfix"></div>
	<div class="close1">
		<img src="img/close.png">
	</div>
</div>

</body>
</html>
