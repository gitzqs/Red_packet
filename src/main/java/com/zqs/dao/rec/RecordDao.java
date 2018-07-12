package com.zqs.dao.rec;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zqs.request.rec.Link;

public interface RecordDao {
	
	/**
	 * 插入领取记录数据
	 * @param id
	 * @param phoneNum
	 */
	public void insertRecord(@Param("money")String money, @Param("phone")String phone ,@Param("succeed")int succeed,@Param("time")Date time,@Param("remakes")String remakes);
	
	/**
	 * 查找今日领取次数
	 * @return
	 */
	public String todayGetRecordNumber();
	
	/**
	 * 查找今日领取金额
	 * @return
	 */
	public String todayGetRecordMoney();
	
	/**
	 * 查找总领取次数
	 * @return
	 */
	public String allGetRecordNumber();
	
	/**
	 * 查找总领取金额
	 * @return
	 */
	public String allGetRecordMoney();
	
	/**
	 * 查询
	 * @param userId
	 * @return
	 */
	List<Map<String,Object>> pageLimit10(int userId);
	
	List<Map<String,Object>> loadLink();
	
	void del(int id);
	
	void addLink(Link link);
}
