package com.appManageHotel.model.BEAN;

import java.time.LocalDate;

public class IFBookRoom {
	private String IDIFBookRoom;
	private String IDRoom;
	private LocalDate ComeInDate;
	private LocalDate ComeOutDate;
	private int NumberAdult;
	private int NumberChild;
	
	public IFBookRoom(String id,String idr,LocalDate inn,LocalDate outt,int nA,int nC) {
		IDIFBookRoom=id;
		IDRoom=idr;
		ComeInDate=inn;
		ComeOutDate=outt;
		NumberAdult=nA;
		NumberChild=nC;
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
}

