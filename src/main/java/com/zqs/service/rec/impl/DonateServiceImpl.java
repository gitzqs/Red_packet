package com.zqs.service.rec.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zqs.dao.rec.DonateDao;
import com.zqs.model.rec.Donate;
import com.zqs.service.rec.DonateService;

@Service("donateService")
public class DonateServiceImpl implements DonateService{

	@Resource
	private DonateDao donateDao;
	
	@Override
	public List<Donate> getDonate() {
		return donateDao.getDonate();
	}

}
