package com.appManageHotel.controller.general;

import java.io.IOException;

import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.BEAN.Account;
import com.appManageHotel.model.BO.AccountBO;
import com.appManageHotel.model.DAO.AccountDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/signIn"})
public class signIn extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DO POST /signIn");	
		
		// get data from request
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// check username, password
		String show = "";
		Account account = AccountDAOImpl.getInstance().selectByUserNameAndPassWord(username, password);
		if(account != null) {
			// success
			System.out.println("Dang nhap thanh cong tk: " + account.getUserName());

			HttpSession session = req.getSession();
			session.setAttribute("IDAccount", account.getIDAccount());
			Cookie cookie = new Cookie("IDSession", session.getId());
			cookie.setMaxAge(2400 * 60 * 60);	
			resp.addCookie(cookie);
			show = "Dang nhap thanh cong";
		} else {
			// fail
			show = "Dang nhap that bai, sai tai khoan hoac mat khau";
		}
		
		resp.sendRedirect(url.urlServer + "home?show=" + show);
	}
	
}
