package com.appManageHotel.controller.staff;

import java.io.IOException;

import com.appManageHotel.model.BEAN.Bill;
import com.appManageHotel.model.BEAN.Customer;
import com.appManageHotel.model.BEAN.IFBookRoom;
import com.appManageHotel.model.BEAN.Room;
import com.appManageHotel.model.BEAN.TypeRoom;
import com.appManageHotel.model.DAO.BillDAOimpl;
import com.appManageHotel.model.DAO.CustomerDAOimpl;
import com.appManageHotel.model.DAO.IFBookRoomDAOimpl;
import com.appManageHotel.model.DAO.RoomDAOimpl;
import com.appManageHotel.model.DAO.TypeRoomDAOimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/bill"})
public class bill extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DO GET /bill");
		
		String IDBill = req.getParameter("IDBill");
		
		Bill bill = BillDAOimpl.getInstance().selectByID(IDBill);
		
		System.out.println("Chcek" + bill.getIDBill());
		
		if(bill != null) {
			System.out.println("Chcek1");
			Customer customer = CustomerDAOimpl.getInstance().selectByID(bill.getIDCustomer());
			IFBookRoom iFBookRoom = IFBookRoomDAOimpl.getInstance().selectByID(bill.getIDIFBookRoom());
			if(iFBookRoom != null) {
				System.out.println("Chce2");
				Room room = RoomDAOimpl.getInstance().selectByID(iFBookRoom.getIDRoom());
				if(room != null) {
					TypeRoom typeRoom = TypeRoomDAOimpl.getInstance().selectByID(room.getIDTypeRoom());
					req.setAttribute("TypeRoomName", typeRoom.getTypeRoomName());
					req.setAttribute("RoomName", room.getRoomName());
					req.setAttribute("FullName", customer.getFullName());
					req.setAttribute("ComeInDate", iFBookRoom.getComeInDate());
					req.setAttribute("ComeOutDate", iFBookRoom.getComeOutDate());
					req.setAttribute("Total", bill.getTotal());
					req.setAttribute("NumberAdult", iFBookRoom.getNumberAdult());
					req.setAttribute("NumberChild", iFBookRoom.getNumberChild());
					
					System.out.println("Chcek");
				}
			}
		}
		
		RequestDispatcher r1 = req.getRequestDispatcher("/views/staff/bill.jsp");
		r1.forward(req, resp);
	}

}
