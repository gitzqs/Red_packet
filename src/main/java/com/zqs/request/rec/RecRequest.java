package com.zqs.request.rec;

import java.io.Serializable;

public class RecRequest implements Serializable{

	private static final long serialVersionUID = -2998257012069721345L;

	/** 手机号 */
	private String mobile;
	
	/** 红包链接 */
	private String url;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
