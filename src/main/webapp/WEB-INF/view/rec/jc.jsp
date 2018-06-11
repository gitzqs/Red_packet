<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jspf/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<!-- 响应式 meta标签 -->
   		<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="${ctx}/css/hongbao.css">
		<title>饿了么一键红包领取</title>
	</head>
	<!-- 背景图片 -->
	<body style="background-color:#99b2d0" >	
		<div align="center" style="color:#463f39" class="container">
			<br><br><br>
			<h2 >饿了么Cookie贡献教程</h2>
			<br>
			<h6>首先这个教程不是我写的: <a target='_BLANK' href="https://www.mtdhb.com/tutorial/ele.html">原文链接</a></h6>
			<br>
			<h6>QQ小号可以马云家搜游戏小号几分钱一个，就不上链接了</h6>
			<br><br>
			<h3 >下面正式教程</h3>
			<br>
			<h6>1.用浏览器打开这个链接：<a target='_BLANK' href="https://h5.ele.me/hongbao/#hardware_id=&is_lucky_group=True&lucky_number=5&track_id=&platform=4&sn=29ef424ec3af0418&theme_id=2377&device_id=&refer_user_id=115092954">点我点我</a></h6>
			<br>
			<h6>2.浏览器设置：建议使用chrome浏览器。如果要贡献多个cookie，可以开启无痕模式。<br>按 F12 打开开发者工具，点击下图中的按钮，切换成 mobile 调试模式。 </h6>
			<img src="${ctx}/img/tutorial/step1.png">
			<br><br><br>
			<h6>3.点击当前模拟的设备名称，在下拉框中选择"Edit"。 </h6>
			<img src="${ctx}/img/tutorial/step2.png">
			<br><br><br>
			<h6>4.点击"Add custom device..."。</h6>
			<img src="${ctx}/img/tutorial/step3.png">
			<br><br><br>
			<h6>5.输入 device name ( 随便写一个 ) 和 User agent string  <div style="color:red">Mozilla/5.0 (Linux; Android 5.1; m1 metal Build/LMY47I; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.49 Mobile MQQBrowser/6.2 TBS/043409 Safari/537.36 V1ANDSQ7.2.5744YYBD QQ/7.2.5.3305 NetType/WIFI WebP/0.3.0 Pixel/1080</div>点击"Add"</h6>
			<img src="${ctx}/img/tutorial/step4.png">
			<br><br><br>
			<h6>6.点击步骤3中的设备名称，切换成刚才添加的设备，然后刷新页面。 </h6>
			<img src="${ctx}/img/tutorial/step5.png">
			<br><br><br>
			<h6>7.填写 qq 帐号，登录。然后在开发者工具切换tab至Console,输入document.cookie,回车，复制打印的信息。 </h6>
			<img src="${ctx}/img/tutorial/step6.png">
			<br><br><br>
			<h6>8.将上一步复制的 Cookie 粘贴到输入框，点击提交Cookie即可。</h6>
			<br><br><br>
			<h6>还有问题请点 <a target='_BLANK' href="https://github.com/SzPluto/elemeHongbao/issues">这里</a>提问</h6>
			<br><br><br><br><br><br>
		</div>
		
   		 <!-- jQuery,Popper JS,Bootstrap JS -->
		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script type="text/javascript">
			//Popover插件加载
			$(function () { 
				$("[data-toggle='popover']").popover();
			});
		</script>
	</body>
</html>