package com.appManageHotel.model.BEAN;

public class TypeRoom {
	private String IDTypeRoom;
	private String TypeRoomName;
	private int Price;
	private int MaxPeople;
	private int NumberBook;
	
	public TypeRoom(String IDTypeRoom, String TypeRoomName, int Price, int MaxPeople, int NumberBook) {
		this.IDTypeRoom = IDTypeRoom;
		this.TypeRoomName = TypeRoomName;
		this.Price = Price;
		this.MaxPeople = MaxPeople;
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
	public int getMaxPeople() {
		return MaxPeople;
	}
	public void setMaxPeople(int maxPeople) {
		MaxPeople = maxPeople;
	}
	public int getNumberBook() {
		return NumberBook;
	}
	public void setNumberBook(int numberBook) {
		NumberBook = numberBook;
	}
}
