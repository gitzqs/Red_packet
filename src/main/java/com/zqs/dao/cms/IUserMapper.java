package com.zqs.dao.cms;

import java.util.Map;

import com.zqs.model.cms.User;

public interface IUserMapper {
	
	/**
	 * 根据登录名获取用户
	 * 
	 * @return User
	 */
	User loadUser(String loginName);
	
	/**
	 * 更新登录时间
	 * 
	 * @return void
	 */
	void updateTime(int id);
	
	/**
	 * 新增
	 * 
	 * @return void
	 */
	void save(User user);
	
	/**
	 * 获取积分
	 * @param userId
	 * @return
	 */
	int loadScore(int userId);
	
	void updateScore(Map<String,Object> map);
}
