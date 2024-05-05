package com.appManageHotel.model.BEAN;

public class ImageTypeRoom {
	private String IDImage;
	private String IDTypeRoom;
	
	public ImageTypeRoom(String IDImage, String IDTypeRoom) {
		this.setIDImage(IDImage);
		this.setIDTypeRoom(IDTypeRoom);
	}
	public String getIDImage() {
		return IDImage;
	}
	public void setIDImage(String iDImage) {
		IDImage = iDImage;
	}
	public String getIDTypeRoom() {
		return IDTypeRoom;
	}
	public void setIDTypeRoom(String iDTypeRoom) {
		IDTypeRoom = iDTypeRoom;
	}
}