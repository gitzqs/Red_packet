//项目路径
var strPath = window.document.location.pathname;
var postPath = window.location.protocol + '//' + window.location.host + strPath.substring(0, strPath.substr(1).indexOf('/') + 1)
	+ "/";

$(function(){
	$(".bj").hide();
	$(".list").hide();
	$(".xz").eq(0).click(function(){
		$(".bj").show();
		$(".list").show();
	});
	
	$(".list .close1").click(function(){
		$(".bj").hide();
		$(".list").hide();
	});
	$(".list .close1").click(function(){
		$(".bj").hide();
		$(".list").hide();
	});
	
	
});


function delLink(index){
	if(confirm("确定删除？")){
		$.ajax({
			 url: postPath + "help/del",
		 	 type:"post",
			 dataType:"text",
			 data:{
				 id : index
			 },
			 success:function(resData){
				 if(resData.returnCode == '0000'){
					 alert("删除成功！");
				 }else{
					 showError(resData.returnMsg);
				 }
			 }
		 });
	}
}

function addLink(){
	var title = $("#title").val();
	var link = $("#link").val();
	if(title == null
			|| title == ''){
		return;
	}
	if(link == null
			|| link == ''){
		return ;
	}
	var postData = {title:title,link:link};
	 $.ajax({
		 url: postPath + "help/addLink",
	 	 type:"post",
		 dataType:"text",
		 contentType:"application/json",
		 data:JSON.stringify(postData),
		 success:function(resData){
			alert(resData);
		 }
	 });
}