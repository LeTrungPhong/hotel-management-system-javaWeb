package com.appManageHotel.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.BEAN.Service;
import com.appManageHotel.model.BO.ServiceBO;
import com.appManageHotel.model.DAO.ServiceDAOimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/manageService"})
public class manageService extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<Service> listService = ServiceDAOimpl.getInstance().selectAll();
		req.setAttribute("listService", listService);
		
		// TODO Auto-generated method stub
		System.out.println("DO GET /manageService");
		RequestDispatcher rd1 = req.getRequestDispatcher("/views/admin/manageService.jsp");
		rd1.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Post in manageService");
		String typeRequest = req.getParameter("type");
		
		if(typeRequest.equals("insertService")) {
			System.out.println(typeRequest);
			
			UUID uuid = UUID.randomUUID();
			String IDService = uuid.toString();
			
			String ServiceName = req.getParameter("ServiceName");
			int Price = Integer.parseInt(req.getParameter("Price"));
			String Description = req.getParameter("Description");
			String IDImage = req.getParameter("IDImage");
			
			if(ServiceBO.getInstance().insertService(new Service(IDService,ServiceName,Price,Description,IDImage,0))) {
				System.out.println("Insert service thanh cong");
			} else {
				System.out.println("Insert service that bai, trung ten service hoac error ...");
			}
		}
		
		if(typeRequest.equals("updateService")) {
			String IDService = req.getParameter("IDService");
			String ServiceName = req.getParameter("ServiceName");
			int Price = Integer.parseInt(req.getParameter("Price"));
			String Description = req.getParameter("Description");
			String IDImage = req.getParameter("IDImage");
			
			if(ServiceBO.getInstance().updateService(new Service(IDService, ServiceName, Price, Description, IDImage,0))) {
				System.out.println("Update service thanh cong");
			} else {
				System.out.println("Update service khong thanh cong, trung ten hoac error ...");
			}
		}
		
		resp.sendRedirect(url.urlServer + "manageService");
	}
}

