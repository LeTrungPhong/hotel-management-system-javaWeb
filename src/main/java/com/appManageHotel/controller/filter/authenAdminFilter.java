package com.appManageHotel.controller.filter;

import java.io.IOException;

import com.appManageHotel.controller.cookie.cookie;
import com.appManageHotel.model.DAO.AccountDAOImpl;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = {"/home-admin","/manageImage", "/manageRoom","/manageService","/manageStaff","/manageTypeRoom"})
public class authenAdminFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		Cookie cookieIDAccount = cookie.findCookieByName((HttpServletRequest)request, "IDAccount");
		if(cookieIDAccount != null) {
			if(AccountDAOImpl.getInstance().selectByID(cookieIDAccount.getValue()).getRole().equals("Admin")) {
				System.out.println("Authen admin filter");
				chain.doFilter(request, response);
			} else {
				System.out.println("Tai khoan khong duoc phan quyen Admin");
			}
		} else {
			System.out.println("Tai khoan chua duoc dang nhap");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}
}