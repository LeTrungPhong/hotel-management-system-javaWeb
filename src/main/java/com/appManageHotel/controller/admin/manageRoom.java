package com.appManageHotel.controller.admin;

import java.io.IOException;
import java.util.UUID;

import com.appManageHotel.controller.cookie.cookie;
import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.BEAN.Room;
import com.appManageHotel.model.BO.RoomBO;
import com.appManageHotel.model.DAO.RoomDAOimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/manageRoom"})
public class manageRoom extends HttpServlet{
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DO GET /manageRoom");
		RequestDispatcher rd1 = req.getRequestDispatcher("/views/admin/manageRoom.jsp");
		rd1.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String typeRequest = req.getParameter("type");
		if(typeRequest.equals("insertRoom")) {
			System.out.println(typeRequest);
			
			String IDRoom = UUID.randomUUID().toString();
			Cookie cookieIDTypeRoom = cookie.findCookieByName(req, "IDTypeRoom");
			String RoomName = req.getParameter("RoomName");
			if(cookieIDTypeRoom == null) {
				System.out.println("Loai phong khong ton tai");
			} else {
				String IDTypeRoom = cookieIDTypeRoom.getValue();
				System.out.println(IDTypeRoom);
				if(RoomBO.getInstance().InsertRoom(new Room(IDRoom,IDTypeRoom,RoomName))) {
					System.out.println("Insert room thanh cong");
				} else {
					System.out.println("Insert room that bai, trung ten");
				}
			}
		}
		
		if(typeRequest.equals("updateRoom")) {
			System.out.println(typeRequest);
			
			String IDRoom = req.getParameter("IDRoom");
			String RoomName = req.getParameter("RoomName");
			
			if(RoomBO.getInstance().UpdateRoom(IDRoom, RoomName)) {
				System.out.println("Update room thanh cong");
			} else {
				System.out.println("Update room that bai, trung ten hoac error ...");
			}
		}
		
		resp.sendRedirect(url.urlServer + "manageRoom");
	}
}
