package com.zqs.service.bis;

public interface IBisService {

	
	/**
	 * 生成不重复随机订单号
	 * 
	 * @return String
	 */
	String generateOrderCode(String mainType, String secondType);
}
