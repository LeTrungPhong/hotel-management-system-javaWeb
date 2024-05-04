package com.appManageHotel.model.BEAN;

import java.time.LocalDate;

public class Customer {
	private String IDCustomer;
	private String FullName;
	private String CCCD;
	private String Gender;
	private String SDT;
	private LocalDate Birth;
	private String IDAccount;
	
	public Customer(String IDCustomer, String FullName, String CCCD, String Gender, String SDT, LocalDate Birth, String IDAccount) {
		this.IDCustomer = IDCustomer;
		this.FullName = FullName;
		this.CCCD = CCCD;
		this.Gender = Gender;
		this.SDT = SDT;
		this.Birth = Birth;
		this.IDAccount = IDAccount;
	}
	
	public String getIDCustomer() {
		return IDCustomer;
	}
	public void setIDCustomer(String iDCustomer) {
		IDCustomer = iDCustomer;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getCCCD() {
		return CCCD;
	}
	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public LocalDate getBirth() {
		return Birth;
	}
	public void setBirth(LocalDate birth) {
		Birth = birth;
	}

	public String getIDAccount() {
		return IDAccount;
	}

	public void setIDAccount(String iDAccount) {
		IDAccount = iDAccount;
	}
	
	
}
