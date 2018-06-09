package com.zqs.dao.bis;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zqs.model.bis.GenerateCode;

public interface IGenerateCodeMapper {

	/**
	 * 生成不重复随机码
	 * 
	 * @return void
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	void generateCode(GenerateCode gc);
}
