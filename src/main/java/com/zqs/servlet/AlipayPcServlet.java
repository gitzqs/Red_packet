package com.zqs.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.util.StringUtils;
import com.zqs.utils.alipay.AlipayConfig;
import com.zqs.utils.alipay.AlipayUtils;
import com.zqs.utils.json.JacksonUtils;

public class AlipayPcServlet extends HttpServlet{

	private static final long serialVersionUID = 6451734198058582058L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        doPost(request,response);
    }
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse httpResponse) throws ServletException,
            IOException {
		
		//获取参数
		String out_trade_no = request.getParameter("out_trade_no")==null ? null
				: request.getParameter("out_trade_no").toString();  //商户订单号
		String total_amount = request.getParameter("total_amount")==null ? null
				: request.getParameter("total_amount").toString();  //订单总金额
		String subject = request.getParameter("subject")==null ? null
				: request.getParameter("subject").toString();  //订单标题
		String body = request.getParameter("body")==null ? null
				: request.getParameter("body").toString();  //订单描述
		String goods_type = request.getParameter("goods_type")==null ? null
				: request.getParameter("goods_type").toString();  //商品主类型.0:虚拟；1:实体
		String return_url = request.getParameter("return_url")==null ? null
				: request.getParameter("return_url").toString();  //商户返回地址
		String notify_url = request.getParameter("notify_url")==null ? null
				: request.getParameter("notify_url").toString();  //异步通知地址
		
		//组合参数
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("out_trade_no", out_trade_no);
		map.put("product_code", AlipayConfig.PRODUCT_CODE);
		map.put("total_amount", total_amount);
		map.put("subject", subject);
		if(!StringUtils.isEmpty(body)){
			map.put("body", body);
		}
		if(!StringUtils.isEmpty(goods_type)){
			map.put("goods_type", goods_type);
		}
		map.put("sys_service_provider_id", AlipayConfig.SYS_SERVICE_PROVIDER_ID);
		
		//获取form表单参数
		String form = AlipayUtils.alipay(JacksonUtils.object2json(map),return_url,notify_url);
	    httpResponse.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
	    httpResponse.getWriter().write(form);
	    httpResponse.getWriter().flush();
	    httpResponse.getWriter().close();
    }
}
