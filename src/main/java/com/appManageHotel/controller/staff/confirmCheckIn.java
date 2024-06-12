package com.appManageHotel.controller.staff;

import java.io.IOException;
import java.time.LocalDate;

import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.BEAN.Customer;
import com.appManageHotel.model.BO.IFBookRoomBO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/confirmCheckIn"})
public class confirmCheckIn extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DO POST /confirmCheckIn");
		
		String IDCustomer = req.getParameter("IDCustomer");
		String CCCD = req.getParameter("CCCD");
		String FullName = req.getParameter("FullName");
		String SDT = req.getParameter("SDT");
		String strBirth = req.getParameter("Birth");
		LocalDate Birth = LocalDate.of(Integer.parseInt(strBirth.substring(0, 4)),
										Integer.parseInt(strBirth.substring(5, 7)), 
										Integer.parseInt(strBirth.substring(8, 10)));
		String Gender = req.getParameter("Gender");
		String IDIFBookRoom = req.getParameter("IDIFBookRoomCheckIn");
		
		System.out.println(IDCustomer);
		System.out.println(CCCD);
		System.out.println(FullName);
		System.out.println(SDT);
		System.out.println(Birth.toString());
		System.out.println(Gender);
		System.out.println(IDIFBookRoom);
		String show = "";
		if(IFBookRoomBO.getInstance().confirmCheckIn(new Customer(IDCustomer, FullName, CCCD, Gender, SDT, Birth, null), IDIFBookRoom)) {
			System.out.println("Check in thanh cong");
			show = "Check in thanh cong";
		} else {
			System.out.println("Check in that bai");
			show = "Check in that bai";
		}
		
		resp.sendRedirect(url.urlServer + "selectRoom?show=" + show);
	}

}
