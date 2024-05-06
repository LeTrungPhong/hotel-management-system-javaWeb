package com.appManageHotel.model.DAO;

import com.appManageHotel.model.BEAN.Staff;

public interface StaffDAO extends DAOInterface<Staff>{
	
	public Staff selectByCCCD(String cccd);
	
	public Staff selectByCCCDExceptID(String IDStaff, String CCCD);
	
}
