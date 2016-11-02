package com.nic.active;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Create by Nic on 2016/11/2 查询农眼实时图片（携带token）：
 */

public class Graph extends GetAccesstoken {
	private static String hurl = "http://t1307.airag.cn/ae/spec/pic?";
	private static String x = "23.17392985000000";
	private static String y = "113.40527330000000";

	public static StringBuffer getph() throws Exception {

		// 获取access_token
		String str = getaccessoken();

		String turl = hurl + "access_token=" + str + "&gps_x=" + x + "&gps_y=" + y;

		URL url = new URL(turl);
		HttpURLConnection ht = (HttpURLConnection) url.openConnection();
		ht.setRequestMethod("GET");

		InputStream is = ht.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		StringBuffer sb = new StringBuffer();
		String str1 = null;
		while ((str1 = br.readLine()) != null) {
			sb.append(str1);
		}
		br.close();
		is.close();

		isr.close();
		ht.disconnect();
		return sb;
		// System.out.println(turl);
		// System.out.println(sb);
	}
}
