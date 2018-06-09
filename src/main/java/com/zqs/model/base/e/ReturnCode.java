package com.zqs.model.base.e;
/**
 * 返回编码
 * 
 * @author qiushi.zhou  
 * @date 2017年3月3日 下午2:20:57
 */
public interface ReturnCode {
	
	/*  ----------- 通用 ----------------- */
	/** 操作成功 */
	String SUCCESS_CODE = "0000"; 
	String SUCCESS_MSG = "操作成功!";
	
	/** 参数不完整 */
	String PARAMS_MISS_CODE = "1000";
	String PARAMS_MISS_MSG = "参数不完整!";
	
	/** 参数为空 */
	String PARAMS_NULL_CODE = "1001";
	String PARAMS_NULL_MSG = "参数为空!";
	
	/** 程序错误 */
	String PROGRAM_ERROR_CODE = "9999";
	String PROGRAM_ERROR_MSG = "程序发生错误!";
	
	/** 登录失效 */
	String LOGIN_OVERTIME_CODE = "8888";
	String LOGIN_OVERTIME_MSG = "登录失效，请重新登录";
	
	
	/*  ----------- 用户相关 ----------------- */
	/** 用户名不存在 */
	String USER_NOT_EXISTS_CODE = "2001";
	String USER_NOT_EXISTS_MSG = "用户名不存在！";
	
	/** 用户未生效 */
	String USER_UNACTIVE_CODE = "2002";
	String USER_UNACTIVE_MSG = "用户未生效!";
	
	/** 用户已冻结 */
	String USER_FROZEN_CODE = "2003";
	String USER_FROZEN_MSG = "用户已冻结";
	
	/** 登录密码错误 */
	String USER_LOGIN_PWD_ERROR_CODE = "2004";
	String USER_LOGIN_PWD_ERROR_MSG = "登录密码错误";
	
	/** 验证码不对 */
	String VERIFY_CODE_ERROR_CODE = "2005";
	String VERIFY_CODE_ERROR_MSG = "验证码不对!";
	
	/** 用户名已存在 */
	String USER_EXISTS_CODE = "2006";
	String USER_EXISTS_MSG = "用户名已存在！";

}
