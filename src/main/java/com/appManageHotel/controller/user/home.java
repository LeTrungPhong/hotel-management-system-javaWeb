package com.appManageHotel.controller.user;

import java.io.IOException;
import java.util.ArrayList;

import com.appManageHotel.model.BEAN.Service;
import com.appManageHotel.model.BEAN.TypeRoom;
import com.appManageHotel.model.DAO.ServiceDAOimpl;
import com.appManageHotel.model.DAO.TypeRoomDAOimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home"})
public class home extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<TypeRoom> listTypeRoomMaxBooked = TypeRoomDAOimpl.getInstance().selectTypeRoomMaxBooked(3);
		ArrayList<Service> listServiceMaxUsed = ServiceDAOimpl.getInstance().selectServiceMaxUsed(3);
		
		request.setAttribute("listTypeRoomMaxBooked", listTypeRoomMaxBooked);
		request.setAttribute("listServiceMaxUsed", listServiceMaxUsed);
		
		System.out.println("DO GET /home");
		RequestDispatcher rd1 = request.getRequestDispatcher("/views/user/home/home.jsp");
		rd1.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}