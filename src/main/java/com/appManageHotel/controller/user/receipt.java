package com.appManageHotel.controller.user;

import java.io.IOException;

import com.appManageHotel.model.BEAN.Bill;
import com.appManageHotel.model.BEAN.Customer;
import com.appManageHotel.model.BEAN.IFBookRoom;
import com.appManageHotel.model.BEAN.TypeRoom;
import com.appManageHotel.model.DAO.BillDAOimpl;
import com.appManageHotel.model.DAO.CustomerDAOimpl;
import com.appManageHotel.model.DAO.IFBookRoomDAOimpl;
import com.appManageHotel.model.DAO.RoomDAOimpl;
import com.appManageHotel.model.DAO.TypeRoomDAOimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/receipt"})
public class receipt extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String IDIFBookRoom = req.getParameter("IDIFBookRoom") != null ? req.getParameter("IDIFBookRoom").trim() : "";
		
		System.out.println(IDIFBookRoom);
		
		IFBookRoom ifBookRoom = !IDIFBookRoom.equals("") ? IFBookRoomDAOimpl.getInstance().selectByID(IDIFBookRoom) : null;
		Bill bill = ifBookRoom != null ? BillDAOimpl.getInstance().selectByIDIFBookRoom(ifBookRoom.getIDIFBookRoom()) : null;
		Customer customer = bill != null ? CustomerDAOimpl.getInstance().selectByID(bill.getIDCustomer()) : null;
		TypeRoom typeRoom = ifBookRoom != null ? TypeRoomDAOimpl.getInstance().selectByID(RoomDAOimpl.getInstance().selectByID(ifBookRoom.getIDRoom()).getIDTypeRoom()) : null;
		
		String FullName = customer != null ? customer.getFullName() : "";
		
		String SDT = customer != null ? customer.getSDT() : "";
		String Gender = customer != null ? customer.getGender() : "";
		String timeStart = ifBookRoom != null ? ifBookRoom.getComeInDate().toString() : "";
		String timeEnd = ifBookRoom != null ? ifBookRoom.getComeOutDate().toString() : "";
		String TypeRoomName = typeRoom != null ? typeRoom.getTypeRoomName() : "";
		int NumberAdult = ifBookRoom != null ? ifBookRoom.getNumberAdult() : 1;
		int NumberChild = ifBookRoom != null ? ifBookRoom.getNumberChild() : 0;
		int Price = typeRoom != null ? typeRoom.getPrice() : 0;
		int Prepayment = bill != null ? bill.getPrepayment() : 0;
		int total = bill != null ? bill.getTotal() : 0;
		int surchange = 0;
		
		if(NumberAdult - typeRoom.getMaxAdult() > 0) 
			surchange = surchange + (NumberAdult - typeRoom.getMaxAdult()) > 0 ? (NumberAdult - typeRoom.getMaxAdult()) * Price * 20 / 100 : 0;
		if(NumberChild - typeRoom.getMaxChild() > 0) 	
			surchange = surchange + (NumberChild - typeRoom.getMaxChild()) > 0 ? (NumberChild - typeRoom.getMaxChild()) * Price * 10 / 100 : 0;
		
		req.setAttribute("FullName", FullName);
		req.setAttribute("SDT", SDT);
		req.setAttribute("Gender", Gender);
		req.setAttribute("timeStart", timeStart);
		req.setAttribute("timeEnd", timeEnd);
		req.setAttribute("TypeRoomName", TypeRoomName);
		req.setAttribute("NumberAdult", NumberAdult);
		req.setAttribute("NumberChild", NumberChild);
		req.setAttribute("Price", Price);
		req.setAttribute("Prepayment", Prepayment);
		req.setAttribute("total", total);
		req.setAttribute("surchange", surchange);
		
		System.out.println("DO GET /receipt");
		RequestDispatcher r1 = req.getRequestDispatcher("/views/user/receipt/receipt.jsp");
		r1.forward(req, resp);
	}

}
