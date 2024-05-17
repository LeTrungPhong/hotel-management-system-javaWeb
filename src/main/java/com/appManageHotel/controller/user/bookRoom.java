package com.appManageHotel.controller.user;

import java.io.IOException;
import com.appManageHotel.controller.cookie.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.BEAN.Customer;
import com.appManageHotel.model.BEAN.IFBookRoom;
import com.appManageHotel.model.BEAN.TypeRoom;
import com.appManageHotel.model.BO.IFBookRoomBO;
import com.appManageHotel.model.DAO.CustomerDAOimpl;
import com.appManageHotel.model.DAO.IFBookRoomDAOimpl;
import com.appManageHotel.model.DAO.RoomDAOimpl;
import com.appManageHotel.model.DAO.TypeRoomDAOimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/bookRoom"})
public class bookRoom extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Customer customer = session.getAttribute("IDAccount") != null ? CustomerDAOimpl.getInstance().selectByIDAccount((String)session.getAttribute("IDAccount")) : null;
		req.setAttribute("Customer", customer);
		
		Cookie cookieIDTypeRoom = cookie.findCookieByName(req, "IDTypeRoom");
		if(cookieIDTypeRoom != null) {
			String IDTypeRoom = cookieIDTypeRoom.getValue();
			TypeRoom typeRoom = TypeRoomDAOimpl.getInstance().selectByID(IDTypeRoom);
			req.setAttribute("TypeRoom", typeRoom);
		}
		
		System.out.println("DO GET /bookRoom");
		RequestDispatcher r1 = req.getRequestDispatcher("/views/user/bookRoom/bookRoom.jsp");
		r1.forward(req, resp);
	}
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DO POST /bookRoom");
		
		HttpSession session = req.getSession();
		String IDAccount = session.getAttribute("IDAccount") != null ? (String)session.getAttribute("IDAccount") : "";
		
		String FullName = req.getParameter("FullName");
		String SDT = req.getParameter("SDT");
		String IDCustomer = UUID.randomUUID().toString();
		String IDTypeRoom = req.getParameter("IDTypeRoom"); 
		String IDIFBookRoom = UUID.randomUUID().toString();
		String strtimeStart = req.getParameter("ComeInDate");
		String strtimeEnd = req.getParameter("ComeOutDate");
		LocalDate timeStart = LocalDate.of(
				Integer.parseInt(strtimeStart.substring(0, 4)), 
				Integer.parseInt(strtimeStart.substring(5, 7)), 
				Integer.parseInt(strtimeStart.substring(8, 10)));
		LocalDate timeEnd = LocalDate.of(
				Integer.parseInt(strtimeEnd.substring(0, 4)), 
				Integer.parseInt(strtimeEnd.substring(5, 7)), 
				Integer.parseInt(strtimeEnd.substring(8, 10)));
		int NumberAdult = Integer.parseInt(req.getParameter("NumberAdult"));
		int NumberChild = Integer.parseInt(req.getParameter("NumberChild"));
		int total = Integer.parseInt(req.getParameter("payPrice"));
		int totalPrice = Integer.parseInt(req.getParameter("total-price"));
		int Price = Integer.parseInt(req.getParameter("Price"));
		String show = "";
		if(!IDAccount.equals("")) {
			Customer customer = CustomerDAOimpl.getInstance().selectByIDAccount(IDAccount);
			if(customer != null) {
				if(IFBookRoomBO.getInstance().bookRoomByAccount(new IFBookRoom(IDIFBookRoom, null, timeStart, timeEnd, NumberAdult, NumberChild,true,false), IDTypeRoom , customer, totalPrice,total)) {
					System.out.println("Dat phong thanh cong");
					show = "Dat phong thanh cong";
					resp.sendRedirect(url.urlServer + "bookRoom?show=" + show + "&IDIFBookRoom=" + IDIFBookRoom);
				} else {
					System.out.println("Da het loai phong nay");
					show = "Da het loai phong nay";
					resp.sendRedirect(url.urlServer + "rooms?show=" + show);
				}
			}
		} else {
			if(IFBookRoomBO.getInstance().bookRoom(new IFBookRoom(IDIFBookRoom, null, timeStart, timeEnd, NumberAdult, NumberChild,true,false), IDTypeRoom , new Customer(IDCustomer,FullName,null,null,SDT,null,null), totalPrice,total)) {
				System.out.println("Dat phong thanh cong");
				show = "Dat phong thanh cong";
				resp.sendRedirect(url.urlServer + "bookRoom?show=" + show + "&IDIFBookRoom=" + IDIFBookRoom);
			} else {
				System.out.println("Da het loai phong nay");
				show = "Da het loai phong nay";
				resp.sendRedirect(url.urlServer + "rooms?show=" + show);
			}
		}
	}
}