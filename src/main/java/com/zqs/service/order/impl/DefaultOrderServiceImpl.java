package com.zqs.service.order.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.google.zxing.WriterException;
import com.zqs.dao.cms.IUserMapper;
import com.zqs.dao.order.IOrderMapper;
import com.zqs.model.base.ReturnObject;
import com.zqs.model.base.e.ReturnCode;
import com.zqs.model.cms.User;
import com.zqs.service.order.IOrderService;
import com.zqs.utils.alipay.AlipayConfig;
import com.zqs.utils.alipayf2f.AliF2fUtils;
import com.zqs.utils.json.JacksonUtils;
import com.zqs.utils.tool.QRCodeUtil;
import com.zqs.utils.tool.ToolUtils;
@Service("orderService")
public class DefaultOrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderMapper orderMapper;
	@Autowired
	private IUserMapper userMapper;
	
	@Override
	public List<Map<String, Object>> pageLimit10() {
		Subject subject = SecurityUtils.getSubject();
		if(subject != null) {
			User user = (User) subject.getPrincipal();
			if(user != null) {
				return orderMapper.loadLimit10(user.getId());
			}
		}
		return null;
	}

	@Override
	public String pay(double amount) {
		ReturnObject returnObject = new ReturnObject();
		String returnCode = ReturnCode.SUCCESS_CODE;
		String returnMsg = ReturnCode.SUCCESS_MSG;
		Subject subject = SecurityUtils.getSubject();
		if(subject != null) {
			User user = (User)subject.getPrincipal();
			if(user != null) {
				if(amount > 0) {
					String tradeNo = ToolUtils.randomOrderNo("HB");
					
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("out_trade_no",tradeNo);
					map.put("total_amount", amount);
					map.put("subject", "积分充值");
					String url = AliF2fUtils.alipay(JacksonUtils.object2json(map));
					try {
						if(QRCodeUtil.createQrCode(AlipayConfig.QR_PATH + tradeNo + ".jpg", url, 900,"JPEG")) {
							map.put("userId", user.getId());
							orderMapper.save(map);
							returnObject.setReturnData(AlipayConfig.QR_URL + tradeNo + ".jpg");
						}else {
							returnCode = ReturnCode.PROGRAM_ERROR_CODE;
							returnMsg = "重新提交!";
						}
					} catch (WriterException | IOException e) {
						e.printStackTrace();
					}
					
					
				}else {
					returnCode = ReturnCode.PROGRAM_ERROR_CODE;
					returnMsg = "充值金额不能为0";
				}				
			}
		}else {
			returnCode = ReturnCode.LOGIN_OVERTIME_CODE;
			returnMsg = ReturnCode.LOGIN_OVERTIME_MSG;
		}
		
		returnObject.setReturnCode(returnCode);
		returnObject.setReturnMsg(returnMsg);
		
		return JacksonUtils.object2json(returnObject);
	}

	@Override
	public String returnPay(String appId, String tradeNo) {
		// 返回结果
		String result = "fail";

		if (!StringUtils.isEmpty(appId)
				&& !StringUtils.isEmpty(tradeNo)) {
			// 验证签名是否正确
			try {
				String amount = orderMapper.loadAmount(tradeNo);
				if(!StringUtils.isEmpty(amount)) {
					//更新订单
					orderMapper.update(tradeNo);
					
					//获取用户id
					int userId = orderMapper.loadUserid(tradeNo);
					Map<String,Object> p = new HashMap<String,Object>();
					//更新积分
					p.put("userId", userId);
					p.put("score", Double.parseDouble(amount)*10);
					userMapper.updateScore(p);
					result = "success";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	

}
