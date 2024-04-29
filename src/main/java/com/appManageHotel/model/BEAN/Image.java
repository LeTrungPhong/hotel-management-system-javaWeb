package com.appManageHotel.model.BEAN;

public class Image {
	private String IDImage;
	private String IDRoom;
	private String Path;
	
	public Image(String IDImage, String Path) {
		this.IDImage = IDImage;
		this.IDRoom = null;
		this.Path = Path;
	}
	public Image(String IDImage, String IDRoom, String Path) {
		this.IDImage = IDImage;
		this.IDRoom = IDRoom;
		this.Path = Path;
	}
	public String getIDImage() {
		return IDImage;
	}
	public void setIDImage(String iDImage) {
		IDImage = iDImage;
	}
	public String getIDRoom() {
		return IDRoom;
	}
	public void setIDRoom(String iDRoom) {
		IDRoom = iDRoom;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
}
