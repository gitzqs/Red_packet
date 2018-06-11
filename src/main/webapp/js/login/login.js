//项目路径
var strPath = window.document.location.pathname;
var postPath = window.location.protocol + '//' + window.location.host + strPath.substring(0, strPath.substr(1).indexOf('/') + 1)
	+ "/";

$(function(){
	$("#errorDiv").hide();
})


/** 登录 */
function login(){
	hideError();
	var loginName = $("#loginName").val();
	var loginPwd = $("#loginPwd").val();
	if(loginName == ''
			|| loginName == null){
		showError("登录名必填！");
		return;
	}
	if(loginPwd == ''
			|| loginPwd == null){
		showError("登录密码必填！");
		return;
	}
	var postData = {loginName:loginName,password:loginPwd};
	 $.ajax({
		 url: postPath + "login/handle",
	 	 type:"post",
		 dataType:"json",
		 contentType:"application/json",
		 data:JSON.stringify(postData),
		 success:function(resData){
			 if(resData.returnCode == '0000'){
				 window.location.href = postPath + "rec/";
			 }else{
				 showError(resData.returnMsg);
			 }
		 }
	 });
}

/** 注册 */
function register(){
	var loginName = $("#loginName").val();
	var loginPwd = $("#loginPwd").val();
	var loginPwdAgain = $("#loginPwdAgain").val();
	
	if(loginName == null
			 || loginName == ''){
		showError("请输入账号！");
		return;
	}
	if(loginPwd == null
			|| loginPwd == ''){
		showError("请输入密码！");
		return;
	}
	if(loginPwd != loginPwdAgain){
		showError("两次输入密码必须一致！");
		return;
	}
	
	var postData = {loginName:loginName,loginPwd:loginPwd,loginPwdAgain:loginPwdAgain};
	 $.ajax({
		 url: postPath + "register/handle",
	 	 type:"post",
		 dataType:"json",
		 contentType:"application/json",
		 data:JSON.stringify(postData),
		 success:function(resData){
			 if(resData.returnCode == '0000'){
				 alert("注册成功!");
				 window.location.href = postPath + "login/";
			 }else{
				 showError(resData.returnMsg);
			 }
		 }
	 });
}

function showError(value){
	$("#errorDiv").text(value);
	$("#errorDiv").show();
}
function hideError(){
	$("#errorDiv").hide();
}