package com.appManageHotel.model.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.Room;
import com.appManageHotel.model.DAO.RoomDAOimpl;

public class RoomBO {

	public static RoomBO getInstance() {
		return new RoomBO();
	}
	
	public boolean InsertRoom(Room t) {
		Room f = RoomDAOimpl.getInstance().selectByRoomName(t.getRoomName());
		if (f != null) {
			return false;
		} else {
			RoomDAOimpl.getInstance().insert(t);
			return true;
		}
	}
	
	public boolean UpdateRoom(String IDRoom, String newName) {
		Room f = RoomDAOimpl.getInstance().selectByRoomName(newName);
		if (f != null) {
			return false;
		} else {
			Room r = RoomDAOimpl.getInstance().selectByID(IDRoom);
			r.setRoomName(newName);
			RoomDAOimpl.getInstance().update(r);
			return true;
		}
	}
	
	public ArrayList<String> FindRoomByCondition(String[] typeRoom,int PriceMin, int PriceMax,int maxAdult,int maxChild) {
		ArrayList<String> a = new ArrayList<String>();
		try { 
			Connection con = ConnectDatabase.getConnection();
			for (int i = 0;i < typeRoom.length; i++) {
				String sql = "Select * From TypeRoom where Price <= ? and Price >= ? and MaxAdult = ? and MaxChild = ? and TypeRoomName = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, PriceMax);
				pstmt.setInt(2, PriceMin);
				pstmt.setInt(3, maxAdult);
				pstmt.setInt(4, maxChild);
				pstmt.setString(5, typeRoom[i]);
				
				ResultSet rs = pstmt.executeQuery();
				System.out.println("Thuc thi: " + pstmt.toString());
				while(rs.next()) {
					String IdTypeRoom = rs.getString("IDTypeRoom");
					a.add(IdTypeRoom);
				}
			}
			return a;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<String> FindRoomFree(Date inn, Date outt){
		ArrayList<String> a = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dayin = sdf.format(inn);
        String dayout = sdf.format(outt);
		try {
			Connection con = ConnectDatabase.getConnection();
			String sql = "Select distinct IDTypeRoom From Room where IDRoom in (select IDRoom from Room except select IDRoom from IFBookRoom where ( ? <= ComeInDate and ComeInDate <=? ) or ( ?<= ComeOutDate or ComeOutDate <=? ) or ( ComeInDate <= ? and ComeOutDate >= ? ))  ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dayin);
			pstmt.setString(2, dayout);
			pstmt.setString(3, dayin);
			pstmt.setString(4, dayout);
			pstmt.setString(5, dayin);
			pstmt.setString(6, dayin);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			while(rs.next()) {
				String IdTypeRoom=rs.getString("IDTypeRoom");
				a.add(IdTypeRoom);
			}
			return a;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
