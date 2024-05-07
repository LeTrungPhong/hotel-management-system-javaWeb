package com.appManageHotel.controller.admin;

import java.io.IOException;
import java.util.UUID;

import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.BEAN.Image;
import com.appManageHotel.model.BO.ImageBO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/manageImage"})
public class manageImage extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DO GET /manageImage");
		RequestDispatcher rd1 = req.getRequestDispatcher("/views/admin/manageImage.jsp");
		rd1.forward(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DO PUT /manageImage");
		RequestDispatcher rd1 = req.getRequestDispatcher("/views/admin/manageImage.jsp");
		rd1.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Post in manageImage");
		String typeRequest = req.getParameter("type");
		if(typeRequest.equals("insertImage")) {
			System.out.println(typeRequest);
			
			String ImageName = req.getParameter("ImageName");
			String Path = req.getParameter("Path");
			
			UUID uuid = UUID.randomUUID();
			String IDImage = uuid.toString();
			if(ImageBO.getInstance().insertImage(new Image(IDImage,ImageName,Path))) {
				System.out.println("Insert thanh cong");
			} else {
				System.out.println("Insert khong thanh cong, ten hoac path da ton tai");
			}
		}
		
		if(typeRequest.equals("updateImage")) {
			System.out.println(typeRequest);
			
			String IDImage = req.getParameter("IDImage");
			String ImageName = req.getParameter("ImageName");
			String Path = req.getParameter("Path");
			
			if(ImageBO.getInstance().updateImage(new Image(IDImage, ImageName, Path))) {
				System.out.println("Update thanh cong");
			} else {
				System.out.println("Update khong thanh cong, ten hoac path da ton tai");
			}
		}
		resp.sendRedirect(url.urlServer + "manageImage");
	}
}
