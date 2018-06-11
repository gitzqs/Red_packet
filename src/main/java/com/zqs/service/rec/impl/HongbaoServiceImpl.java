package com.zqs.service.rec.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.zqs.dao.cms.IUserMapper;
import com.zqs.dao.rec.AdvertisingDao;
import com.zqs.dao.rec.AltDao;
import com.zqs.dao.rec.RecordDao;
import com.zqs.model.cms.User;
import com.zqs.service.rec.AltService;
import com.zqs.service.rec.HongbaoService;

@Service("hongbaoService")
public class HongbaoServiceImpl implements HongbaoService {

	
	@Resource
    private AltService altService;
	@Resource
	private AltDao altDao;
	@Resource
	private RecordDao recordDao;
	@Resource
	private AdvertisingDao advertisingDao;
	@Resource
	private IUserMapper userMapper;
	
	int id;

	//领大红包方法
	@Override
	public  String getHongbao(String phoneNum,String url) throws IOException{
		Subject subject = SecurityUtils.getSubject();
		if(subject == null) {
			return "请重新登录";
		}
		User user = (User) subject.getPrincipal();
		if(user == null) {
			return"请重新登录";
		}
		int score = userMapper.loadScore(user.getId());
		if(score <= 3) {
			return "积分不足，请充值";
		}
		int errorUrlExponent = 0;	//错误链接指数，如果该指数等于三表明这是一个异常的链接
		int suspectedErrorId = 0;	//疑似错误Id
		int lastResidueNum = 16;	//上一次领取时的剩余次数,默认为16,因为红包最大个数为15
		Object[] residueNumAndMoney ={3,0};  //rt[0]为还需要领取的次数                  rt[1]为领取到的红包金额
		while((int) residueNumAndMoney[0]>0){		//进行第一次判断，如果剩余需要领取次数小于等于0则表示红包已被领取，返回失败提示，否则只要剩余需要领取次数大于0则一直运行，
			synchronized(this){id=altService.getNextId(id);		//领取前先id+1
				altService.addUseNumber(id);
				if(altService.getUseNum(id) >= 6){   //首先判断id是否合法，如果当前小号useNum>=5,表示所有小号已经耗尽
					insertRecord("0", phoneNum, 0,"后台次数耗尽");			//向数据库提交领取信息
					return "后台次数已被耗尽，明天再来吧";	
				}
				residueNumAndMoney = hongbao(url,altService.getAvatar(id),altService.getElemeKey(id),id,randomPhoneNum());     //调用领红包方法兵获取领红包方法返回的剩余领取次数与金额
				if((int)residueNumAndMoney[0] == lastResidueNum){		//判断剩余领取次数是否与上次相同，如果相同则领取错误次数+1
					altService.addErrorNumber(id);
					errorUrlExponent++;
				}else{
					errorUrlExponent = 0;
				}
				if(errorUrlExponent == 3){
					insertRecord("0", phoneNum, 0,"异常链接");
					return "异常链接，请再次尝试领取，如果第二次尝试仍然失败请不要再使用此链接";
				}
				lastResidueNum = (int)residueNumAndMoney[0];
			}	
	        if((int) residueNumAndMoney[0] == 1){		//如果剩余次数等于一，此时需要将小号的PhoneNum修改为目标手机号再领取		
	        	synchronized(this){ id=altService.getNextId(id);
					altService.addUseNumber(id);
		        	if(altService.getUseNum(id) >= 6){
						insertRecord("0", phoneNum, 0,"后台次数耗尽，下一个是大红包");
						return "后台次数已被耗尽，但你运气还蛮好的诶，下一个就是大红包，可以尝试手动领取或发给朋友领取哦~";
					}
		        	changePhoneNum(id,phoneNum);	//修改为目标手机号
		        	residueNumAndMoney = hongbao(url,altService.getAvatar(id),altService.getElemeKey(id),id,phoneNum);		//调用领红包方法兵获取领红包方法返回的剩余领取次数与金额
					changePhoneNum(id,randomPhoneNum());	//重要!将小号手机重新设置为随机手机号
	        	}
		        if((int) residueNumAndMoney[0] >= 1){		//手机已经领取过此红包 或 你的手机号今日领取次数已达上限或小号领取次数耗尽，下面进行第二次尝试。
		        	try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		        	synchronized(this){suspectedErrorId = id;
			        id=altService.getNextId(id);
						altService.addUseNumber(id);
						if(altService.getUseNum(id) >= 6){   //如果当前小号使用次数大于5,表示所有小号已经耗尽
							insertRecord("0", phoneNum, 0,"后台次数耗尽，下一个是大红包");			//向数据库提交领取信息
							return "后台次数已被耗尽，但你运气还蛮好的诶，下一个就是大红包，可以尝试手动领取或发给朋友领取哦~";	
						}
			        	changePhoneNum(id,phoneNum);	//修改为目标手机号
			        	residueNumAndMoney = hongbao(url,altService.getAvatar(id),altService.getElemeKey(id),id,phoneNum);		//调用领红包方法兵获取领红包方法返回的剩余领取次数与金额
						changePhoneNum(id,randomPhoneNum());	//重要!将小号手机重新设置为随机手机号		
		        	}
		        }
		        if((int) residueNumAndMoney[0] >= 1){	//第二次如果仍然领取失败
	        		insertRecord((String)residueNumAndMoney[1],phoneNum,0,"手机已领取过或手机上限");
		        	return("你的手机已经领取过此红包 或 你的手机号今日领取次数已达上限，亦或是系统错误，本红包下一个为大红包，可以发给你的朋友领哦~");
	        	}  	
		        if((int) residueNumAndMoney[0] == 0){		//至此，红包领取成功，返回成功信息
		        	if(suspectedErrorId != 0 ){		//如果疑似错误id不等于0说明上一次领取错误，将疑似错误Id的领取次数+1
		        		altService.addErrorNumber(suspectedErrorId);
		        	}
		        	insertRecord((String)residueNumAndMoney[1],phoneNum,1,"领取成功");
		        	System.out.println("get bigHongbao succeed!");
		        	Map<String,Object> pp = new HashMap<String,Object>();
		        	pp.put("userId", user.getId());
		        	pp.put("score", -4);
		        	userMapper.updateScore(pp);
					return ("红包领取成功,红包金额为："+(String)residueNumAndMoney[1]+"元");
		        }
		        if((int) residueNumAndMoney[0] < 0){		//发生了未知的问题，有可能是被被人抢领了，这种情况几率比较小但是还是有可能的，建议使用自己发的红包。
		        	insertRecord("0", phoneNum, 0,"未知的错误");
		        	System.out.println("unknow error!");
					return "发生了不可预见的错误";
		        }
	        }
	    }
		if((int) residueNumAndMoney[0] == -400){
			insertRecord("0", phoneNum, 0,"错误的链接");
        	System.out.println("malicious url!");
			return "错误的链接，请检查你的链接是否可用";
		}
		insertRecord("0", phoneNum, 0,"此红包大红包已被领取");
		System.out.println("not have bigHongbao!");
		return "此红包大红包已被领取!";
	}
	
	/*
	 * 领红包方法
	 * 如果红包领取异常,输出异常信息
	 * return Object[0]  还需要领取的次数
	 * return Object[1]  如果领取到大红包,返回红包金额 。如果不是大红包,返回0
	 */
	@Override
	public Object[] hongbao(String url,String avatar,String elemeKey,Integer id,String phoneNum) throws IOException{
		try (CloseableHttpClient httpClient = HttpClients.createDefault()){
			String sn = url;
			String regSn = "&sn=[0-9,a-z]+";
			Pattern pSn = Pattern.compile(regSn);
	        Matcher mSn = pSn.matcher(sn);
	        while(mSn.find()){
	        	sn=(mSn.group());
	        }
	        sn = sn.substring(4, sn.length());
			HttpPost httpPost = new HttpPost("https://h5.ele.me/restapi/marketing/promotion/weixin/"+avatar);		//提交请求
			httpPost.setEntity(new StringEntity("{\"group_sn\":\""+sn+"\",\"sign\":\""+elemeKey+"\","+
					"\"phone\":\""+phoneNum+"\","+
					"\"weixin_avatar\":\"http://thirdwx.qlogo.cn/mmopen/vi_32/QcicCZ211xlWicHg7YOemhvo4AkK8KhuZzCdgKpYf2zN8cHUQg3qw6UNq7zdLMz8AuAw6KHOfBibicuynQDbmq33OQ/132\","+
					"\"weixin_username\":\"599753879\"}"));	        //设置提交信息
	        //返回的信息responseHandler
	        ResponseHandler<String> responseHandler = response -> {
	            int status = response.getStatusLine().getStatusCode();
	            if (status >= 200 && status < 500) {
	                HttpEntity entity = response.getEntity();
	                return entity != null ? EntityUtils.toString(entity) : null;
	            } else {
	                throw new ClientProtocolException("Unexpected response status: " + status);
	            }
	        };
	        String responseBody = httpClient.execute(httpPost,responseHandler); 
	        
	        //识别已领取红包数量
	        int count = StringUtils.countMatches(responseBody,"\"sns_username\"");
	        
	        String luckyNum = getLuckyNum(url);	 //识别第几个为大红包
	        
	        //识别本次领取红包金额
	        String hongbaoSum = getHongbaoSum(responseBody);
	        
	        System.out.println(responseBody);
	        System.out.println(" targetNumber:"+Integer.parseInt(luckyNum));
	        System.out.println("    getNumber:"+count);
	        System.out.println("id="+id);
	        System.out.println("phoneNumber:"+phoneNum);
	        System.out.println("money:"+hongbaoSum);
            System.out.println("--------------------------------------------");
            Object[] rt = {Integer.parseInt(luckyNum) - count,hongbaoSum};
            Object[] rtFalse = {-400,0};   //防止恶意提交链接
            if(count == 0){
            	return rtFalse;
            }else{
            	return rt;
            }
		}
	}
	
	//修改手机号方法，如果成功则输出成功提示文字，如果失败则输出错误信息和失败提示文字。
	@Override
	public void changePhoneNum(Integer id,String phoneNum) throws IOException {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()){
			HttpPut httpPut = new HttpPut("https://h5.ele.me/restapi/v1/weixin/"+altService.getAvatar(id)+"/phone");	
			httpPut.setEntity(new StringEntity("{\"sign\":\""+altService.getElemeKey(id)+"\",\"phone\":\""+phoneNum+"\"}"));	
            altDao.changePhoneNum(id, phoneNum);
			System.out.println(phoneNum);
			System.out.println("id="+id);
			// Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
            };
            String responseBody = httpClient.execute(httpPut, responseHandler);
            if(responseBody==null){
            	System.out.println("Change phonenumber success!");
            }else{
            	System.out.println(responseBody);
            	System.out.println("Change phonenumbe failed!");
            }
            System.out.println("--------------------------------------------");
            return;
		} 
	}
	
	//生成随机手机号，生成类型为String
	@Override
	public String randomPhoneNum(){
		String rpn = "133"+(int)((Math.random()*90000000+9999999));
		return rpn;
	}
	
	
	//重置所有手机号
	public void retrunPhone() throws IOException{
		int traversalId = 0;
		int maxId = altDao.findMaxId();
		synchronized(this){
			while(true){
				traversalId = altDao.traversalId(traversalId);
				changePhoneNum(traversalId,randomPhoneNum());
				if(traversalId == maxId){
					return;
				}
			}
		}
	}
	
	
	//识别第几个为大红包,返回String
	public String getLuckyNum(String url){
		String luckyNum = url;
        String regLuckyNum = "lucky_number=[0-9]+";      //匹配lucky_number
        Pattern pLuckyNum = Pattern.compile(regLuckyNum);
        Matcher mLuckyNum = pLuckyNum.matcher(luckyNum);
        if(mLuckyNum.find()){
            luckyNum = mLuckyNum.group();
        }
        luckyNum = luckyNum.substring(13, luckyNum.length());	//substring()方法去除前13个字符，也就是"lucky_number="，剩下就是目标红包数
        return luckyNum;
	}
	
	
	//识别本次领取红包金额，如果不是大红包，返回0。如果是大红包，返回大红包金额
	public String getHongbaoSum(String responseBody){
		String hongbaoSum1 = responseBody;		//正则第一部分
        String regHongbaoSum1 = "\"amount\":[0-9,.]+,\"(expire_date|hongbao_variety\":\\[\"全品类\")";
        Pattern pHongbaoSum1 = Pattern.compile(regHongbaoSum1);
        Matcher mHongbaoSum1 = pHongbaoSum1.matcher(hongbaoSum1);
        if(mHongbaoSum1.find()){
        	hongbaoSum1 = (mHongbaoSum1.group());
        }else{
        	return "0";
        }
        
        String hongbaoSum2 = hongbaoSum1;		//正则第二部分
        String regHongbaoSum2 = "(?<!\\d|^)([1-9]\\d+|\\d)(\\.\\d+)?((?!\\d)|$)";
        Pattern pHongbaoSum2 = Pattern.compile(regHongbaoSum2);
        Matcher mHongbaoSum2 = pHongbaoSum2.matcher(hongbaoSum2);
        if(mHongbaoSum2.find()){
        	hongbaoSum2 = (mHongbaoSum2.group());
        }
        return hongbaoSum2;
	}
	
	//向数据库提交 "领取信息 "的方法
	public void insertRecord(String money,String phoneNum,int succeed,String remakes){
		Date time= new java.sql.Timestamp(new java.util.Date().getTime());
		int userId = 0;
		try {
			Subject subject = SecurityUtils.getSubject();
			User user = (User)subject.getPrincipal();
			userId = user.getId();
		}catch(Exception e) {
			e.printStackTrace();
		}
		recordDao.insertRecord(userId, money,phoneNum,succeed,time,remakes);
	}

	//获取广告数据
	@Override
	public String getAdvertising() {
		return advertisingDao.getAdvertising();
	}

	@Override
	public List<Map<String,Object>>  record() {
				
		Subject subject = SecurityUtils.getSubject();
		if(subject != null) {
			User user = (User)subject.getPrincipal();
			if(user != null) {
				List<Map<String,Object>> list = recordDao.pageLimit10(user.getId());
				return list;
			}
		}
		return null;
	}
}
