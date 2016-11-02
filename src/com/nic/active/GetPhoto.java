package com.nic.active;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Create by Nic on 2016/11/2 下载查询农眼图片
 */

public class GetPhoto extends Graph {
	public static void main(String[] args) throws Exception {
		// 获取请求农眼的返回值 并转成String
		StringBuffer stringBuffer = getph();
		String string = stringBuffer.toString();

		// 截取返回值的 obj部份
		JSONObject jsonObject = JSON.parseObject(string);
		String obj = jsonObject.getString("obj");

		// 截取图片的下载路径
		JSONObject js = JSON.parseObject(obj);
		String p = js.getString("picture");

		// System.out.println(p);

		// 下载图片到D盘
		String res = downloadFromUrl(p, "d:/");
		System.out.println(res);
	}

	// 下载图片方法
	public static String downloadFromUrl(String url, String dir) {

		try {
			URL httpurl = new URL(url);
			String fileName = getFileNameFromUrl(url);
			System.out.println(fileName);
			File f = new File(dir + fileName);
			FileUtils.copyURLToFile(httpurl, f);
		} catch (Exception e) {
			e.printStackTrace();
			return "Fault!";
		}
		return "Successful!";
	}

	public static String getFileNameFromUrl(String url) {
		String name = new Long(System.currentTimeMillis()).toString() + ".X";
		int index = url.lastIndexOf("/");
		if (index > 0) {
			name = url.substring(index + 1);
			if (name.trim().length() > 0) {
				return name;
			}
		}
		return name;
	}
}
