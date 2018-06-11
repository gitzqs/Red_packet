package com.zqs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zqs.service.order.IOrderService;
import com.zqs.utils.bean.ApplicationContextHolder;
/**
 * 异步通知
 * @author zqs
 *
 */
public class AlipayNotifyServlet extends HttpServlet{

	private static final long serialVersionUID = -2143564254393702884L;
	
	private Logger logger = LoggerFactory.getLogger(AlipayNotifyServlet.class);
	
	IOrderService orderService = (IOrderService) ApplicationContextHolder.getBean("orderService");
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        doPost(request,response);
    }
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8"); 
        response.setCharacterEncoding("utf-8");
        //输出
        PrintWriter out = response.getWriter();
        //输出结果
        String result = "fail";
                         
        try{
        	String appId = request.getParameter("app_id")==null ? null
        			: request.getParameter("app_id").toString();
        	String tradeno = request.getParameter("out_trade_no")==null ? null
        			: request.getParameter("out_trade_no").toString();
        	//逻辑处理
        	result = orderService.returnPay(appId, tradeno);
            
        }catch(Exception e){
        	logger.error("notify error,[{}]",e);
        }finally{
        	out.write(result);
        }
    }
}
