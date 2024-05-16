package com.appManageHotel.model.DAO;

import java.util.ArrayList;

import com.appManageHotel.model.BEAN.Bill;

public interface BillDAO extends DAOInterface<Bill>{
	public ArrayList<Bill> selectByIDCustomer(String id);
	
	public Bill selectByIDIFBookRoom(String idIFBookRoom);
	
	public ArrayList<Bill> selectByIDCustomerComeInDateDESC(String idCustomer);
}