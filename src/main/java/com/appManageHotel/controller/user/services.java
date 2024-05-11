package com.appManageHotel.controller.user;

import java.io.IOException;
import java.util.ArrayList;

import com.appManageHotel.model.BEAN.Service;
import com.appManageHotel.model.DAO.ServiceDAOimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/services"})
public class services extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<Service> listService = ServiceDAOimpl.getInstance().selectAll();
		req.setAttribute("listService", listService);
		
		System.out.println("DO GET /services");
		RequestDispatcher r1 = req.getRequestDispatcher("/views/user/services/services.jsp");
		r1.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
