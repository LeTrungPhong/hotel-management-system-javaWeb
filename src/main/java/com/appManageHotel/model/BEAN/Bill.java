package com.appManageHotel.model.BEAN;

public class Bill {
	private String IDBill;
	private String IDStaff;
	private String IDCustomer;
	private int Prepayment;
	private int Total;
	private String IDIFBookRoom;
	public Bill(String idb,String ids,String idc,int p,int tt,String idi) {
		IDBill=idb;
		IDStaff=ids;
		IDCustomer=idc;
		Prepayment=p;
		Total=tt;
		IDIFBookRoom=idi;
	}
	public String getIDBill() {
		return IDBill;
	}
	public String getIDStaff() {
		return IDStaff;
	}
	public String getIDCustomer() {
		return IDCustomer;
	}
	public int getTotal() {
		return Total;
	}
	public String getIDIFBookRoom() {
		return IDIFBookRoom;
	}
	public void setIDBill(String id) {
		IDBill=id;
	}
	public void setIDStaff(String id) {
		IDStaff=id;
	}
	public void setIDCustomer(String id) {
		IDCustomer=id;
	}
	public void setTotal(int t) {
		Total=t;
	}
	public void setIDIFBookRoom(String id) {
		IDIFBookRoom=id;
	}
	public int getPrepayment() {
		return Prepayment;
	}
	public void setPrepayment(int p) {
		Prepayment=p;
	}
	
	
}

