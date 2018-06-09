package com.zqs.utils.sandpay.oper;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.zqs.utils.sandpay.base.SDKConfig;

/**
 * 订单查询
 * 
 * @author qiushi.zhou  
 * @date 2018年6月8日 上午9:56:29
 */
public class SandpayOrderQuery {
	
	public static  Logger logger = LoggerFactory.getLogger(SandpayOrderQuery.class);
	
	JSONObject header = new JSONObject();
	JSONObject body=new JSONObject();
	
	
	public void setHeader() {
		
		header.put("version", SandpayBase.version);			//版本号
		header.put("method",SandpayBase.ORDERQUERY);		//接口名称:统一下单并支付
		header.put("productId","00000007");	//产品编码,详见《杉德线上支付接口规范》 附录
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
		body.put("orderCode","2018050110523264");		//商户订单号，要查询的订单号
		body.put("extend", "");							//扩展域	
	};
}
