package com.zqs.service.cms.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.zqs.dao.cms.IUserMapper;
import com.zqs.model.base.ReturnObject;
import com.zqs.model.base.e.ReturnCode;
import com.zqs.model.cms.User;
import com.zqs.request.cms.AuthLoginUser;
import com.zqs.request.cms.AuthRegisterUser;
import com.zqs.service.cms.IUserService;
import com.zqs.utils.json.JacksonUtils;
@Service("userService")
public class DefaultUserServiceImpl implements IUserService {

	@Autowired
	private IUserMapper userMapper;
	
	@Override
	public User loadUserByloginname(String loginName) {
		return userMapper.loadUser(loginName);
	}

	@Override
	public String login(AuthLoginUser loginUser, HttpServletRequest req) {
		ReturnObject returnObject = new ReturnObject();
		String returnCode = ReturnCode.SUCCESS_CODE;
		String returnMsg = ReturnCode.SUCCESS_MSG;
		
		if(loginUser != null) {
			//1、获取参数
			String loginName = loginUser.getLoginName();	//登录名
			String password = loginUser.getPassword();		//密码（未加密）
			
			//2、验证参数是否为空
			if(!StringUtils.isEmpty(loginName)
					&& !StringUtils.isEmpty(password)) {
				
				//3、验证用户是否存在
				User user = userMapper.loadUser(loginName);
				if(user != null
						&& user.getId() != 0) {
					
						//5、验证密码
						if(DigestUtils.md5Hex(password).equals(user.getLoginPwd())) {
							
							//更新最新登录时间
							userMapper.updateTime(user.getId());
								
							//登录
							Subject subject = SecurityUtils.getSubject();
							UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(),user.getLoginPwd(),true,null);
							subject.login(token);
							
						}else {
							returnCode = ReturnCode.USER_LOGIN_PWD_ERROR_CODE;
							returnMsg = ReturnCode.USER_LOGIN_PWD_ERROR_MSG;
						}
					
				}else {
					returnCode = ReturnCode.USER_NOT_EXISTS_CODE;
					returnMsg = ReturnCode.USER_NOT_EXISTS_MSG;
				}
			}else {
				returnCode = ReturnCode.PARAMS_NULL_CODE;
				returnMsg = ReturnCode.PARAMS_NULL_MSG;
			}
		}else {
			returnCode = ReturnCode.PARAMS_MISS_CODE;
			returnMsg = ReturnCode.PARAMS_MISS_MSG;
		}
		returnObject.setReturnCode(returnCode);
		returnObject.setReturnMsg(returnMsg);
		return JacksonUtils.object2json(returnObject);
	}

	@Override
	public String register(AuthRegisterUser registerUser) {
		ReturnObject returnObject = new ReturnObject();
		String returnCode = ReturnCode.SUCCESS_CODE;
		String returnMsg = ReturnCode.SUCCESS_MSG;
		
		if(registerUser != null) {
			//1、获取参数
			Subject subject = SecurityUtils.getSubject();
			if(subject != null) {
				User user = (User)subject.getPrincipal();
				if(user != null) {
					String loginName = registerUser.getLoginName();		//用户名
					String loginPwd = registerUser.getLoginPwd();		//登录密码
					String loginPwdAgain = registerUser.getLoginPwdAgain(); //二次密码
					if(!StringUtils.isEmpty(loginPwd)
							&& !StringUtils.isEmpty(loginName)
							&& !StringUtils.isEmpty(loginPwdAgain)) {
						//2、验证用户是否注册
						User u = userMapper.loadUser(loginName);
						if(u == null
								|| u.getId() == 0) {
							if(loginPwd.equals(loginPwdAgain)) {
								u = new User();
								u.setLoginName(loginName);
								u.setLoginPwd(loginPwd);
								userMapper.save(u);
							}else {
								returnCode = ReturnCode.REGISTER_PWD_DIF_CODE;
								returnMsg = ReturnCode.REGISTER_PWD_DIF_MSG;
							}
						}else {
							returnCode = ReturnCode.USER_EXISTS_CODE;
							returnMsg = ReturnCode.USER_EXISTS_MSG;
						}
					}else {
						returnCode = ReturnCode.PARAMS_NULL_CODE;
						returnMsg = ReturnCode.PARAMS_NULL_MSG;
					}
				}else {
					returnCode = ReturnCode.LOGIN_OVERTIME_CODE;
					returnMsg = ReturnCode.LOGIN_OVERTIME_MSG;
				}
			}else {
				returnCode = ReturnCode.LOGIN_OVERTIME_CODE;
				returnMsg = ReturnCode.LOGIN_OVERTIME_MSG;
			}
		}else {
			returnCode = ReturnCode.PARAMS_MISS_CODE;
			returnMsg = ReturnCode.PARAMS_MISS_MSG;
		}
		returnObject.setReturnCode(returnCode);
		returnObject.setReturnMsg(returnMsg);
		return JacksonUtils.object2json(returnObject);
	}

}
