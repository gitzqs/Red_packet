package com.zqs.service.order;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public interface IOrderService {

	List<Map<String,Object>> pageLimit10();
	
	String pay(double amount);
	
	@Transactional
	String returnPay(String appId, String tradeNo);
}
