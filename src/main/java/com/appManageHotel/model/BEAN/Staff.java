package com.appManageHotel.model.BEAN;

public class Staff {
	private String IDStaff;
	private String FullName;
	private String CCCD;
	private String IDAccount;
	private Boolean State ;
	
	public Staff(String IDStaff, String FullName, String CCCD,String IDAccount,Boolean State) {
		this.IDStaff = IDStaff;
		this.FullName = FullName;
		this.CCCD = CCCD;
		this.IDAccount = IDAccount;
		this.State=State;
	}
	public String getIDStaff() {
		return IDStaff;
	}
	public void setIDStaff(String IDStaff) {
		this.IDStaff = IDStaff;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		this.FullName = fullName;
	}
	public String getCCCD() {
		return CCCD;
	}
	public void setCCCD(String cCCD) {
		this.CCCD = cCCD;
	}
	public String getIDAccount() {
		return IDAccount;
	}
	public void setIDAccount(String iDAccount) {
		this.IDAccount = iDAccount;
	}
	public Boolean getState() {
		return State;
	}
	public void setState(Boolean State) {
		this.State=State;
	}
}