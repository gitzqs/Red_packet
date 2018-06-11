//项目路径
var strPath = window.document.location.pathname;
var postPath = window.location.protocol + '//' + window.location.host + strPath.substring(0, strPath.substr(1).indexOf('/') + 1)
	+ "/";

$(function(){
	$(".bj").hide();
	$(".xuzhi").hide();
	$(".shibai").hide();
	$(".three button").eq(0).click(function(){
		$(".bj").show();
		$(".xuzhi").show();
	});
	
	$(".xuzhi .close1").click(function(){
		$(".bj").hide();
		$(".xuzhi").hide();
	});
	$(".three button").eq(1).click(function(){
		$(".bj").show();
		$(".shibai").show();
	});
	$(".shibai .close1").click(function(){
		$(".bj").hide();
		$(".shibai").hide();
	});
});

function recHb(){
	var sleepInput = $("#sleepInput").val();
	if(sleepInput == 1){
		return ;
	}
	var mobile = $("#mobile").val();
	var url = $("#recUrl").val();
	if(mobile == null
			|| mobile == ''){
		alert("手机号必填！");
		return;
	}
	if(url == null
			|| url == ''){
		alert("红包链接必填！");
		return ;
	}
	$("#sleepInput").val("1");
	var postData = {mobile:mobile,url:url};
	$.ajax({
		 url: postPath + "rec/get",
	 	 type:"post",
		 dataType:"text",
		 contentType:"application/json",
		 data:JSON.stringify(postData),
		 success:function(resData){
			 $("#sleepInput").val("0");
			 $("#mobile").val("");
			 $("#recUrl").val("");
			 alert(resData);
		 }
	 });

	
}