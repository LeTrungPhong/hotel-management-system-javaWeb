package com.appManageHotel.controller.user;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import com.appManageHotel.model.BEAN.TypeRoom;
import com.appManageHotel.model.BO.RoomBO;
import com.appManageHotel.model.DAO.TypeRoomDAOimpl;

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
		
		String strMinPrice = req.getParameter("MinPrice");
		String strMaxPrice = req.getParameter("MaxPrice");
		String strmaxAdult = req.getParameter("maxAdult"); 
		String strmaxChild = req.getParameter("maxChild");
		String strtimeStart = req.getParameter("timeStart");
		String strtimeEnd = req.getParameter("timeEnd");
		
		int MinPrice = strMinPrice != null ? Integer.parseInt(strMinPrice.substring(1).replace(",", "")) : 0;
		int MaxPrice = strMaxPrice != null ? Integer.parseInt(strMaxPrice.substring(1).replace(",", "")) : 0;
		int maxAdult = strmaxAdult != null ? Integer.parseInt(strmaxAdult) : 0;
		int maxChild = strmaxChild != null ? Integer.parseInt(strmaxChild) : 0;
		
		LocalDate timeStart = strtimeStart == null || strtimeStart.equals("") ? null : LocalDate.of(
				Integer.parseInt(strtimeStart.substring(6, 10)), 
				Integer.parseInt(strtimeStart.substring(0, 2)), 
				Integer.parseInt(strtimeStart.substring(3, 5))
					);
		
		LocalDate timeEnd = strtimeEnd == null || strtimeEnd.equals("") ? null : LocalDate.of(
				Integer.parseInt(strtimeEnd.substring(6, 10)), 
				Integer.parseInt(strtimeEnd.substring(0, 2)), 
				Integer.parseInt(strtimeEnd.substring(3, 5))
					);
		
		String[] listTypeRoomName = req.getParameterValues("TypeRoomName") != null ? req.getParameterValues("TypeRoomName") : null;
		
		ArrayList<TypeRoom> listFindRoom = RoomBO.getInstance().findRoom(MinPrice, MaxPrice, maxAdult, maxChild, timeStart, timeEnd, listTypeRoomName);
		
		ArrayList<TypeRoom> typeRoomMaxPrice = TypeRoomDAOimpl.getInstance().selectTypeRoomMaxPrice(1);
		ArrayList<TypeRoom> typeRoomMinPrice = TypeRoomDAOimpl.getInstance().selectTypeRoomMinPrice(1);
		
		req.setAttribute("listTypeRoom", listFindRoom);
		req.setAttribute("MaxPrice", typeRoomMaxPrice != null ? typeRoomMaxPrice.get(0).getPrice() : 0); 
		req.setAttribute("MinPrice", typeRoomMinPrice != null ? typeRoomMinPrice.get(0).getPrice() : 0);
		
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
