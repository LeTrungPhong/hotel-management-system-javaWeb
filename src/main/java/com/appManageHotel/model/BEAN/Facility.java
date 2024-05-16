package com.appManageHotel.model.BEAN;

public class Facility {
	private String IDFacility;
	private String FacilityName;
	private String IDTypeRoom;
	private int Number;
	
	public Facility(String IDFacility, String FacilityName, String IDTypeRoom, int Number ) {
		this.IDFacility = IDFacility;
		this.FacilityName = FacilityName;
		this.IDTypeRoom = IDTypeRoom;
		this.Number = Number;
	}
	
	public String getIDFacility() { 
		return IDFacility;
	}
	public void setIDFacility(String iDFacility) {
		IDFacility = iDFacility;
	}
	public String getFacilityName() {
		return FacilityName;
	}
	public void setFacilityName(String facilityName) {
		FacilityName = facilityName;
	}
	public String getIDTypeRoom() {
		return IDTypeRoom;
	}
	public void setIDRoom(String iDRoom) {
		IDTypeRoom = iDRoom;
	}
	public int getNumber() {
		return Number;
	}
	public void setState(int Numberr) {
		Number = Numberr;
	}
}

