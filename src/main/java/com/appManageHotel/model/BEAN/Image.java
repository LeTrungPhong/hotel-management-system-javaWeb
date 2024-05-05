package com.appManageHotel.model.BEAN;

public class Image {
	private String IDImage;
	private String ImageName;
	private String Path;
	
	public Image(String IDImage, String ImageName, String Path) {
		this.IDImage = IDImage;
		this.setImageName(ImageName);
		this.Path = Path;
	}
	public String getIDImage() {
		return IDImage;
	}
	public void setIDImage(String iDImage) {
		IDImage = iDImage;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String getImageName() {
		return ImageName;
	}
	public void setImageName(String imageName) {
		ImageName = imageName;
	}
}
