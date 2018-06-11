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
		<title>饿了么Cookie贡献</title>
		<script type="text/javascript">
		</script>
		<script src="${ctx}/js/rec/gx.js" type="text/javascript"></script>
		</head>
	<!-- 背景图片 -->
	<body style="background-image:url(${ctx}/img/background.jpg);">	
		<div class=".container-fluid" align="center">
			<h1 style="margin-top:7%;color:#463f39;font-size:40px;font-family:Sans-serif" >饿了么Cookie贡献</h1>
			<div class="highlight border border-secondary" style="margin-top:3%;">
				<div align="left" style="margin:0px 0px 0px 10px;">
					<a>如果贡献小号无响应可以试试重启电脑哦..<br>贡献的小号第二天才会生效哦..</a>
				</div>
			</div>
			<div class="highlight border border-secondary" style="max-width:600px;padding:1rem">
				<form  id="formCookie">
					<div class="input-group mb-3" style="height:160px">
						<div class="input-group-prepend">
							<span class="input-group-text">&nbsp;&nbsp;Cookie&nbsp;</span>
						</div>
						<textarea class="form-control " placeholder="输入Cookie" name="urlCookie" id="urlCookie"></textarea>		
					</div>
					<div align="left">
						<div class="btn-group" role="group" aria-label="Basic example" >
							<!-- <button type="button" class="btn btn-danger" onclick="backHome()">回到主页</button> -->
							<button type="button" class="btn btn-secondary" onclick="getTutorial()">教程在这</button>
						</div>
						<input type="button"  class="btn btn-secondary float-right" value="提交Cookie" onclick="submitCookie()" id="submit"/>
					</div>
				</form>	
			</div>
		</div>
		<div>
			<input hidden id="check" value="0"></input>
		</div>
   		 <!-- jQuery,Popper JS,Bootstrap JS -->
<!-- 		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
 -->		<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script type="text/javascript">
			//Popover插件加载
			$(function () { 
				$("[data-toggle='popover']").popover();
			});
			
			function backHome(){
				if(document.getElementById("urlCookie").value != ""){
					var r = confirm("是否回到主页\n请确保Cookie已提交或保存")
					if(r==true){
						window.location.href='..';
					}
				}else{
					window.location.href='..';
				}
			}
			
			function getTutorial(){
				window.open('${ctx}/help/jc');
			}
			

		</script>
	</body>
</html>