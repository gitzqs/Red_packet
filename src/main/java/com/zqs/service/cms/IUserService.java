package com.zqs.service.cms;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;

import com.zqs.model.cms.User;
import com.zqs.request.cms.AuthLoginUser;
import com.zqs.request.cms.AuthRegisterUser;

public interface IUserService {

	/**
	 * 根据用户名获取用户信息
	 * 
	 * @param loginName
	 * 		用户名
	 * @return User
	 */
	User loadUserByloginname(String loginName);
	
	/**
	 * 用户登录处理
	 * 
	 * @return String
	 */
	@Transactional
	String login(AuthLoginUser loginUser, HttpServletRequest req);
	
	/**
	 * 注册
	 * 
	 * @return String
	 */
	@Transactional
	String register(AuthRegisterUser registerUser);
	
	int loadScore();
}
