package com.zqs.utils.alipayf2f;

import java.util.HashMap;
import java.util.Map;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.zqs.utils.alipay.AlipayConfig;
import com.zqs.utils.json.JacksonUtils;
import com.zqs.utils.tool.ToolUtils;

public class AliF2fUtils {

	public static String alipay(String parameters) {

		try {
			AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
					AlipayConfig.APPID, AlipayConfig.APP_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET,
					AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGN_TYPE);
			AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
			request.setNotifyUrl(AlipayConfig.NOTIFY_URL);
			request.setBizContent(parameters);
			AlipayTradePrecreateResponse response = alipayClient.execute(request);
			if (response.isSuccess()) {

				return response.getQrCode();
			} else {
				System.out.println("调用失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("out_trade_no", ToolUtils.randomOrderNo("HB"));
		map.put("total_amount", 0.01);
		map.put("subject", "积分充值");
		map.put("notify_url", AlipayConfig.NOTIFY_URL);

		System.out.println(alipay(JacksonUtils.object2json(map)));
	}

}
