package com.lfy.bean;

public class User {
	private String userName;
	private String pwd;
	private String tel;
	private String email;
	@Override
	public String toString() {
		return "User [userName=" + userName + ", pwd=" + pwd + ", tel=" + tel
				+ ", email=" + email + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getpwd() {
		return pwd;
	}
	public void setpwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
