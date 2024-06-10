package com.appManageHotel.controller.staff;

import java.io.IOException;
import java.util.ArrayList;

import com.appManageHotel.model.BEAN.IFBookRoom;
import com.appManageHotel.model.DAO.IFBookRoomDAOimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/nonCheckInRoom"})
public class nonCheckInRoom extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<IFBookRoom> listIFBookRoomNonCheckIn = IFBookRoomDAOimpl.getInstance().selectByStateAndCheckIn(true, false);
		req.setAttribute("listIFBookRoomNonCheckIn", listIFBookRoomNonCheckIn);
		RequestDispatcher r1 = req.getRequestDispatcher("/views/staff/nonCheckInRoom/nonCheckInRoom.jsp");
		r1.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
