package com.appManageHotel.controller.general;

import java.io.IOException;
import java.util.UUID;

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

@WebServlet(urlPatterns = {"/signUp"})
public class signUp extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DO POST /signUp");
		
		// get data from request
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// create ID
		UUID uuid = UUID.randomUUID();
		String IDAccount = uuid.toString();
		
		// Check username
		if(AccountDAOImpl.getInstance().selectByUserName(username) == null) {
			// account not exits 
			// insert new account
			AccountDAOImpl.getInstance().insert(new Account(IDAccount, username, password, "Customer"));
			
			HttpSession session = req.getSession();
			session.setAttribute("IDAccount", IDAccount);
			Cookie cookieIDAccount = new Cookie("IDSession", session.getId());
			cookieIDAccount.setMaxAge(2400 * 60 * 60); 
			resp.addCookie(cookieIDAccount);
		} else {
			// account exits
			// show error
			System.out.println("Tai khoan da ton tai");
		}
		resp.sendRedirect(url.urlServer + "home");
	}

}
