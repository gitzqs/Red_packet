//项目路径
var strPath = window.document.location.pathname;
var postPath = window.location.protocol + '//' + window.location.host + strPath.substring(0, strPath.substr(1).indexOf('/') + 1)
	+ "/";

//ajax提交表单
function submitCookie(){
	if(document.getElementById("urlCookie").value != "" && document.getElementById("check").value == "0"){		//通过检测value的办法防止重复点击
		document.getElementById("check").value = "1";		//value
		/* var form = new FormData(document.getElementById("formCookie"));
        var xmlHttp = new XMLHttpRequest();
        xmlHttp.open("post", "${ctx}/help/insertCookie", false);
        xmlHttp.onreadystatechange=function(){
			if(xmlHttp.readyState==4 && xmlHttp.status==200){
            	alert(xmlHttp.responseText);
            }
        }
        xmlHttp.send(form); */
        var cookieUrl = $("#urlCookie").val();
     var postData = {cookieUrl:cookieUrl};
   	 $.ajax({
   		 url: postPath + "help/insertCookie",
   	 	 type:"post",
   		 dataType:"text",
   		 contentType:"application/json",
   		 data:JSON.stringify(postData),
   		 success:function(resData){
   			alert(resData);
   		 }
   	 });

        document.getElementById("check").value = "0";
        document.getElementById("urlCookie").value = "";		//领取完后自动清空URL中的内容，防止误触
	}
}