package com.zqs.dao.rec;

import java.util.List;

import com.zqs.model.rec.Donate;
public interface DonateDao {

	/**
	 * 查找前五条捐献记录
	 * @return
	 */
	public List<Donate> getDonate();
}
