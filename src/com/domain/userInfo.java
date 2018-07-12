package com.domain;
import java.io.Serializable;
public class userInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7061361687231013586L;
	private Integer userId;
	private String password;

	public userInfo() {
		
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
