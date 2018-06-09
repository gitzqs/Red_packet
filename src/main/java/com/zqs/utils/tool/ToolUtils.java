package com.zqs.utils.tool;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToolUtils {

	public List<String> formatConversion(String urlCookie) throws IOException {
		if(urlCookie == null){
			return null;
		}
		List<String> list = new ArrayList<String>();
		String cookie = "";
		String avatar = "";
		String elemeKey = "";
		cookie = URLDecoder.decode(urlCookie,"UTF-8");
		
		avatar = cookie;		//匹配Avatar
        String regAvatar = "\"avatar\":\"http://thirdqq.qlogo.cn/[a-z]+/[0-9]+/[0-9,A-Z]+";
        Pattern pAvatar = Pattern.compile(regAvatar);
        Matcher mAvatar = pAvatar.matcher(avatar);
        if(mAvatar.find()){
        	avatar = (mAvatar.group());
        }else{
        	return null;
        }
        avatar = avatar.substring(50, avatar.length());
        
        elemeKey = cookie;		//匹配elemeKey
        String regElemeKey = "\"eleme_key\":\"[0-9,a-z]+";
        Pattern pElemeKey = Pattern.compile(regElemeKey);
        Matcher mElemeKey = pElemeKey.matcher(elemeKey);
        if(mElemeKey.find()){
        	elemeKey = (mElemeKey.group());
        }else{
        	return null;
        }
        elemeKey = elemeKey.substring(13, elemeKey.length());
        list.add(avatar);
        list.add(elemeKey);
        System.out.println("avatar   = "+avatar);
        System.out.println("elemeKey = "+elemeKey);
		return list;
	}

}
