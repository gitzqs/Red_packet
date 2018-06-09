package com.zqs.service.cms.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
import com.zqs.model.cms.e.EUserStatus;
import com.zqs.request.cms.AuthLoginUser;
import com.zqs.request.cms.AuthRegisterUser;
import com.zqs.service.cms.IUserService;
import com.zqs.utils.json.DateFormatUtils;
import com.zqs.utils.json.JacksonUtils;
@Service("userService")
public class DefaultUserServiceImpl implements IUserService {

	@Autowired
	private IUserMapper userMapper;
	
	@Override
	public User loadUserByloginname(String loginName) {
		return userMapper.loadUserByloginname(loginName);
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
			Date date = new Date();
			
			//2、验证参数是否为空
			if(!StringUtils.isEmpty(loginName)
					&& !StringUtils.isEmpty(password)) {
				
				//3、验证用户是否存在
				User user = userMapper.loadUserByloginname(loginName);
				if(user != null
						&& user.getId() != 0) {
					
					//4、验证用户状态
					Map<String,Object> requestMap = new HashMap<String,Object>();
					if(user.getStatus() == EUserStatus.FROZEN
							&& user.getFrozenTime().before(date)) {
						requestMap.put("id", user.getId());
						requestMap.put("status", EUserStatus.ACTIVE);
						requestMap.put("errorNum", 0);
						userMapper.update(requestMap);
						user.setStatus(EUserStatus.ACTIVE);
						user.setErrorNum(0);
					}
					if(user.getStatus() == EUserStatus.ACTIVE) {
						//5、验证密码
						if(DigestUtils.md5Hex(password).equals(user.getPassword())) {
							
							//登录成功
							requestMap.clear();
							requestMap.put("id", user.getId());
							requestMap.put("status", EUserStatus.ACTIVE);
							requestMap.put("errorNum", 0);
							requestMap.put("lastLoginTime", date);
							userMapper.update(requestMap);
								
							//登录
							Subject subject = SecurityUtils.getSubject();
							UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(),user.getPassword(),true,null);
							subject.login(token);
							
						}else {
							requestMap.clear();
							requestMap.put("id", user.getId());
							if(user.getErrorNum() == 4) {
								if(user.getLastErrorTime().before(DateFormatUtils.addOrSub(date, 4, -3))) {
									requestMap.put("errorNum", 1);
									requestMap.put("lastErrorTime", date);
									requestMap.put("status", EUserStatus.ACTIVE);
									returnCode = ReturnCode.USER_LOGIN_PWD_ERROR_CODE;
									returnMsg = ReturnCode.USER_LOGIN_PWD_ERROR_MSG + ",再输入错误4次，帐号将冻结三小时！";
								}else {
									requestMap.put("errorNum", 5);
									requestMap.put("lastErrorTime", date);
									Date frozenTime = DateFormatUtils.addOrSub(date, 4, 3);
									requestMap.put("frozenTime", frozenTime);
									requestMap.put("status", EUserStatus.FROZEN);
									returnCode = ReturnCode.USER_LOGIN_PWD_ERROR_CODE;
									returnMsg = ReturnCode.USER_LOGIN_PWD_ERROR_MSG + ",帐号已冻结，将于"
											+ DateFormatUtils.format(frozenTime, DateFormatUtils.ymd_hms)
											+ "之后解冻！";
								}
							}else {
								requestMap.put("errorNum", user.getErrorNum() + 1);
								requestMap.put("status", EUserStatus.ACTIVE);
								requestMap.put("lastErrorTime", date);
								returnCode = ReturnCode.USER_LOGIN_PWD_ERROR_CODE;
								returnMsg = ReturnCode.USER_LOGIN_PWD_ERROR_MSG + ",再输入错误" + 
								 (4 - user.getErrorNum()) + "次，帐号将冻结三小时！";
							}
							userMapper.update(requestMap);
						}
					}else {
						if(user.getStatus() == EUserStatus.UN_ACTIVE) {
							returnCode = ReturnCode.USER_UNACTIVE_CODE;
							returnMsg = ReturnCode.USER_UNACTIVE_MSG;
						}else {
							returnCode = ReturnCode.USER_FROZEN_CODE;
							returnMsg = ReturnCode.USER_FROZEN_MSG
									+ "， 请于" + DateFormatUtils.format(user.getFrozenTime(), DateFormatUtils.ymd_hms)
									+ "之后再登录！";
						}
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
					if(!StringUtils.isEmpty(loginPwd)
							&& !StringUtils.isEmpty(loginName)) {
						//2、验证用户是否注册
						User u = userMapper.loadUserByloginname(loginName);
						if(u == null
								|| u.getId() == 0) {
							//3、新增用户
							u = new User();
							u.setLoginName(loginName);
							u.setPassword(loginPwd);
							u.setStatus(EUserStatus.ACTIVE);
							userMapper.save(u);
							
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
