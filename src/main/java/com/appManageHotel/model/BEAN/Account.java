package com.appManageHotel.model.BEAN;

public class Account {
	private String IDAccount;
	private String UserName;
	private String PassWord;
	private String Role;
	
	public Account(String IDAccount, String UserName, String PassWord, String Role) {
		this.IDAccount = IDAccount;
		this.UserName = UserName;
		this.PassWord = PassWord;
		this.Role = Role;
	}
	public String getIDAccount() {
		return IDAccount;
	}

	public void setIDAccount(String iDAccount) {
		IDAccount = iDAccount;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
}
