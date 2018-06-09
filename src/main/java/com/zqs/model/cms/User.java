package com.zqs.model.cms;

import java.util.Date;

import com.zqs.model.base.REntitytime;
import com.zqs.model.cms.e.EUserStatus;
/**
 * 用户基本信息
 * 
 * @author qiushi.zhou  
 * @date 2018年6月2日 下午1:53:00
 */
public class User extends REntitytime{

	private static final long serialVersionUID = -3783685544470301289L;

	/** 用户名 */
	private String loginName;
	
	/** 登录密码 */
	private String password;
	
	/** 手机号 */
	private String mobile;
	
	/** 邮箱 */
	private String email;
	
	/** 错误次数 */
	private int errorNum;
	
	/** 上次错误时间 */
	private Date lastErrorTime;
	
	/** 最近登录时间 */
	private Date lastLoginTime;
	
	/** 冻结到期时间 */
	private Date frozenTime;
	
	/** 状态 {@link EUserStatus.java}*/
	private int status;

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getErrorNum() {
		return errorNum;
	}

	public void setErrorNum(int errorNum) {
		this.errorNum = errorNum;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getFrozenTime() {
		return frozenTime;
	}

	public void setFrozenTime(Date frozenTime) {
		this.frozenTime = frozenTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getLastErrorTime() {
		return lastErrorTime;
	}

	public void setLastErrorTime(Date lastErrorTime) {
		this.lastErrorTime = lastErrorTime;
	}
	
	
}
