package com.zqs.model.bis;

import java.io.Serializable;
/**
 * 流水序号
 * 
 * @author qiushi.zhou  
 * @date 2018年6月8日 上午10:47:30
 */
public class GenerateCode implements Serializable{

	private static final long serialVersionUID = 1327496068050911871L;

	/** 主类型 */
	private String mainType;
	/** 第二类型 */
	private String secondType;
	/** 主前缀 */
	private String mainPrefix;
	/** 第二前缀 */
	private String secondPrefix;
	/** 日期前缀 */
	private String datePrefix;
	/** 流水长度 */
	private int noLength;
	/** 最终编码 */
	private String resultCode;
	
	public GenerateCode(String mainType, String secondType,
			String mainPrefix, String secondPrefix, int noLength) {
		super();
		this.mainType = mainType;
		this.secondType = secondType;
		this.mainPrefix = mainPrefix;
		this.secondPrefix = secondPrefix;
		this.noLength = noLength;
	}

	public GenerateCode(String mainType, String secondType,
			String mainPrefix, String secondPrefix, String datePrefix,
			int noLength) {
		super();
		this.mainType = mainType;
		this.secondType = secondType;
		this.mainPrefix = mainPrefix;
		this.secondPrefix = secondPrefix;
		this.datePrefix = datePrefix;
		this.noLength = noLength;
	}

	public String getMainType() {
		return mainType;
	}

	public void setMainType(String mainType) {
		this.mainType = mainType;
	}

	public String getSecondType() {
		return secondType;
	}

	public void setSecondType(String secondType) {
		this.secondType = secondType;
	}

	public String getMainPrefix() {
		return mainPrefix;
	}

	public void setMainPrefix(String mainPrefix) {
		this.mainPrefix = mainPrefix;
	}

	public String getSecondPrefix() {
		return secondPrefix;
	}

	public void setSecondPrefix(String secondPrefix) {
		this.secondPrefix = secondPrefix;
	}

	public String getDatePrefix() {
		return datePrefix;
	}

	public void setDatePrefix(String datePrefix) {
		this.datePrefix = datePrefix;
	}

	public int getNoLength() {
		return noLength;
	}

	public void setNoLength(int noLength) {
		this.noLength = noLength;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	
}
