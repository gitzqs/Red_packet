package com.zqs.model.cms.e;
/**
 * 用户状态
 * 
 * @author qiushi.zhou  
 * @date 2018年6月2日 下午1:57:26
 */
public interface EUserStatus {

	/** 失效 */
	int UN_ACTIVE = 0;
	
	/** 生效 */
	int ACTIVE = 1;
	
	/** 冻结 */
	int FROZEN = 2;
}
