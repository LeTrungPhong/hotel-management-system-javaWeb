package com.appManageHotel.controller.staff;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

import com.appManageHotel.controller.url.url;
import com.appManageHotel.model.BEAN.Account;
import com.appManageHotel.model.BEAN.Customer;
import com.appManageHotel.model.BEAN.IFBookRoom;
import com.appManageHotel.model.BEAN.Staff;
import com.appManageHotel.model.BO.IFBookRoomBO;
import com.appManageHotel.model.DAO.AccountDAOImpl;
import com.appManageHotel.model.DAO.StaffDAOimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/bookRoomStaff"})
public class bookRoomStaff extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DO POST /bookRoomStaff"); 
	
		String CCCD = req.getParameter("CCCD");
		String FullName = req.getParameter("FullName");
		String Gender = req.getParameter("Gender");
		String SDT = req.getParameter("SDT");
		String strBirth = req.getParameter("Birth");
		
		LocalDate Birth = LocalDate.of(
				Integer.parseInt(strBirth.substring(0, 4)),
				Integer.parseInt(strBirth.substring(5, 7)), 
				Integer.parseInt(strBirth.substring(8, 10)));
		
		String IDIFBookRoom = UUID.randomUUID().toString();
		String IDRoom = req.getParameter("IDRoom");
		int NumberAdult = Integer.parseInt(req.getParameter("NumberAdult"));
		int NumberChild = Integer.parseInt(req.getParameter("NumberChild"));
		String strComeInDate = req.getParameter("ComeInDate");
		String strComeOutDate = req.getParameter("ComeOutDate");
		
		LocalDate ComeInDate = LocalDate.of(
				Integer.parseInt(strComeInDate.substring(0, 4)), 
				Integer.parseInt(strComeInDate.substring(5, 7)), 
				Integer.parseInt(strComeInDate.substring(8, 10)));
		
		LocalDate ComeOutDate = LocalDate.of(
				Integer.parseInt(strComeOutDate.substring(0, 4)), 
				Integer.parseInt(strComeOutDate.substring(5, 7)), 
				Integer.parseInt(strComeOutDate.substring(8, 10)));
		
		int Prepayment = 0;
		int Total = Integer.parseInt(req.getParameter("Total"));
		
//		System.out.println(CCCD);
//		System.out.println(FullName);
//		System.out.println(Gender);
//		System.out.println(SDT);
//		System.out.println(Birth.toString());
//		System.out.println(IDRoom);
//		System.out.println(NumberAdult);
//		System.out.println(NumberChild);
//		System.out.println(ComeInDate);
//		System.out.println(ComeOutDate);
//		System.out.println(Total);
		
		HttpSession session = req.getSession();
		String IDAccount = session.getAttribute("IDAccount") != null ? (String)session.getAttribute("IDAccount") : "";
		
		Account account = !IDAccount.equals("") ? AccountDAOImpl.getInstance().selectByID(IDAccount) : null;
		if(account != null) {
			if(account.getRole().equals("Staff")) {
				Staff staff = account != null ? StaffDAOimpl.getInstance().selectByIDAccount(account.getIDAccount()) : null;
				if(staff != null) {
					if(IFBookRoomBO.getInstance().bookRoomStaff(new IFBookRoom(IDIFBookRoom, IDRoom, ComeInDate, ComeOutDate, NumberAdult, NumberChild, true, true, LocalDate.now(), null, LocalDate.now()), new Customer(UUID.randomUUID().toString(),FullName,CCCD,Gender,SDT,Birth,null), staff.getIDStaff(), Prepayment, Total)) {
						System.out.println("Dat phong thanh cong.");
					} else {
						System.out.println("Dat phong that bai");
					}
				} else {
					System.out.println("Nhan vien khong ton tai");
				}
			} else {
				System.out.println("Tai khoan khong phai la nhan vien");
			}
		} else {
			System.out.println("Tai khoan khong ton tai");
		}
		
		resp.sendRedirect(url.urlServer + "selectRoom");
	}	
}
