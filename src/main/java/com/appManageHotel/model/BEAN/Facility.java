package com.appManageHotel.model.BEAN;

public class Facility {
	private String IDFacility;
	private String FacilityName;
	private String IDRoom;
	private boolean State;
	
	public Facility(String IDFacility, String FacilityName, String IDRoom, boolean State) {
		this.IDFacility = IDFacility;
		this.FacilityName = FacilityName;
		this.IDRoom = IDRoom;
		this.State = State;
	}
	
	public Facility(String IDFacility, String FacilityName, boolean State) {
		this.IDFacility = IDFacility;
		this.FacilityName = FacilityName;
		this.IDRoom = null;
		this.State = State;
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
	public String getIDRoom() {
		return IDRoom;
	}
	public void setIDRoom(String iDRoom) {
		IDRoom = iDRoom;
	}
	public boolean isState() {
		return State;
	}
	public void setState(boolean state) {
		State = state;
	}
}
