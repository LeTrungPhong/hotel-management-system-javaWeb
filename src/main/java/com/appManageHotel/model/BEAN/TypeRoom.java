package com.appManageHotel.model.BEAN;

public class TypeRoom {
	private String IDTypeRoom;
	private String TypeRoomName;
	private int Price;
	private int MaxAdult;
	private int MaxChild;
	private int NumberBook;
	
	public TypeRoom(String IDTypeRoom, String TypeRoomName, int Price, int MaxAdult, int MaxChild, int NumberBook) {
		this.IDTypeRoom = IDTypeRoom;
		this.TypeRoomName = TypeRoomName;
		this.Price = Price;
		this.MaxAdult = MaxAdult;
		this.MaxChild = MaxChild;
		this.NumberBook = NumberBook;
	}
	
	public String getIDTypeRoom() {
		return IDTypeRoom;
	}
	public void setIDTypeRoom(String iDTypeRoom) {
		IDTypeRoom = iDTypeRoom;
	}
	public String getTypeRoomName() {
		return TypeRoomName;
	}
	public void setTypeRoomName(String typeRoomName) {
		TypeRoomName = typeRoomName;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getNumberBook() {
		return NumberBook;
	}
	public void setNumberBook(int numberBook) {
		NumberBook = numberBook;
	}

	public int getMaxAdult() {
		return MaxAdult;
	}

	public void setMaxAdult(int maxAdult) {
		MaxAdult = maxAdult;
	}

	public int getMaxChild() {
		return MaxChild;
	}

	public void setMaxChild(int maxChild) {
		MaxChild = maxChild;
	}
}
