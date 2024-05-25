package com.appManageHotel.model.BO;

import com.appManageHotel.model.BEAN.Customer;
import com.appManageHotel.model.BEAN.Service;
import com.appManageHotel.model.BEAN.UseService;
import com.appManageHotel.model.DAO.CustomerDAOimpl;
import com.appManageHotel.model.DAO.ServiceDAOimpl;
import com.appManageHotel.model.DAO.UseServiceDAOimpl;

public class UseServiceBO {
	public static UseServiceBO getInstance() {
		return new UseServiceBO();
	}
	
	public void bookService(Customer customer, UseService useService) {
		
		Customer customerCheck = CustomerDAOimpl.getInstance().selectByCCCD(customer.getCCCD());
		Service service = ServiceDAOimpl.getInstance().selectByID(useService.getIDService());
		if(customerCheck != null) {
			useService.setIDCustomer(customerCheck.getIDCustomer());
		} else {
			CustomerDAOimpl.getInstance().insert(customer);
		}
		UseServiceDAOimpl.getInstance().insert(useService);
		int numberUse = service.getNumberUse();
		service.setNumberUse(numberUse + useService.getNumber());
		ServiceDAOimpl.getInstance().update(service);
	}
}
