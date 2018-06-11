package com.zqs.utils.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.methods.HttpPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http post 请求
 * 
 * @author qiushi.zhou  
 * @date 2016年12月12日 下午2:23:08
 */
public class HttpDoPost {
	
	private static Logger logger = LoggerFactory.getLogger(HttpPost.class);
	/**
	 * 获取http请求的参数
	 * 
	 * @param 
	 * @return String
	 */
	public static String getPostParams(HttpServletRequest request){
		String result = null;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
			StringBuffer sb = new StringBuffer();
			String line = null;
			while((line = br.readLine()) != null){
				sb.append(line);
			}
			result = URLDecoder.decode(sb.toString(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("获取json参数失败,[{}]",e);
		} catch (IOException e) {
			logger.error("获取json参数失败,[{}]",e);
			e.printStackTrace();
		}
		return result;
	}
	
}
