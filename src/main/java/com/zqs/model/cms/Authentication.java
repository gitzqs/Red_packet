package com.zqs.model.cms;

import java.util.Date;

import com.zqs.model.base.REntity;
/**
 * 实名认证
 * 
 * @author qiushi.zhou  
 * @date 2018年6月4日 下午4:44:54
 */
public class Authentication extends REntity{

	private static final long serialVersionUID = 673469044652080482L;

	/** 用户id */
	private int userId;
	
	/** 真实姓名 */
	private String realName;
	
	/** 身份证号码 */
	private String idNumber;
	
	/** 创建时间 */
	private Date createdTime;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	
}
