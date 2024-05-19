package com.appManageHotel.controller.filter;

import java.io.IOException;

import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.DAO.AccountDAOImpl;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/selectRoom","/confirmCheckIn","/cancleRoom","/bookRoomStaff"})
public class authonrizationStaffFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = ((HttpServletRequest)request).getSession();
		String IDAccount = session.getAttribute("IDAccount") != null ? (String)session.getAttribute("IDAccount") : "";
		
		if(!IDAccount.equals("")) {
			if(AccountDAOImpl.getInstance().selectByID(IDAccount).getRole().equals("Staff")) {
				System.out.println("Authen staff filter");
				chain.doFilter(request, response);
			} else {
				System.out.println("Tai khoan khong duoc phan quyen staff");
				((HttpServletResponse)response).sendRedirect(url.urlServer + "home");
			}
		} else {
			System.out.println("Tai khoan chua duoc dang nhap");
			((HttpServletResponse)response).sendRedirect(url.urlServer + "home");
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
