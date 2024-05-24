package com.appManageHotel.controller.filter;

import java.io.IOException;

import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.BEAN.Account;
import com.appManageHotel.model.BEAN.Customer;
import com.appManageHotel.model.DAO.AccountDAOImpl;
import com.appManageHotel.model.DAO.CustomerDAOimpl;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/bookRoom"})
public class authorizationCustomerFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = ((HttpServletRequest)request).getSession();
		String IDAccount = session.getAttribute("IDAccount") != null ? (String)session.getAttribute("IDAccount") : "";
		String show = "";
		if(!IDAccount.equals("")) {
			Account account = AccountDAOImpl.getInstance().selectByID(IDAccount);
			if(account != null) {
				Customer customer = CustomerDAOimpl.getInstance().selectByIDAccount(IDAccount);
				if(customer != null) {
					chain.doFilter(request, response);
				} else {
					show = "Ban can cap nhat thong tin ca nhan de tiep tuc";
					((HttpServletResponse)response).sendRedirect(url.urlServer + "updateInforUser?show=" + show);
				}
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
	}
}
