package com.hejinwei.majiang.dal.impl;

import org.springframework.stereotype.Service;

import com.hejinwei.majiang.dal.api.FaceClient;
import com.hejinwei.majiang.dal.bo.Obj;
import com.hejinwei.majiang.dal.util.FaceUtil;

@Service
public class FaceClientImpl implements FaceClient {
	
	public String getSerial(String userName, String userId, String imagePath,String flag) throws Exception {
		//首先通过传递过来的XML构建对象
		Obj obj = new Obj(userName,userId,imagePath);
		String condition = FaceUtil.ObjToXML(obj, imagePath, flag);
		//请求数据源
		String result = FaceUtil.executeClient("NciicServices", condition);
		return result;
	}
}
