package com.appManageHotel.model.BEAN;

public class Room {
	private String IDRoom;
	private String IDTypeRoom;
	private String RoomName;
	
	public Room(String IDRoom, String IDTypeRoom, String RoomName) {
		this.IDRoom = IDRoom;
		this.IDTypeRoom = IDTypeRoom;
		this.RoomName = RoomName;
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
}
