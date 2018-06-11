package com.zqs.utils.alipay;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.zqs.utils.json.JacksonUtils;
import com.zqs.utils.tool.ToolUtils;

/**
 * 支付宝PC端支付工具类
 * 
 * @author qiushi.zhou  
 * @date 2017年7月14日 上午10:35:13
 */
public class AlipayUtils {
	
	private static Logger logger = LoggerFactory.getLogger(AlipayUtils.class);
	/**
	 * 支付宝支付传参
	 * 
	 * @param 
	 * @return String
	 */
	public static String alipay(String parameters,String returnUrl,
			String notifyUrl){
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.GATEWAY_URL,
				AlipayConfig.APPID,AlipayConfig.APP_PRIVATE_KEY,AlipayConfig.FORMAT,
				AlipayConfig.CHARSET,AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGN_TYPE);
		
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
	    alipayRequest.setReturnUrl(returnUrl);  //页面跳转同步通知页面路径
	    alipayRequest.setNotifyUrl(notifyUrl);//服务器异步通知页面路径
	    alipayRequest.setBizContent(parameters);//填充业务参数
	    String form="";
	    try {
	        form = alipayClient.pageExecute(alipayRequest).getBody(); 
	    } catch (AlipayApiException e) {
	        logger.error("获取支付form表单失败,[{}]",e);
	    }
		return form;
	}
	
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("out_trade_no",ToolUtils.randomOrderNo("HB"));
		map.put("total_amount", 10);
		map.put("subject", "积分充值");
		map.put("goods_type",0);
		map.put("return_url", "www.le-pv.com");
		map.put("notify_url", "www.le-pv.com");
		System.out.println(alipay(JacksonUtils.object2json(map),"www.le-pv.com","www.le-pv.com"));
	}
}
