package com.zqs.model.cms.e;
/**
 * 验证码类型
 * 
 * @author qiushi.zhou  
 * @date 2018年6月4日 下午1:15:50
 */
public interface EVerifyCodeType {

	/** 图文验证码 */
	int TEXT_CODE = 1;
	
	/** 手机验证码 */
	int MOBILE_CODE = 2;
	
	/** 邮箱验证码 */
	int EMAIL_CODE = 3;
}
