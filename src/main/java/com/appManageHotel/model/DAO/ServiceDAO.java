package com.appManageHotel.model.DAO;

import com.appManageHotel.model.BEAN.Service;

public interface ServiceDAO extends DAOInterface<Service> {
	
	public Service selectByName(String name);
	
	public Service selectByNameExceptID(String id, String name);
}
