package com.lxm.demo.beans;

public class User {
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + "]";
	}
	
	
}
