//项目路径
var strPath = window.document.location.pathname;
var postPath = window.location.protocol + '//' + window.location.host + strPath.substring(0, strPath.substr(1).indexOf('/') + 1)
	+ "/";

$(function(){
	hide();

})
function recharge(){
	var amount = $("#amount").val();
	if(amount == null
			|| amount == ''){
		alert("请输入金额！");
		return ;
	}
	if(amount <= 0){
		alert("请输入大于0的金额！");
		return ;
	}
	var postData = {amount:amount}
	 $.ajax({
		 url: postPath + "recharge/pay",
	 	 type:"post",
		 dataType:"json",
		 contentType:"application/json",
		 data:JSON.stringify(postData),
		 success:function(resData){
			 if(resData.returnCode == '0000'){
				 $("#qrImg").attr("src",resData.returnData);
				 show();
			 }else{
				 showError(resData.returnMsg);
			 }
		 }
	 });	
}

function closeImg(){
	hide();
	window.location.reload();
}

function show(){
	$("#bjdiv").show();
	$("#imgDiv").show();
}
function hide(){
	$("#bjdiv").hide();
	$("#imgDiv").hide();
}