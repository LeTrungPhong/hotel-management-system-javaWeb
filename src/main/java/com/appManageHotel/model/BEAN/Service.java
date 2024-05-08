package com.appManageHotel.model.BEAN;

public class Service {
	private String IDService;
	private String ServiceName;
	private int Price;
	private String Description;
	private String IDImage;
	private int NumberUse;
	public Service(String IDService, String ServiceName, int Price, String Description, String IDImage, int NumberUse) {
		this.IDService = IDService;
		this.ServiceName = ServiceName;
		this.Price = Price;
		this.Description = Description;
		this.IDImage = IDImage;
		this.NumberUse = NumberUse;
	}
	public String getIDService() {
		return IDService;
	}
	public void setIDService(String ID) {
		this.IDService=ID;
	}
	public String GetServiceName() {
		return ServiceName;
	}
	public void setServiceName(String name) {
		this.ServiceName=name;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		this.Price=price;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getIDImage() {
		return IDImage;
	}
	public void setIDImage(String iDImage) {
		IDImage = iDImage;
	}
	public int getNumberUse() {
		return NumberUse;
	}
	public void setNumberUse(int numberUse) {
		NumberUse = numberUse;
	}
}
