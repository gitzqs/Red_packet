package com.zqs.model.cms;

import java.util.Date;

import com.zqs.model.base.REntity;
/**
 * 用户基本信息
 * 
 * @author qiushi.zhou  
 * @date 2018年6月2日 下午1:53:00
 */
public class User extends REntity{

	private static final long serialVersionUID = -3783685544470301289L;

	/** 用户名 */
	private String loginName;
	
	/** 登录密码 */
	private String loginPwd;
	
	/** 创建时间 */
	private Date createdTime;
	
	/** 最近登录时间 */
	private Date lastLoginTime;

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

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	
	

	
	
	
}
