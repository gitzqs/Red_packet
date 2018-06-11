package com.zqs.service.rec;

public interface StatService {
	
	/**
	 *  查找今日领取次数
	 * 
	 * @return
	 */
	public String todayGetRecordNumber();
	
	/**
	 * 查找今日领取金额
	 * 
	 * @return
	 */
	public String todayGetRecordMoney();
	
	/**
	 * 查找总领取次数
	 * 
	 * @return
	 */
	public String allGetRecordNumber();
	
	/**
	 * 查找总领取金额
	 * 
	 * @return
	 */
	public String allGetRecordMoney();

}
