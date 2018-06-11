package com.zqs.web.cms;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zqs.request.cms.AuthLoginUser;
import com.zqs.request.cms.AuthRegisterUser;
import com.zqs.service.cms.IUserService;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 登录页面
	 * 
	 * @return String
	 */
	@RequestMapping(value="login/",method=RequestMethod.GET)
	public String login() {
		
		return "login/login";
	}
	
	/**
	 * 用户登录处理
	 * 
	 * @return String
	 */
	@RequestMapping(value="login/handle",method=RequestMethod.POST)
	@ResponseBody
	public String loginHandle(@RequestBody AuthLoginUser loginUser,
			HttpServletRequest req) {
		
		return userService.login(loginUser, req);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="register/",method=RequestMethod.GET)
	public String register() {
		
		return "login/register";
	}
	/**
	 * 注册处理
	 * 
	 * @return String
	 */
	@RequestMapping(value="register/handle",method=RequestMethod.POST)
	@ResponseBody
	public String register(@RequestBody AuthRegisterUser registerUser) {
		
		return userService.register(registerUser);
	}
	
	/**
	 * 退出
	 * 
	 * @return String
	 */
	@RequestMapping(value="logout/",method=RequestMethod.GET)
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		if(subject != null) {
			subject.logout();
		}
		return "redirect:/login/";
	}
}
