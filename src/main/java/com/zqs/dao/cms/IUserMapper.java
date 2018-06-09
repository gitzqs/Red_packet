package com.zqs.dao.cms;

import java.util.Map;

import com.zqs.model.cms.User;

public interface IUserMapper {
	
	/**
	 * 根据用户名获取用户信息
	 * 
	 * @param loginName
	 * 		用户名
	 * @return User
	 */
	User loadUserByloginname(String loginName);
	
	/**
	 * 用户基本信息更新
	 * 
	 * @return void
	 */
	void update(Map<String,Object> map);
	
	/**
	 * 新增用户
	 * 
	 * @return void
	 */
	void save(User user);
}
