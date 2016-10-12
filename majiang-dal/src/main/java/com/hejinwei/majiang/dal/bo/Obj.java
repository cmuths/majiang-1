package com.hejinwei.majiang.dal.bo;

public class Obj {

	private String userName;
	private String userId;
	private String userPhoto;

	public Obj() {

	}

	public Obj(String userName, String userId, String userPhoto) {
		this.userName = userName;
		this.userId = userId;
		this.userPhoto = userPhoto;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

}
