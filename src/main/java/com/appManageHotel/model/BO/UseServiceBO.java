package com.appManageHotel.model.BO;

import com.appManageHotel.model.BEAN.Customer;
import com.appManageHotel.model.BEAN.UseService;
import com.appManageHotel.model.DAO.CustomerDAOimpl;
import com.appManageHotel.model.DAO.UseServiceDAOimpl;

public class UseServiceBO {
	public static UseServiceBO getInstance() {
		return new UseServiceBO();
	}
	
	public void bookService(Customer customer, UseService useService) {
		
		Customer customerCheck = CustomerDAOimpl.getInstance().selectByCCCD(customer.getCCCD());
		if(customerCheck != null) {
			useService.setIDCustomer(customerCheck.getIDCustomer());
			UseServiceDAOimpl.getInstance().insert(useService);
		} else {
			CustomerDAOimpl.getInstance().insert(customer);
			UseServiceDAOimpl.getInstance().insert(useService);
		}
	}
}
