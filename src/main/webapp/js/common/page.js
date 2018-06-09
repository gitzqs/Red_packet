//项目路径
var strPath = window.document.location.pathname;
var postPath = window.location.protocol + '//' + window.location.host + strPath.substring(0, strPath.substr(1).indexOf('/') + 1)
	+ "/";

/** 分页查询主函数 */
function base_page(object, url){
	$.ajax({
		url: postPath + url,
	 	type: "post",
		dataType: "json",
		contentType:"application/json",
		data : JSON.stringify(object),
		cache : false,
		error : function(){
			/** 暂不设置*/
		},
		success : function(data){
			/** 加入现有数据*/
			data_generate(data.returnData.list);
			/** 设置尾部导航*/
			setTailNavigation(data.returnData.total,data.returnData.offset,data.returnData.rows);
		}
	});
}

/** 清空 */
function emptyTableData(){
	$("#listDiv").html("");
}

/** 生成数据 */
function data_generate(rows){
	//获取列表参数
	var params = {};
	var params_size = 0;
	$("#paramsDiv input[type='text']").each(function(){
		params[params_size] = $(this).val();
		params_size++;
	});
	//清空之前数据
	emptyTableData();
	if(rows.length == 0){
		$("#listDiv").val("暂无数据!");
	}else{
		for(var j=0; j < rows.length; j++){
			$("#listDiv").append("<ul class='table_two' id='listUl" + j + "'>");
			for(var k=0; k<params_size; k++){
				if(rows[j][params[k]] == undefined){
					rows[j][params[k]] = '-';
				}
				$("#listUl"+j).append("<li class='table_li'>" + rows[j][params[k]] + "</li>");
			}
			$("#listUl"+j).append("<div class='clearfix'></div>");
			$("#listDiv").append("</ul>");
			$("#listDiv").append("<div class='table_line4'></div>");
		}
	}
}

/** 尾部导航 */
function setTailNavigation(total,offset,rows){
	//清空原有导航
	$("#bottomNav").html("");
	
	var curPage = Math.ceil((offset + 1)/rows);
	var totalPage = Math.ceil(total/rows);
	
	$("#bottomNav").append("<a class='anniu' href='javascript:goNav(4,"+curPage+"," + totalPage +","+rows+");'><img class='anniu_img' src='/Pay_platform/img/xia.png'></a>");
	$("#bottomNav").append("<a class='anniu' href='javascript:goNav(3,"+curPage+"," + totalPage +","+rows+");'><img class='anniu_img' src='/Pay_platform/img/right.png'></a>");
	$("#bottomNav").append("<div><input class='anniu_input' type='text' value='" + curPage + "'></div>");
	$("#bottomNav").append("<a class='anniu' href='javascript:goNav(2,"+curPage+"," + totalPage +","+rows+");'><img class='anniu_img' src='/Pay_platform/img/left.png'></a>");
	$("#bottomNav").append("<a class='anniu' href='javascript:goNav(1,"+curPage+"," + totalPage +","+rows+");'><img class='anniu_img' src='/Pay_platform/img/shang.png'></a>");
	if(total == 0){
		$("#bottomNav").append("<div class='anniu_zi'>0条，共0条</div>");
	}else{
		var t = offset + rows;
		if(curPage == totalPage){
			var t = total;
		}
		$("#bottomNav").append("<div class='anniu_zi'>" + (offset+1) +"~" + t + "条，共" + total + "条</div>");
	}
}

/** 翻页 */
function goNav(type,curPage,totalPage,rows){
	console.log(type);

	switch(type){
	case 1 :
		if(curPage > 1){
			page(0);
		}
		break;
	case 2 :
		if(curPage > 1){
			page((curPage-2)*rows);
		}
		break;
	case 3 :
		if(curPage < totalPage){
			page(curPage*rows);
		}
		break;
	case 4 :
		if(curPage < totalPage){
			page((totalPage-1)*rows);
		}
		break;
	}
	return ;
	
}