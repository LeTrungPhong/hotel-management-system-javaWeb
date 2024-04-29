package com.appManageHotel.model.BEAN;

public class Room {
	private String IDRoom;
	private String IDTypeRoom;
	private String RoomName;
	private String Description;
	
	public Room(String IDRoom, String IDTypeRoom, String RoomName, String Description) {
		this.IDRoom = IDRoom;
		this.IDTypeRoom = IDTypeRoom;
		this.RoomName = RoomName;
		this.Description = Description;
	}
	
	public String getIDRoom() {
		return IDRoom;
	}
	public void setIDRoom(String iDRoom) {
		IDRoom = iDRoom;
	}
	public String getIDTypeRoom() {
		return IDTypeRoom;
	}
	public void setIDTypeRoom(String iDTypeRoom) {
		IDTypeRoom = iDTypeRoom;
	}
	public String getRoomName() {
		return RoomName;
	}
	public void setRoomName(String roomName) {
		RoomName = roomName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
}
