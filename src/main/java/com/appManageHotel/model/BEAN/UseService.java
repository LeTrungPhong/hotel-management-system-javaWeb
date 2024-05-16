package com.appManageHotel.model.BEAN;

import java.time.LocalDate;

public class UseService {
	private String IDUseService;
	private String IDService;
	private LocalDate UseDate;
	private String IDCustomer;
	private int Number;
	private boolean State;
	private int Total;
	public UseService(String idUseService, String idService, LocalDate useDate, String idCustomer, int number, boolean state, int Total) {
		this.IDUseService = idUseService;
		this.IDService = idService;
		this.UseDate = useDate;
		this.IDCustomer = idCustomer;
		this.Number = number;
		this.State = state;
		this.Total = Total;
	}
	public String getIDUseService() {
		return IDUseService;
	}
	public void setIDUseService(String iDUseService) {
		IDUseService = iDUseService;
	}
	public String getIDService() {
		return IDService;
	}
	public void setIDService(String iDService) {
		IDService = iDService;
	}
	public LocalDate getUseDate() {
		return UseDate;
	}
	public void setUseDate(LocalDate useDate) {
		UseDate = useDate;
	}
	public String getIDCustomer() {
		return IDCustomer;
	}
	public void setIDCustomer(String iDCustomer) {
		IDCustomer = iDCustomer;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public boolean isState() {
		return State;
	}
	public void setState(boolean state) {
		State = state;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}
	
}
