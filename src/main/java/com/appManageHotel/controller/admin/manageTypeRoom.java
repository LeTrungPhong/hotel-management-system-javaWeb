package com.appManageHotel.controller.admin;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.BEAN.TypeRoom;
import com.appManageHotel.model.BO.TypeRoomBO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/manageTypeRoom"})
public class manageTypeRoom extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DO GET /manageTypeRoom");
		RequestDispatcher rd1 = req.getRequestDispatcher("/views/admin/manageTypeRoom.jsp");
		rd1.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String typeRequest = req.getParameter("type");
		System.out.println("Post in manageTypeRoom");                                                                                                                                                      
		if(typeRequest.equals("insertTypeRoom")) {
			System.out.println(typeRequest);
			
			UUID uuid = UUID.randomUUID();
			String IDTypeRoom = uuid.toString();
			String TypeRoomName = req.getParameter("TypeRoomName");
			int Price = Integer.parseInt(req.getParameter("Price"));
			int MaxAdult = Integer.parseInt(req.getParameter("MaxAdult"));
			int MaxChild = Integer.parseInt(req.getParameter("MaxChild"));
			int NumberBook = 0;
			String Description = req.getParameter("Description");
			
			String[] roomImages = req.getParameterValues("roomImages");
			HashSet<String> uniqueSet = new HashSet<>(Arrays.asList(roomImages));
			String[] listIDImage = uniqueSet.toArray(new String[uniqueSet.size()]);
			
			if(TypeRoomBO.getInstance().insertTypeRoom(new TypeRoom(IDTypeRoom, TypeRoomName, Price, MaxAdult, MaxChild, NumberBook, Description), listIDImage)) {
				System.out.println("Insert type room thanh cong");
			} else {
				System.out.println("Insert type room that bai, trung ten hoac error...");
			}
		}
		
		if(typeRequest.equals("updateTypeRoom")) {
			System.out.println(typeRequest);
			
			String IDTypeRoom = req.getParameter("IDTypeRoom");
			String TypeRoomName = req.getParameter("TypeRoomName");
			int Price = Integer.parseInt(req.getParameter("Price"));
			int MaxAdult = Integer.parseInt(req.getParameter("MaxAdult"));
			int MaxChild = Integer.parseInt(req.getParameter("MaxChild"));
			String Description = req.getParameter("Description");
			
			String[] roomImages = req.getParameterValues("roomImages");
			HashSet<String> uniqueSet = new HashSet<>(Arrays.asList(roomImages));
			String[] listIDImage = uniqueSet.toArray(new String[uniqueSet.size()]);
			
			if(TypeRoomBO.getInstance().updateTypeRoom(new TypeRoom(IDTypeRoom, TypeRoomName, Price, MaxAdult, MaxAdult, MaxChild, Description), listIDImage)) {
				System.out.println("Update type room thanh cong");
			} else {
				System.out.println("Update type room that bai, trung ten hoac error,...");
			}
		}
		
		resp.sendRedirect(url.urlServer + "manageTypeRoom");
	}
}