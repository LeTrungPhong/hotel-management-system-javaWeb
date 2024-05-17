package com.appManageHotel.controller.filter;

import java.io.IOException;

import com.appManageHotel.model.DAO.AccountDAOImpl;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter
public class authorizationCustomerFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = ((HttpServletRequest)request).getSession();
		String IDAccount = session.getAttribute("IDAccount") != null ? (String)session.getAttribute("IDAccount") : "";
		
		if(!IDAccount.equals("")) {
			if(AccountDAOImpl.getInstance().selectByID(IDAccount).getRole().equals("Admin")) {
				System.out.println("Authen admin filter");
				chain.doFilter(request, response);
			} else {
				System.out.println("Tai khoan khong duoc phan quyen Admin");
			}
		} else {
			System.out.println("Tai khoan chua duoc dang nhap");
		}
		chain.doFilter(request, response);
	}

}
