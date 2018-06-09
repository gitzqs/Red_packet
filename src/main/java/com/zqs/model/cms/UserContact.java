package com.zqs.model.cms;

import com.zqs.model.base.REntity;
/**
 * 用户关联
 * 
 * @author qiushi.zhou  
 * @date 2018年6月4日 下午3:16:23
 */
public class UserContact extends REntity{

	private static final long serialVersionUID = -4226629171655412032L;

	/** 父用户id */
	private int userId;
	
	/** 子用户id */
	private int childUserId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getChildUserId() {
		return childUserId;
	}

	public void setChildUserId(int childUserId) {
		this.childUserId = childUserId;
	}
	
	
}
