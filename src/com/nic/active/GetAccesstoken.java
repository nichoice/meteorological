package com.nic.active;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Create by Nic on 2016/11/2
 * 获取access_token
 */

public class GetAccesstoken extends GetToken {
	public static String getaccessoken() throws Exception{
		//获取Http post body
		StringBuffer str = gettoken();
		String s = str.toString();
		JSONObject jo = JSON.parseObject(s);
		//截取access_token
		String access_token = jo.getString("access_token");
		return access_token;
	}
}
