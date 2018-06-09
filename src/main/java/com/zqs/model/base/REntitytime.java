package com.zqs.model.base;

import java.io.Serializable;
import java.util.Date;
public class REntitytime implements Serializable{

	private static final long serialVersionUID = -2149786476457798698L;

	private int id;
	
	/** 创建人id */
	private int creatorId;
	
	/** 创建时间 */
	private Date createdTime;
	
	/** 最近修改人 */
	private int lastOperatorId;
	
	/** 最近修改时间 */
	private Date lastOperatedTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public int getLastOperatorId() {
		return lastOperatorId;
	}

	public void setLastOperatorId(int lastOperatorId) {
		this.lastOperatorId = lastOperatorId;
	}

	public Date getLastOperatedTime() {
		return lastOperatedTime;
	}

	public void setLastOperatedTime(Date lastOperatedTime) {
		this.lastOperatedTime = lastOperatedTime;
	}
	
	
}
