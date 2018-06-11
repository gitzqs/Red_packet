package com.zqs.request.rec;

import java.io.Serializable;

public class Recharge implements Serializable{


	private static final long serialVersionUID = 1680647192949267568L;
	/** 金额 */
	private double amount;
	
	private String cookieUrl;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCookieUrl() {
		return cookieUrl;
	}

	public void setCookieUrl(String cookieUrl) {
		this.cookieUrl = cookieUrl;
	}
}
