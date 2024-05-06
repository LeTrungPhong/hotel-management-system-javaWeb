package com.appManageHotel.controller.admin;

import java.io.IOException;
import java.util.UUID;

import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.BEAN.Account;
import com.appManageHotel.model.BEAN.Staff;
import com.appManageHotel.model.BO.StaffBO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/manageStaff"})
public class manageStaff extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DO GET /manageStaff");
		RequestDispatcher rd1 = req.getRequestDispatcher("/views/admin/manageStaff.jsp");
		rd1.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String typeRequest = req.getParameter("type");
		if(typeRequest.equals("insertStaff")) {
			System.out.println(typeRequest);
			
			UUID uuid = UUID.randomUUID();
			String IDStaff = uuid.toString();
			String FullName = req.getParameter("FullName");
			String CCCD = req.getParameter("CCCD");
			boolean State = true;
			String IDAccount = UUID.randomUUID().toString();
			String UserName = req.getParameter("UserName");
			String PassWord = req.getParameter("PassWord");
			String Role = "Staff";
			
			if(StaffBO.getInstance().insertStaff(new Staff(IDStaff,FullName,CCCD,IDAccount,State), new Account(IDAccount,UserName,PassWord,Role))){
				System.out.println("Insert staff thanh cong");
			} else {
				System.out.println("Insert staff that bai, trung ten hoac trung cccd hoac error ...");
			}
		}
		
		if(typeRequest.equals("updateStaff")) {
			System.out.println(typeRequest);
			String IDStaff = req.getParameter("IDStaff");
			String FullName = req.getParameter("FullName");
			String CCCD = req.getParameter("CCCD");
			String IDAccount = req.getParameter("IDAccount");
			boolean State = Boolean.parseBoolean(req.getParameter("State"));
			
//			System.out.println(IDStaff);
//			System.out.println(FullName);
//			System.out.println(CCCD);
//			System.out.println(IDAccount);
//			System.out.println(State);
			
			if(StaffBO.getInstance().UpdateStaff(IDStaff, FullName, CCCD)) {
				System.out.println("Update thanh cong");
			} else {
				System.out.println("Update that bai, trung cccd hoac error ...");
			}
		}
		
		if(typeRequest.equals("layOffStaff")) {
			System.out.println(typeRequest);
			
			String IDStaff = req.getParameter("IDStaff");
			System.out.println(IDStaff);
			StaffBO.getInstance().Layoff(IDStaff);
			System.out.println("Dinh chi staff thanh cong");
		}
		resp.sendRedirect(url.urlServer + "manageStaff");
	}
}
