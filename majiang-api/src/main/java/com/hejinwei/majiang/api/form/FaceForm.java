package com.hejinwei.majiang.api.form;


public class FaceForm {
	
	private String userId;
	
	private String userName;
	
	private String flag;
	
	public FaceForm() {
		// TODO Auto-generated constructor stub
	}

	public FaceForm(String userId, String userName, String flag) {
		this.userId = userId;
		this.userName = userName;
		this.flag = flag;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	
}
