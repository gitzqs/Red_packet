/**
 * Copyright : http://www.sandpay.com.cn , 2011-2014
 * Project : sandpay-internetbank-demo
 * $Id$
 * $Revision$
 * Last Changed by pxl at 2018-4-27 下午4:24:11
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * pxl         2018-4-27        Initailized
 */
package com.zqs.utils.sandpay.oper;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.zqs.utils.sandpay.base.SDKConfig;

/**
 * 对账单下载
 * 
 * @author qiushi.zhou  
 * @date 2018年6月8日 上午9:57:29
 */
public class SandpayClearFileDownload {
	
	public static  Logger logger = LoggerFactory.getLogger(SandpayClearFileDownload.class);
	
	JSONObject header = new JSONObject();
	JSONObject body=new JSONObject();
	
	public void setHeader() {
		
		header.put("version", SandpayBase.version);			//版本号
		header.put("method", SandpayBase.ORDERPAY);			//接口名称:统一下单
		header.put("productId", SandpayBase.CLEARFILEDOWNLOAD);	//产品编码,根据实际支付方式确定
		header.put("mid", SDKConfig.getConfig().getMid());	//商户ID
		String plMid=SDKConfig.getConfig().getPlMid();		//平台商户ID
		if(plMid!=null && StringUtils.isNotEmpty(plMid)) {  //平台商户存在时接入
			header.put("accessType", "2");					//接入类型设置为平台商户接入
			header.put("plMid", plMid);
		}else {
			header.put("accessType", "1");					//接入类型设置为平台商户接入												//接入类型设置为普通商户接入
		}		
		header.put("channelType", "07");					//渠道类型：07-互联网   08-移动端
		header.put("reqTime", SandpayBase.getCurrentTime());	//请求时间		
	};
	
	
	public void setBody() {
		body.put("clearDate", "20180426");         //交易日期
		body.put("fileType", "1");                 //文件返回类型
		body.put("extend", "");                    //扩展域
		
	};
}
