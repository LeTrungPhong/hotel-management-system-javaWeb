package com.appManageHotel.controller.filter;

import java.io.IOException;

import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.DAO.AccountDAOImpl;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/changePassWord","/updateInforUser"})
public class authenticationAccountFilter implements Filter{																																																			

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = ((HttpServletRequest)request).getSession();
		String IDAccount = session.getAttribute("IDAccount") != null ? (String)session.getAttribute("IDAccount") : "";
		String show = "";
		if(!IDAccount.equals("")) {
			if(AccountDAOImpl.getInstance().selectByID(IDAccount) != null) {
				System.out.println("Xac nhan tai khoan thanh cong");
				chain.doFilter(request, response);
			} else {
				System.out.println("Can dang nhap de tiep tuc");
				show = "Can dang nhap de tiep tuc";
				((HttpServletResponse)response).sendRedirect(url.urlServer + "home?show=" + show);
			}
		} else {
			System.out.println("Tai khoan chua duoc dang nhap");
			show = "Tai khoan chua duoc dang nhap";
			((HttpServletResponse)response).sendRedirect(url.urlServer + "home?show=" + show);
		}
	}
}
