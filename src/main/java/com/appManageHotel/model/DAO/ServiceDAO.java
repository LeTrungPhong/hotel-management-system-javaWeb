package com.appManageHotel.model.DAO;

import java.util.ArrayList;

import com.appManageHotel.model.BEAN.Service;

public interface ServiceDAO extends DAOInterface<Service> {
	
	public Service selectByName(String name);
	
	public Service selectByNameExceptID(String id, String name);
	
	public ArrayList<Service> selectServiceMaxUsed(int number);
}
