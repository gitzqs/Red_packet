package com.zqs.request.cms;

import java.io.Serializable;
/**
 * 登录参数
 * 
 * @author qiushi.zhou  
 * @date 2018年6月2日 下午2:28:02
 */
public class AuthLoginUser implements Serializable{

	private static final long serialVersionUID = 5767037520447448255L;

	/** 登录名 */
	private String loginName;
	
	/** 登录密码 */
	private String password;
	
	/** 验证码 */
	private String verifyCode;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
	
}
