package com.appManageHotel.model.BO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.Room;
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
	
	public ArrayList<Room> ListAllRoomFree(LocalDate inn,LocalDate outt) {
		ArrayList<Room> a=new ArrayList<Room>();
		try {
			Connection c = ConnectDatabase.getConnection();
			String sql="Select * From Room where IDRoom in (select IDRoom from Room except select IDRoom from IFBookRoom where (?<=ComeInDate and ComeInDate<=?) or (?<=ComeOutDate and ComeOutDate<=?) or (ComeInDate<=? and ComeOutDate>=?))  ";
			PreparedStatement pstmt;
				pstmt = c.prepareStatement(sql);
			pstmt.setDate(1, Date.valueOf(inn));
			pstmt.setDate(2, Date.valueOf(outt));
			pstmt.setDate(3, Date.valueOf(inn));
			pstmt.setDate(4, Date.valueOf(outt));
			pstmt.setDate(5,  Date.valueOf(inn));
			pstmt.setDate(6,  Date.valueOf(outt));
			ResultSet rs=pstmt.executeQuery();
			while (rs.next()) {
				String id=rs.getString("IDRoom");
				String idtypeRoom=rs.getString("IDTypeRoom");
				String roomName=rs.getString("RoomName");
				a.add(new Room(id, idtypeRoom, roomName));
			}
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	public ArrayList<Room> ListRoomByCondition(LocalDate inn,LocalDate outt,int MinPrice,int MaxPrice,int Adult,int Child) {
		ArrayList<Room> a=new ArrayList<Room>();
		try {
			Connection c = ConnectDatabase.getConnection();
			String sql = "Select * From Room where IDRoom in (select IDRoom from Room except select IDRoom from IFBookRoom where (?<=ComeInDate and ComeInDate<=?) or (?<=ComeOutDate and ComeOutDate<=?) or (ComeInDate<=? and ComeOutDate>=?))  "
					+" and IDTypeRoom in (select IDTypeRoom From TypeRoom where (Price>=? and Price<=?) and (MaxAdult>=?) and (MaxChild>=?)) "
					+ " ORDER BY IDTypeRoom DESC";
			PreparedStatement pstmt; 
				pstmt = c.prepareStatement(sql);
			pstmt.setDate(1, Date.valueOf(inn));
			pstmt.setDate(2, Date.valueOf(outt));
			pstmt.setDate(3, Date.valueOf(inn));
			pstmt.setDate(4, Date.valueOf(outt));
			pstmt.setDate(5,  Date.valueOf(inn));
			pstmt.setDate(6,  Date.valueOf(outt));
			pstmt.setInt(7, MinPrice);
			pstmt.setInt(8, MaxPrice);
			pstmt.setInt(9, Adult);
			pstmt.setInt(10, Child);
			ResultSet rs=pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("IDRoom");
				String idtypeRoom = rs.getString("IDTypeRoom");
				String roomName = rs.getString("RoomName");
				a.add(new Room(id, idtypeRoom, roomName));
			}
			return a;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	
	public ArrayList<Room> findRoom(int MinPrice, int MaxPrice, int maxAdult, int maxChild, LocalDate inn, LocalDate outt, String[] listTypeRoomName){
		
		inn = inn != null ? inn : LocalDate.now();
		outt = outt != null ? outt : LocalDate.now().plusDays(1);
		
		ArrayList<Room> listRoomCondition = ListRoomByCondition(inn, outt, MinPrice, MaxPrice, maxAdult, maxChild);
		
		ArrayList<Room> listRoomFree = ListAllRoomFree(inn, outt);
		
//		if(idTypeRoomCondition != null) {
//			for(String s : idTypeRoomCondition) {
//				System.out.println(s);
//			}
//		}
		
		ArrayList<Room> listRoom = new ArrayList<Room>();
		
		if(listRoomCondition != null) {
			for(int i = 0; i < listRoomCondition.size(); ++i) {
				if(listRoomFree != null) {
					for(int j = 0; j < listRoomFree.size(); ++j) {
						if(listRoomFree.get(j).getIDRoom().equals(listRoomCondition.get(i).getIDRoom())) {
							listRoom.add(listRoomFree.get(j));
						}
					} 
				}
			}
		}
		
		if(listTypeRoomName == null) { 
			return listRoom; 
		}
		
		ArrayList<Room> listRoomLast = new ArrayList<Room>();
		
		if(listRoom != null) {
			for(int i = 0; i < listRoom.size(); ++i) {
				for(int j = 0; j < listTypeRoomName.length; j++) {
					if(listRoom.get(i).getIDTypeRoom().equals(TypeRoomDAOimpl.getInstance().selectByTypeRoomName(listTypeRoomName[j]).getIDTypeRoom())) {
						listRoomLast.add(listRoom.get(i));
						break;
					}
				}
			}
		}
		return listRoomLast;
	}
}
