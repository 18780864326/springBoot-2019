package com.example.demo.m1.dto;

public class UserDto {
	private Number  id;
	private String userName;
	private String password;

	public Number getId() {
		return id;
	}
	public void setId(Number id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
	
}
