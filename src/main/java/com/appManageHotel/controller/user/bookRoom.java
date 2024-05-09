package com.appManageHotel.controller.user;

import java.io.IOException;

import com.appManageHotel.controller.url.url;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/bookRoom"})
public class bookRoom extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DO GET /bookRoom");
		RequestDispatcher r1 = req.getRequestDispatcher("/views/user/bookRoom/bookRoom.jsp");
		r1.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(url.urlServer + "bookRoom");
	}
}
