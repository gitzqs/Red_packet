package com.zqs.service.rec;

import java.util.List;

import com.zqs.model.rec.Donate;

public interface DonateService {
	
	/**
	 *  查找今日领取次数
	 * 
	 * @return
	 */
	public List<Donate> getDonate();

}
