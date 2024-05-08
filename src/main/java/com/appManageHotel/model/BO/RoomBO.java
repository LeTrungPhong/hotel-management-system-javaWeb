package com.appManageHotel.model.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.Room;
import com.appManageHotel.model.BEAN.TypeRoom;
import com.appManageHotel.model.DAO.RoomDAOimpl;
import com.appManageHotel.model.DAO.TypeRoomDAOimpl;

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
			if(typeRoom == null) {
				Connection con = ConnectDatabase.getConnection();
				String sql = "Select * From TypeRoom where Price <= ? and Price >= ? and MaxAdult >= ? and MaxChild >= ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, PriceMax);
				pstmt.setInt(2, PriceMin);
				pstmt.setInt(3, maxAdult);
				pstmt.setInt(4, maxChild);
				
				ResultSet rs = pstmt.executeQuery();
				System.out.println("Thuc thi: " + pstmt.toString());
				while(rs.next()) {
					String IdTypeRoom = rs.getString("IDTypeRoom");
					a.add(IdTypeRoom);
				}
			} else {
				Connection con = ConnectDatabase.getConnection();
				for (int i = 0;i < typeRoom.length; i++) {
					String sql = "Select * From TypeRoom where Price <= ? and Price >= ? and MaxAdult >= ? and MaxChild >= ? and TypeRoomName = ?";
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
			}
			return a;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<String> FindRoomFree(LocalDate inn, LocalDate outt){
		if(inn == null || outt == null) {
			ArrayList<TypeRoom> allTypeRoom = TypeRoomDAOimpl.getInstance().selectAll();
			ArrayList<String> listIDTypeRoom = new ArrayList<String>();
			for(TypeRoom i : allTypeRoom) {
				listIDTypeRoom.add(i.getIDTypeRoom());
			}
			return listIDTypeRoom;
		} else {
			ArrayList<String> a = new ArrayList<String>();
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//	        String dayin = sdf.format(inn);
//	        String dayout = sdf.format(outt);
			try {
				Connection con = ConnectDatabase.getConnection();
				String sql = "Select distinct IDTypeRoom From Room where IDRoom in (select IDRoom from Room except select IDRoom from IFBookRoom where ( ? <= ComeInDate and ComeInDate <=? ) or ( ?<= ComeOutDate or ComeOutDate <=? ) or ( ComeInDate <= ? and ComeOutDate >= ? ))";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setDate(1, java.sql.Date.valueOf(inn));
				pstmt.setDate(2, java.sql.Date.valueOf(outt));
				pstmt.setDate(3, java.sql.Date.valueOf(inn));
				pstmt.setDate(4, java.sql.Date.valueOf(outt));
				pstmt.setDate(5, java.sql.Date.valueOf(inn));
				pstmt.setDate(6, java.sql.Date.valueOf(inn));
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
	
	public ArrayList<TypeRoom> findRoom(int MinPrice, int MaxPrice, int maxAdult, int maxChild, LocalDate timeStart, LocalDate timeEnd, String[] listTypeRoomName){
		
		if(MinPrice == 0 && MaxPrice == 0 && maxAdult == 0 && maxChild == 0 && timeStart == null && timeEnd == null && listTypeRoomName == null) {
			return TypeRoomDAOimpl.getInstance().selectAll();
		}
		
		ArrayList<String> idTypeRoomCondition = FindRoomByCondition(listTypeRoomName, MinPrice, MaxPrice, maxAdult, maxChild);
		
		if(idTypeRoomCondition != null) {
			for(String s : idTypeRoomCondition) {
				System.out.println(s);
			}
		}
		
		ArrayList<String> idTypeRoomFree = FindRoomFree(
				timeStart != null ? timeStart : null, 
				timeEnd != null ? timeEnd : null);
		
		if(idTypeRoomFree != null) {
			for(String s : idTypeRoomFree) {
				System.out.println(s);
			}
		}
		
		ArrayList<String> mergedList = new ArrayList<>();
		if(idTypeRoomCondition != null && idTypeRoomFree != null) {
			for(String str1 : idTypeRoomCondition) {
				for(String str2 : idTypeRoomFree) {
					if(str1.equals(str2)) {
						mergedList.add(str1);
					}
				}
			}
		}
		
		ArrayList<TypeRoom> listTypeRoom = new ArrayList<TypeRoom>();
		if(mergedList != null) {
			for(int i = 0; i < mergedList.size(); ++i) {
				listTypeRoom.add(TypeRoomDAOimpl.getInstance().selectByID(mergedList.get(i)));
			}
		}
		
		return listTypeRoom;
	}
}
