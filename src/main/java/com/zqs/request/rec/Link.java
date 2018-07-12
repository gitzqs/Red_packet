package com.zqs.request.rec;

import java.io.Serializable;

public class Link implements Serializable{

	private static final long serialVersionUID = 2093595279016431616L;

	private int id;
	
	/** 标题 */
	private String title;
	
	/** 连接 */
	private String link;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
}
