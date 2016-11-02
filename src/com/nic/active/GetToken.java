package com.nic.active;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Create by Nic on 2016/11/2 获取授权token请求
 */

public class GetToken {
	private static String hurl = "http://t1307.airag.cn/ae/oauth/token?";
	private static String c_id = "airag";
	private static String c_secret = "airag";
	private static String g_type = "password";
	private static String name = "username";
	private static String pwd = "password";

	public static StringBuffer gettoken() throws Exception {

		// 请求URL
		String turl = hurl + "client_id=" + c_id + "&client_secret=" + c_secret + "&grant_type=" + g_type + "&username="
				+ name + "&password=" + pwd;

		// 建立连接
		URL url = new URL(turl);
		HttpURLConnection ht = (HttpURLConnection) url.openConnection();

		// 设置请求方式
		ht.setRequestMethod("POST");

		// 取得输入流
		InputStream is = ht.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		// 读取响应内容
		StringBuffer sb = new StringBuffer();
		String str = null;
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		br.close();
		is.close();

		// 释放资源
		isr.close();
		ht.disconnect();
		// System.out.println(sb);
		return sb;
	}

}