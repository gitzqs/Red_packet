//项目路径
var strPath = window.document.location.pathname;
var postPath = window.location.protocol + '//' + window.location.host + strPath.substring(0, strPath.substr(1).indexOf('/') + 1)
	+ "/";
var length = 5;

//加载列表
$(function(){
	changeClass(1);
	page(0);
});

//分页查询
function page(offset){
	var type = $("#searchType").val();
	var status = $("#statusQ").val();
	var beginTime = $("#beginTime").val();
	var endTime = $("#endTime").val();
	var object = {type:type,status:status,beginTime:beginTime,endTime:endTime,offset:offset,rows:length};
	base_page(object,"order/page");
}

//分类查询
function selectType(type){
	switch(type){
	case 1 :
		changeClass(1);
		page(0);
		break;
	case 2 :
		changeClass(2);
		page(0);
		break;
	case 3 :
		changeClass(3);
		page(0);
		break;
	}
}

function changeClass(type){
	switch(type){
	case 1:
		$("#searchType").val("1");
		$("#rechargeBg1").addClass("order_bg1");
		$("#rechargeBg2").css("color","#f17411");
		$("#withdrowBg1").removeClass("order_bg1");
		$("#withdrowBg2").css("color","#666");	
		$("#payBg1").removeClass("order_bg1");
		$("#payBg2").css("color","#666");	
		break;
	case 2 :
		$("#searchType").val("2");
		$("#rechargeBg1").removeClass("order_bg1");
		$("#rechargeBg2").css("color","#666");
		$("#withdrowBg1").addClass("order_bg1");
		$("#withdrowBg2").css("color","#f17411");	
		$("#payBg1").removeClass("order_bg1");
		$("#payBg2").css("color","#666");
		break;
	case 3 :
		$("#searchType").val("3");
		$("#rechargeBg1").removeClass("order_bg1");
		$("#rechargeBg2").css("color","#666");
		$("#withdrowBg1").removeClass("order_bg1");
		$("#withdrowBg2").css("color","#666");
		$("#payBg1").addClass("order_bg1");
		$("#payBg2").css("color","#f17411");
		break;	
	}

}
