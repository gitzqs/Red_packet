package com.zqs.model.cms;

import java.util.Date;

import com.zqs.model.base.REntity;
/**
 * 验证码
 * 
 * @author qiushi.zhou  
 * @date 2018年6月4日 上午11:22:25
 */
public class VerifyCode extends REntity{

	private static final long serialVersionUID = -345643180922364654L;

	/** 用户id */
	private int userId;
	
	/** uuid */
	private String uuid;
	
	/** 类型{@link EVerifyCodeType.java} */
	private int type;
	
	/** 验证码 */
	private String code;
	
	/** 创建时间 */
	private Date createdTime;
	
	/** 过期时间 */
	private Date expiryTime;
	
	/** 状态{@link EStatus.java} */
	private int status;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
}
