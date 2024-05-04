package com.appManageHotel.controller.user;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.appManageHotel.controller.cookie.*;
import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.BO.CustomerBO;
import com.appManageHotel.model.DAO.AccountDAOImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/updateInforUser"})
public class updateInforUser extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DO GET /updateInforUser");
		RequestDispatcher rd1 = req.getRequestDispatcher("/views/user/updateInforUser/updateInforUser.jsp");
		rd1.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String requestType = req.getParameter("type");
		 
		 if(requestType.equals("updateInforUser")) {
			 String CCCD = req.getParameter("CCCD");
			 String FullName = req.getParameter("FullName");
			 String SDT = req.getParameter("SDT");
			 String Gender = req.getParameter("Gender");
			 String strBirth = req.getParameter("Birth");
			 
			 int Year = Integer.parseInt(strBirth.substring(0, 4));
			 int Month = Integer.parseInt(strBirth.substring(5, 7));
			 int Day = Integer.parseInt(strBirth.substring(8,10));
			 LocalDate Birth = LocalDate.of(Year, Month, Day);
			 Cookie cookieIDAccount = com.appManageHotel.controller.cookie.cookie.findCookieByName(req, "IDAccount");
			 
			 if(cookieIDAccount != null) {
				 if(AccountDAOImpl.getInstance().selectByID(cookieIDAccount.getValue()) != null) {
					 UUID uuid = UUID.randomUUID();
					 String IDCustomer = uuid.toString();
					 String notification = CustomerBO.getInstance().checkUpdateCustomer(IDCustomer, FullName, CCCD, Gender, SDT, Birth, cookieIDAccount);
					 
					 System.out.println(notification);
					 resp.sendRedirect(url.urlServer + "updateInforUser");
				 }
			 }
		 }
	}

}
