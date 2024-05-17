package com.appManageHotel.model.BEAN;

import java.time.LocalDate;

public class IFBookRoom {
	private String IDIFBookRoom;
	private String IDRoom;
	private LocalDate ComeInDate;
	private LocalDate ComeOutDate;
	private int NumberAdult;
	private int NumberChild;
	private boolean State;
	private boolean CheckIn;
	
	public IFBookRoom(String id,String idr,LocalDate inn,LocalDate outt,int nA,int nC, boolean State,boolean check) {
		IDIFBookRoom=id;
		IDRoom=idr;
		ComeInDate=inn;
		ComeOutDate=outt;
		NumberAdult=nA;
		NumberChild=nC;
		this.State=State;
		this.CheckIn=check;
	}
	public String getIDIFBookRoom() {
		return IDIFBookRoom;
	}
	public void setIDIFBookRoom(String id) {
		IDIFBookRoom=id;
	}
	public String getIDRoom() {
		return IDRoom;
	}
	public void setIDRoom(String idr) {
		IDRoom=idr;
	}
	public LocalDate getComeInDate() {
		return ComeInDate;
	}
	public void setComeInDate(LocalDate Datee) {
		ComeInDate=Datee;
	}
	public LocalDate getComeOutDate() {
		return ComeOutDate;
	}
	public void setComeOutDate(LocalDate Datee) {
		ComeOutDate=Datee;
	}
	public int getNumberAdult() {
		return NumberAdult;
	}
	public void setNumberAdult(int nA) {
		NumberAdult=nA;
	}
	public int getNumberChild() {
		return NumberChild;
	}
	public void setNumberChild(int nC) {
		NumberChild=nC;
	}
	public boolean isState() {
		return State;
	}
	public void setState(boolean st) {
		State=st;
	}
	public boolean getCheckIn() {
		return CheckIn;
	}
	public void setCheckIn(boolean i) {
		CheckIn=i;
	}
}

