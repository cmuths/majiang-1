/**
 * 包名：com.hejinwei.majiang.dal.impl
 * 文件名：SinaClientImpl.java
 * 版本信息：
 * 日期：2015年4月8日-上午9:20:17
 * 
 */
 
package com.hejinwei.majiang.dal.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hejinwei.majiang.dal.api.DemoClient;


@Service
public class DemoClientImpl implements DemoClient {
	public String hello(String name, String word) throws Exception{
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("name", name);
		paramMap.put("word", word);
//		String msg = HttpClientUtil.post("http://localhost:12306/mock/hello", paramMap);
		return null;
	}

}

