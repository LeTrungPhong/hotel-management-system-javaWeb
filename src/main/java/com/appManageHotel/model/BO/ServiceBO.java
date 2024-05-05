package com.appManageHotel.model.BO;

import com.appManageHotel.model.BEAN.Service;
import com.appManageHotel.model.DAO.ServiceDAOimpl;

public class ServiceBO {
	public static ServiceBO getInstance() {
		return new ServiceBO();
	}
	
	public boolean insertService(Service t) {
		if(ServiceDAOimpl.getInstance().selectByName(t.GetServiceName()) == null) {
			ServiceDAOimpl.getInstance().insert(t);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean updateService(Service t) {
		if(ServiceDAOimpl.getInstance().selectByNameExceptID(t.getIDService(),t.GetServiceName()) == null) {
			ServiceDAOimpl.getInstance().update(t);
			return true;
		} else {
			return false;
		}
	}
}
