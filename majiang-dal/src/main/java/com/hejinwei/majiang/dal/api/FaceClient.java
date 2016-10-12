package com.hejinwei.majiang.dal.api;

public interface FaceClient {

	String getSerial(String userName, String userId, String imagePath,
			String flag) throws Exception;

}
