package com.appManageHotel.controller.user;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.BEAN.Customer;
import com.appManageHotel.model.BEAN.Service;
import com.appManageHotel.model.BEAN.UseService;
import com.appManageHotel.model.BO.UseServiceBO;
import com.appManageHotel.model.DAO.ServiceDAOimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/services"})
public class services extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<Service> listService = ServiceDAOimpl.getInstance().selectAll();
		req.setAttribute("listService", listService);
		
		System.out.println("DO GET /services");
		RequestDispatcher r1 = req.getRequestDispatcher("/views/user/services/services.jsp");
		r1.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DO POST /service");
		
		String IDCustomer = UUID.randomUUID().toString();
		String CCCD = req.getParameter("CCCD");
		String FullName = req.getParameter("FullName");
		String SDT = req.getParameter("SDT");
		String IDUseService = UUID.randomUUID().toString();
		String IDService = req.getParameter("IDService");
		int Number = Integer.parseInt(req.getParameter("Number"));
		String dateStr = req.getParameter("UseDate");
		int Total = Integer.parseInt(req.getParameter("Total"));
		LocalDate UseDate = LocalDate.of(
				Integer.parseInt(dateStr.substring(0, 4)), 
				Integer.parseInt(dateStr.substring(5, 7)), 
				Integer.parseInt(dateStr.substring(8, 10)));
		
		String birthStr = req.getParameter("Birth");
		String Gender = req.getParameter("Gender");
		LocalDate Birth = LocalDate.of(
				Integer.parseInt(birthStr.substring(0, 4)), 
				Integer.parseInt(birthStr.substring(5, 7)), 
				Integer.parseInt(birthStr.substring(8, 10)));
				
		
//		System.out.println(CCCD);
//		System.out.println(FullName);
//		System.out.println(SDT);
//		System.out.println(IDService);
//		System.out.println(Number);
//		System.out.println(UseDate.toString());
//		System.out.println(Total);
//		System.out.println(Gender);
//		System.out.println(Birth);
		
		UseServiceBO.getInstance().bookService(
				new Customer(IDCustomer, FullName, CCCD, Gender, SDT, Birth, null),
				new UseService(IDUseService, IDService, UseDate, IDCustomer, Number, true, Total)
		);
		
		String show = "";
		show = "Dat dich vu thanh cong";
		
		resp.sendRedirect(url.urlServer + "services?show=" + show);
	}
	
}
