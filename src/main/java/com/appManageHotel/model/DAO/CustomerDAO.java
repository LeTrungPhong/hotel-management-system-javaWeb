package com.appManageHotel.model.DAO;

import com.appManageHotel.model.BEAN.Customer;

public interface CustomerDAO extends DAOInterface<Customer>{
	
	public Customer selectByIDAccount(String ID);
	
	public Customer selectByCCCD(String CCCD);
	
	public Customer selectByCCCDAndDifferentIDCard(String IDAccount, String CCCD);
}
