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

@WebServlet(urlPatterns = {"/general"})
public class general extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post");
		String typeRequest = request.getParameter("type");
		System.out.println(typeRequest);
		if(typeRequest.equals("signUp")) {
			System.out.println("signUp");
			
			// get data from request
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			// create ID
			UUID uuid = UUID.randomUUID();
			String IDAccount = uuid.toString();
			
			// Check username
			if(!AccountBO.getInstance().checkUserNameAccount(username)) {
				// account not exits 
				// insert new account
				AccountDAOImpl.getInstance().insert(new Account(IDAccount, username, password, "Customer"));
				
				Cookie cookieIDAccount = new Cookie("IDAccount", IDAccount);
				cookieIDAccount.setMaxAge(24 * 60 * 60); // Thời gian sống của cookie, tính bằng giây (ở đây là 1 ngày)
				response.addCookie(cookieIDAccount);
			} else {
				// account exits
				// show error
				System.out.println("Tai khoan da ton tai");
			}
		}
		
		if(typeRequest.equals("signIn")) {
			System.out.println("signIn");	
			
			// get data from request
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			 
			// check username, password
			if(AccountBO.getInstance().checkUserNamePassWordAccount(username, password)) {
				// success
				Account account = AccountDAOImpl.getInstance().selectByUserNameAndPassWord(username, password);
				System.out.println("Dang nhap thanh cong tk: " + account.getUserName());
				
				Cookie cookie = new Cookie("IDAccount", account.getIDAccount());
				cookie.setMaxAge(24 * 60 * 60); // Thời gian sống của cookie, tính bằng giây (ở đây là 1 ngày)
				
				response.addCookie(cookie);
			} else {
				// fail
			}
		}
		
		if(typeRequest.equals("signOut")) {
			System.out.println("signOut");
			
			Cookie cookie = new Cookie("IDAccount", "");
			cookie.setMaxAge(0); // Thời gian sống của cookie, tính bằng giây (ở đây là 1 ngày)
			
			response.addCookie(cookie);
		}
		response.sendRedirect(url.urlServer + "home");
	}
}