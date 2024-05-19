package com.appManageHotel.controller.staff;

import java.io.IOException;

import com.appManageHotel.controller.url.url;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/confirmCheckIn"})
public class confirmCheckIn extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DO POST /confirmCheckIn");
		
		resp.sendRedirect(url.urlServer + "selectRoom");
	}

}
