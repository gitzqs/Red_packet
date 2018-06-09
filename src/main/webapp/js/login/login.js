//项目路径
var strPath = window.document.location.pathname;
var postPath = window.location.protocol + '//' + window.location.host + strPath.substring(0, strPath.substr(1).indexOf('/') + 1)
	+ "/";

$(function(){
	$("#errorDiv").hide();
})
/** 更新图片验证码 */
function changeVerifyCode(){     
	$("#getcode_img").attr("src",chgUrl());     
}     
//时间戳     
//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳     
function chgUrl(){
	var timestamp = (new Date()).valueOf();   
	var url = postPath + "verifyCode/generateCode?timestamp=" + timestamp;     
	return url;     
} 

/** 登录 */
function login(){
	$("#errorDiv").hide();
	var loginName = $("#loginName").val();
	var loginPwd = $("#loginPwd").val();
	var loginCode = $("#loginCode").val();
	if(loginName == ''
			|| loginName == null){
		$("#errorDiv").text("登录名必填！");
		$("#errorDiv").show();
		return;
	}
	if(loginPwd == ''
			|| loginPwd == null){
		$("#errorDiv").text("登录密码必填！");
		$("#errorDiv").show();
		return;
	}
	if(loginCode == ''
			|| loginCode == null){
		$("#errorDiv").text("验证码必填！");
		$("#errorDiv").show();
		return;
	}
	var postData = {loginName:loginName,password:loginPwd,verifyCode:loginCode};
	console.log(JSON.stringify(postData));
	 $.ajax({
		 url: postPath + "login/handle",
	 	 type:"post",
		 dataType:"json",
		 contentType:"application/json",
		 data:JSON.stringify(postData),
		 success:function(resData){
			 if(resData.returnCode == '0000'){
				 window.location.href = postPath + "account/";
			 }else{
				 $("#errorDiv").text(resData.returnMsg);
				 $("#errorDiv").show();
			 }
		 }
	 });
}