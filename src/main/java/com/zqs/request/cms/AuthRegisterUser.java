package com.zqs.request.cms;

import java.io.Serializable;
/**
 * 注册参数
 * 
 * @author qiushi.zhou  
 * @date 2018年6月4日 下午2:30:31
 */
public class AuthRegisterUser implements Serializable{

	private static final long serialVersionUID = -1487314783414331859L;
	
	/** 用户名 */
	private String loginName;
	
	/** 密码 */
	private String loginPwd;
	
	/** 密码again */
	private String loginPwdAgain;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getLoginPwdAgain() {
		return loginPwdAgain;
	}

	public void setLoginPwdAgain(String loginPwdAgain) {
		this.loginPwdAgain = loginPwdAgain;
	}
	
	

}
