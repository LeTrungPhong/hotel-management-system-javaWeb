package com.appManageHotel.controller.user;

import java.io.IOException;
import java.util.ArrayList;

import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.BEAN.Bill;
import com.appManageHotel.model.BEAN.Customer;
import com.appManageHotel.model.BEAN.IFBookRoom;
import com.appManageHotel.model.BO.IFBookRoomBO;
import com.appManageHotel.model.DAO.BillDAOimpl;
import com.appManageHotel.model.DAO.CustomerDAOimpl;
import com.appManageHotel.model.DAO.IFBookRoomDAOimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/myBooking"})
public class myBooking extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DO GET /myBooking");
		
		HttpSession session = req.getSession();
		String IDAccount = session.getAttribute("IDAccount") != null ? (String)session.getAttribute("IDAccount") : "";
		Customer customer = !IDAccount.equals("") ? CustomerDAOimpl.getInstance().selectByIDAccount(IDAccount) : null;
		ArrayList<Bill> listBill = customer != null ? BillDAOimpl.getInstance().selectByIDCustomerComeInDateDESC(customer.getIDCustomer()) : null;
		req.setAttribute("listBill", listBill);
		
		RequestDispatcher rd1 = req.getRequestDispatcher("/views/user/myBooking/myBooking.jsp");
		rd1.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DO POST /myBooking");
		
		String IDIFBookRoom = req.getParameter("IDIFBookRoom");
		IFBookRoomBO.getInstance().cancelling(IFBookRoomDAOimpl.getInstance().selectByID(IDIFBookRoom));
		
		resp.sendRedirect(url.urlServer + "myBooking");
	}
}
