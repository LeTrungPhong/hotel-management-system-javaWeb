package com.appManageHotel.controller.user;

import java.io.IOException;
import java.util.UUID;

import com.appManageHotel.model.BEAN.Account;
import com.appManageHotel.model.BO.AccountBO;
import com.appManageHotel.model.DAO.AccountDAOImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home"})
public class home extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DO GET /home");
		RequestDispatcher rd1 = request.getRequestDispatcher("/views/user/home/home.jsp");
		rd1.forward(request, response);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

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
			} else {
				// account exits
				// show error
				System.out.println("Tai khoan da ton tai");
			}
		}
		
		if(typeRequest.equals("signIn")) {
			
			// get data from request
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			// check username, password
			if(AccountBO.getInstance().checkUserNamePassWordAccount(username, password)) {
				// success
				Account account = AccountBO.getInstance().selectByUserNameAndPassWord(username, password);
				System.out.println("Dang nhap thanh cong tk: " + account.getUserName());
				
//				request.setAttribute("Account", account);
				
				Cookie cookie = new Cookie("IDAccount", account.getIDAccount());
				cookie.setMaxAge(24 * 60 * 60); // Thời gian sống của cookie, tính bằng giây (ở đây là 1 ngày)
				response.addCookie(cookie);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/home/home.jsp");
				dispatcher.forward(request, response);
			} else {
				// fail
				
			}
		}
	}
}