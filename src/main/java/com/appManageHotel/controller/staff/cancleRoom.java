package com.appManageHotel.controller.staff;

import java.io.IOException;

import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.BO.IFBookRoomBO;
import com.appManageHotel.model.DAO.IFBookRoomDAOimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/cancleRoom"})
public class cancleRoom extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DO POST /cancleRoom");
		String IDIFBookRoom = req.getParameter("IDIFBookRoom");
		IFBookRoomBO.getInstance().cancelling(IFBookRoomDAOimpl.getInstance().selectByID(IDIFBookRoom));
		
		resp.sendRedirect(url.urlServer + "selectRoom");
	}
}
