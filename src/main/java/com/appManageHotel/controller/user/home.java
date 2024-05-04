package com.appManageHotel.controller.user;

import java.io.IOException;
import java.util.UUID;

import com.appManageHotel.controller.url.url;
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}