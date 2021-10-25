package com.library.dannet.pojo;

public class Login {
	
	private String aadharid;
	private String password;
	public String getAadharid() {
		return aadharid;
	}
	public void setAadharid(String aadharid) {
		this.aadharid = aadharid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [aadharid=" + aadharid + ", password=" + password + "]";
	}

}
