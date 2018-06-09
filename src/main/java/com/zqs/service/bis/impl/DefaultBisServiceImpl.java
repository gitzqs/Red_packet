package com.zqs.service.bis.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zqs.dao.bis.IGenerateCodeMapper;
import com.zqs.model.bis.GenerateCode;
import com.zqs.service.bis.IBisService;
@Service("bisService")
public class DefaultBisServiceImpl implements IBisService {
	
	@Autowired
	private IGenerateCodeMapper generateCodeMapper;
	


	@Override
	public String generateOrderCode(String mainType, String secondType) {
		GenerateCode generateCode = new GenerateCode(
				mainType, secondType, "10", "", 10);
		generateCodeMapper.generateCode(generateCode);
		return generateCode.getResultCode();
	}

}
