package com.zqs.dao.order;

import java.util.List;
import java.util.Map;

public interface IOrderMapper {

	/**
	 * 新增
	 * @param map
	 */
	void save(Map<String,Object> map);
	
	/**
	 * 更新
	 * @param map
	 */
	void update(String tradeNo);
	
	/**
	 * 查询
	 * @param userId
	 * @return
	 */
	List<Map<String,Object>> loadLimit10(int userId);
	
	int loadUserid(String tradeNo);
	
	String loadAmount(String tradeNo);
}
