package com.appManageHotel.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.BEAN.Facility;
import com.appManageHotel.model.BEAN.Room;
import com.appManageHotel.model.BEAN.TypeRoom;
import com.appManageHotel.model.BO.RoomBO;
import com.appManageHotel.model.DAO.FacilityDAOimpl;
import com.appManageHotel.model.DAO.TypeRoomDAOimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/manageFacility")
public class manageFacility extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String IDTypeRoom = req.getParameter("IDTypeRoom");
		TypeRoom typeRoom = IDTypeRoom != null ? TypeRoomDAOimpl.getInstance().selectByID(IDTypeRoom) : null;
		ArrayList<Facility> listFacility = IDTypeRoom != null ? FacilityDAOimpl.getInstance().selectByIDTypeRoom(IDTypeRoom) : null;
		
		req.setAttribute("TypeRoom",typeRoom);
		req.setAttribute("listFacility", listFacility);
		
		System.out.println("DO GET /manageFacility");
		RequestDispatcher rd1 = req.getRequestDispatcher("/views/admin/manageFacility.jsp");
		rd1.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POST IN /manageFacility");
		String typeRequest = req.getParameter("type");
		String show = "";
		if(typeRequest.equals("insertFacility")) {
			String FacilityName = req.getParameter("FacilityName");
			String IDTypeRoom = req.getParameter("IDTypeRoom");
			
			if(IDTypeRoom == null) {
				System.out.println("Loai phong khong ton tai");
				show = "Loai phong khong ton tai";
			} else {
				FacilityDAOimpl.getInstance().insert(new Facility(UUID.randomUUID().toString(),FacilityName,IDTypeRoom,1));
				System.out.println("Them co so vat chat " + FacilityName + " thanh cong");
				show = "Them co so vat chat " + FacilityName + " thanh cong";
			}
		}
		
		if(typeRequest.equals("deleteFacility")) {
			String IDFacility = req.getParameter("IDFacility");
			
			if(IDFacility == null) {
				System.out.println("Co so vat chat khong ton tai");
				show = "Co so vat chat khong ton tai";
			} else {
				FacilityDAOimpl.getInstance().delete(IDFacility);
				System.out.println("Xoa co so vat chat thanh cong");
				show = "Xoa co so vat chat thanh cong";
			}
		}
		
		resp.sendRedirect(url.urlServer + "manageFacility?IDTypeRoom=" + req.getParameter("IDTypeRoom") + "&show=" + show);
	}

}
