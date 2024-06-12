package com.appManageHotel.controller.staff;

import java.io.IOException;
import java.time.LocalDate;

import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.BEAN.Bill;
import com.appManageHotel.model.BO.IFBookRoomBO;
import com.appManageHotel.model.DAO.BillDAOimpl;
import com.appManageHotel.model.DAO.IFBookRoomDAOimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/checkOut"})
public class checkOut extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DO POST /checkOut");
		String IDIFBookRoom = req.getParameter("IDIFBookRoom");
		LocalDate dateNow = LocalDate.now();
		System.out.println(IDIFBookRoom);
		
		Bill bill = BillDAOimpl.getInstance().selectByIDIFBookRoom(IDIFBookRoom);
		
		IFBookRoomBO.getInstance().CheckOut(IFBookRoomDAOimpl.getInstance().selectByID(IDIFBookRoom), dateNow);
		
		resp.sendRedirect(url.urlServer + "bill?IDBill=" + bill.getIDBill());
	}

}
