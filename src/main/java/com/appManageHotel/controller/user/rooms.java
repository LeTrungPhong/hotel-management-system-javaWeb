package com.appManageHotel.controller.user;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import com.appManageHotel.model.BO.RoomBO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/rooms"})
public class rooms extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int MinPrice = req.getParameter("MinPrice") != null ? Integer.parseInt(req.getParameter("MinPrice")) : 0;
		int MaxPrice = req.getParameter("MaxPrice") != null ? Integer.parseInt(req.getParameter("MaxPrice")) : 0;
		int maxAdult = req.getParameter("maxAdult") != null ? Integer.parseInt(req.getParameter("maxAdult")) : 0;
		int maxChild = req.getParameter("maxChild") != null ? Integer.parseInt(req.getParameter("maxChild")) : 0;
		
		String strTimeStart = req.getParameter("timeStart");
		String strTimeEnd = req.getParameter("timeEnd");
		
		LocalDate timeStart = strTimeStart != null ? LocalDate.of(
				Integer.parseInt(strTimeStart.substring(6, 10)), 
				Integer.parseInt(strTimeStart.substring(0, 2)), 
				Integer.parseInt(strTimeStart.substring(3, 5))
				) 
					: null;
				
		LocalDate timeEnd = strTimeEnd != null ? LocalDate.of(
				Integer.parseInt(strTimeEnd.substring(6, 10)), 
				Integer.parseInt(strTimeEnd.substring(0, 2)), 
				Integer.parseInt(strTimeEnd.substring(3, 5))
				) : null;
		
		String[] listTypeRoomName = req.getParameterValues("TypeRoomName");
		
		if(timeStart != null && timeEnd != null) {
			System.out.println(MinPrice);
			System.out.println(MaxPrice);
			System.out.println(maxAdult);
			System.out.println(maxChild);
			System.out.println(timeStart.toString());
			System.out.println(timeEnd.toString());
			for(String item : listTypeRoomName) {
				System.out.println(item);
			}
		}
		
		if(listTypeRoomName != null) {
			ArrayList<String> list1 = RoomBO.getInstance().FindRoomByCondition(listTypeRoomName, MinPrice, MaxPrice, maxAdult, maxChild);
			if(list1 != null) {
				for(int i = 0; i < list1.size(); ++i) {
					System.out.println(list1.get(i));
				}
			}
		}
		
		System.out.println("DO GET /rooms");
		RequestDispatcher rd1 = req.getRequestDispatcher("/views/user/rooms/rooms.jsp");
		rd1.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
