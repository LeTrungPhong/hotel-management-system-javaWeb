package com.appManageHotel.controller.staff;

import java.io.IOException;
import java.time.LocalDate;

import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.BO.IFBookRoomBO;
import com.appManageHotel.model.DAO.IFBookRoomDAOimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/extendRoom"})
public class extendRoom extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DO POST /extendRoom");
		
		String IDIFBookRoom = req.getParameter("IDIFBookRoomUpdate");
		String strComeOutDateUpdate = req.getParameter("ComeOutDateUpdate");
		
		System.out.println(IDIFBookRoom);
		System.out.println(strComeOutDateUpdate);
		
		LocalDate ComeOutDateUpdate = LocalDate.of(Integer.parseInt(strComeOutDateUpdate.substring(0, 4)),
												Integer.parseInt(strComeOutDateUpdate.substring(5, 7)),
												Integer.parseInt(strComeOutDateUpdate.substring(8, 10)));
		
		System.out.println(ComeOutDateUpdate);
		
		if(IFBookRoomBO.getInstance().Extend(IFBookRoomDAOimpl.getInstance().selectByID(IDIFBookRoom), ComeOutDateUpdate)) {
			System.out.println("Gia han thanh cong");
		} else {
			System.out.println("Gia han khong thanh cong, thoi gian khong hop le hoac tai thoi gian phong da duoc dat");
		}
		
		resp.sendRedirect(url.urlServer + "checkInRoom");
	}
	
}
