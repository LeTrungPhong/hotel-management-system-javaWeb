package com.appManageHotel.controller.user;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import com.appManageHotel.model.BEAN.TypeRoom;
import com.appManageHotel.model.BO.RoomBO;
import com.appManageHotel.model.BO.TypeRoomBO;
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
		
		System.out.println("DO GET /rooms");
		
		String strMinPrice = req.getParameter("MinPrice");
		String strMaxPrice = req.getParameter("MaxPrice");
		String strmaxAdult = req.getParameter("maxAdult"); 
		String strmaxChild = req.getParameter("maxChild");
		String strtimeStart = req.getParameter("timeStart");
		String strtimeEnd = req.getParameter("timeEnd");
		
		req.setAttribute("maxAdult", strmaxAdult);
		req.setAttribute("maxChild", strmaxChild);
		req.setAttribute("timeStart", strtimeStart);
		req.setAttribute("timeEnd", strtimeEnd);
		
		
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
		
		System.out.println();
		
		String[] s = listTypeRoomName;
		if(s != null) {
			for(int i = 0; i < s.length; i++){
				System.out.print(s[i] + "\n");
			}
		}
		System.out.println();
		System.out.println();
		
		
		ArrayList<TypeRoom> typeRoomMaxPrice = TypeRoomDAOimpl.getInstance().selectTypeRoomMaxPrice(1);
		ArrayList<TypeRoom> typeRoomMinPrice = TypeRoomDAOimpl.getInstance().selectTypeRoomMinPrice(1);
		
		int maxP = typeRoomMaxPrice != null ? typeRoomMaxPrice.get(0).getPrice() : 0;
		int minP = typeRoomMinPrice != null ? typeRoomMinPrice.get(0).getPrice() : 0;
		
		int MinPrice = strMinPrice != null ? Integer.parseInt(strMinPrice.substring(1).replace(",", "")) : minP;
		int MaxPrice = strMaxPrice != null ? Integer.parseInt(strMaxPrice.substring(1).replace(",", "")) : maxP;
		
		req.setAttribute("minPrice", MinPrice);
		req.setAttribute("maxPrice", MaxPrice);
		
		ArrayList<TypeRoom> listFindRoom = TypeRoomBO.getInstance().findTypeRoom(MinPrice, MaxPrice, maxAdult, maxChild, timeStart, timeEnd, listTypeRoomName);
		
		req.setAttribute("listTypeRoom", listFindRoom);
		req.setAttribute("listTypeRoomName", listTypeRoomName);
		req.setAttribute("MaxPrice", maxP); 
		req.setAttribute("MinPrice", minP);
		
		RequestDispatcher rd1 = req.getRequestDispatcher("/views/user/rooms/rooms.jsp");
		rd1.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
