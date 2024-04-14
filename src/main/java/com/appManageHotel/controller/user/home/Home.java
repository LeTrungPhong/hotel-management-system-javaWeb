package com.appManageHotel.controller.user.home;

import java.io.IOException;

import com.appManageHotel.database.ConnectDatabase;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/"})
public class Home extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnectDatabase.getConnection();
		System.out.println("DO GET");
		RequestDispatcher rd1 = request.getRequestDispatcher("/views/user/home/home.jsp");
		rd1.forward(request, response);
	}
	
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}