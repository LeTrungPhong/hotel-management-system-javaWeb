package com.appManageHotel.model.BO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.Bill;
import com.appManageHotel.model.BEAN.Customer;
import com.appManageHotel.model.BEAN.IFBookRoom;
import com.appManageHotel.model.DAO.BillDAOimpl;
import com.appManageHotel.model.DAO.CustomerDAOimpl;
import com.appManageHotel.model.DAO.IFBookRoomDAOimpl;

public class IFBookRoomBO {
	
	public static IFBookRoomBO getInstance() {
		return new IFBookRoomBO();
	}
	
	public boolean bookRoom(IFBookRoom t,String IDTypeRoom,Customer r, int totalBill, int PrepaymentBill) {
		try {
			Connection con = ConnectDatabase.getConnection();
			String sql="select IDRoom from Room where IDTypeRoom=? except select IDRoom from IFBookRoom where (?<=ComeInDate and ComeInDate<=?) or (?<=ComeOutDate and ComeOutDate<=?) or (ComeInDate<=? and ComeOutDate>=?)  ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, IDTypeRoom);
			pstmt.setDate(2, Date.valueOf(t.getComeInDate()));
			pstmt.setDate(3, Date.valueOf(t.getComeOutDate()));
			pstmt.setDate(4, Date.valueOf(t.getComeInDate()));
			pstmt.setDate(5, Date.valueOf(t.getComeOutDate()));
			pstmt.setDate(6, Date.valueOf(t.getComeInDate()));
			pstmt.setDate(7, Date.valueOf(t.getComeOutDate()));

			
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			if (rs.next()) {
				String IDRoom=rs.getString("IDRoom");
				t.setIDRoom(IDRoom);
				
			}
			else return false;
			IFBookRoomDAOimpl.getInstance().insert(t);
			CustomerDAOimpl.getInstance().insert(r);
			String id = UUID.randomUUID().toString();
			Bill b = new Bill(id, "Staffweb", r.getIDCustomer(),PrepaymentBill, totalBill, t.getIDIFBookRoom());
			BillDAOimpl.getInstance().insert(b);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean bookRoomByAccount(IFBookRoom t,String IDTypeRoom,Customer r, int totalBill, int PrepaymentBill) {
		try {
			Connection con = ConnectDatabase.getConnection();
			String sql="select IDRoom from Room where IDTypeRoom=? except select IDRoom from IFBookRoom where (?<=ComeInDate and ComeInDate<=?) or (?<=ComeOutDate and ComeOutDate<=?) or (ComeInDate<=? and ComeOutDate>=?)  ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, IDTypeRoom);
			pstmt.setDate(2, Date.valueOf(t.getComeInDate()));
			pstmt.setDate(3, Date.valueOf(t.getComeOutDate()));
			pstmt.setDate(4, Date.valueOf(t.getComeInDate()));
			pstmt.setDate(5, Date.valueOf(t.getComeOutDate()));
			pstmt.setDate(6, Date.valueOf(t.getComeInDate()));
			pstmt.setDate(7, Date.valueOf(t.getComeOutDate()));

			
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			if (rs.next()) {
				String IDRoom=rs.getString("IDRoom");
				t.setIDRoom(IDRoom);
				
			}
			else return false;
			IFBookRoomDAOimpl.getInstance().insert(t);
			String id = UUID.randomUUID().toString();
			Bill b = new Bill(id, "Staffweb", r.getIDCustomer(),PrepaymentBill, totalBill, t.getIDIFBookRoom());
			BillDAOimpl.getInstance().insert(b);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	public void cancelling(IFBookRoom t) {
		t.setState(false);
		IFBookRoomDAOimpl.getInstance().update(t);
	}
}
