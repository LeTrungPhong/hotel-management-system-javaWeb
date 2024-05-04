package com.appManageHotel.model.BO;

import java.time.LocalDate;

import com.appManageHotel.model.BEAN.Customer;
import com.appManageHotel.model.DAO.CustomerDAOimpl;

import jakarta.servlet.http.Cookie;

public class CustomerBO {
	public static CustomerBO getInstance() {
		return new CustomerBO();
	}
	
	public String checkUpdateCustomer(String IDCustomer, String FullName, String CCCD, String Gender, String SDT, LocalDate Birth, Cookie cookieIDAccount) {
		if(FullName == null) return "FullNameisNull";
		if(CCCD == null) return "CCCDisNull";
		if(Gender == null) return "GenderisNull";
		if(SDT == null) return "SDTisNull";
		if(Birth == null) return "BirthisNull";
		if(cookieIDAccount == null) return "IDAccountisNull";
		if(CCCD.length() != 12) return "CCCDisNotForm";
		if(SDT.length() != 10) return "SDTisNotForm"; 
		
		String IDAccount = cookieIDAccount.getValue();
		Customer customer = CustomerDAOimpl.getInstance().selectByIDAccount(IDAccount);
		if(customer == null) {
			if(CustomerDAOimpl.getInstance().selectByCCCD(CCCD) == null) {
				CustomerDAOimpl.getInstance().insert(new Customer(IDCustomer,FullName,CCCD,Gender,SDT,Birth,IDAccount));
				return "InsertCompleteCustomer";
			} else {
				return "CCCDisExits";
			}
		} else {
			if(CustomerDAOimpl.getInstance().selectByCCCDAndDifferentIDCard(IDAccount, CCCD) == null) {
				CustomerDAOimpl.getInstance().update(new Customer(customer.getIDCustomer(),FullName,CCCD,Gender,SDT,Birth,IDAccount));
				return "UpdateCompleteCustomer";
			} else {
				return "CCCDisExits";
			}
		}
	}
	
}
