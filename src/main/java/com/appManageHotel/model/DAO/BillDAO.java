package com.appManageHotel.model.DAO;

import java.util.ArrayList;

import com.appManageHotel.model.BEAN.Bill;

public interface BillDAO extends DAOInterface<Bill>{
	public ArrayList<Bill> selectByIDCustomer(String id);
}