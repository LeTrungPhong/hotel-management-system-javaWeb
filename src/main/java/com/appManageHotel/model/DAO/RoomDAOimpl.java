package com.appManageHotel.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.Room;

public class RoomDAOimpl implements RoomDAO{
	public static RoomDAOimpl getInstance() {
		return new RoomDAOimpl();
	}

	@Override
	public int insert(Room t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "INSERT INTO Room(IDRoom,IDTypeRoom,RoomName) "
					+ " VALUES (?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDRoom());
			pstmt.setString(2, t.getIDTypeRoom());
			pstmt.setString(3, t.getRoomName());
			
			int kq = pstmt.executeUpdate();
			System.out.println("Thuc thi: " + sql);
			System.out.println("Co" + kq + "Ket qua thay doi");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Room t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "UPDATE Room"
					+ " SET IDTypeRoom = ?,"
					+ " RoomName = ?"
					+ " WHERE IDRoom = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDTypeRoom());
			pstmt.setString(2, t.getRoomName());
			pstmt.setString(3, t.getIDRoom());
			
			int kq = pstmt.executeUpdate();
			
			System.out.println("Thuc thi: " + pstmt.toString());
			System.out.println("Co" + kq + "Ket qua thay doi");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(String ID) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "DELETE FROM Room"
					+ " WHERE IDRoom = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, ID);
			
			int kq = pstmt.executeUpdate();
			
			System.out.println("Thuc thi: " + pstmt.toString());
			System.out.println("Co" + kq + "Ket qua thay doi");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<Room> selectAll() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Room> result = new ArrayList<Room>(); 
			
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Room";
			
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String IDRoom = rs.getString("IDRoom");
				String IDTypeRoom = rs.getString("IDTypeRoom");
				String RoomName = rs.getString("RoomName");
				result.add(new Room(IDRoom,IDTypeRoom,RoomName));
			}
			
			System.out.println("Thuc thi: " + pstmt.toString());
			return result;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Room selectByID(String ID) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Room WHERE IDRoom = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String IDRoom = rs.getString("IDRoom");
				String IDTypeRoom = rs.getString("IDTypeRoom");
				String RoomName = rs.getString("RoomName");
		
				Room result = new Room(IDRoom,IDTypeRoom,RoomName);
			
				System.out.println("Thuc thi: " + pstmt.toString());
				return result;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Room> selectByCondition(String Condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Room> selectByIDTypeRoom(String ID) {
		// TODO Auto-generated method stub
		try {
			ArrayList<Room> result = new ArrayList<Room>(); 
			
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Room WHERE IDTypeRoom = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String IDRoom = rs.getString("IDRoom");
				String IDTypeRoom = rs.getString("IDTypeRoom");
				String RoomName = rs.getString("RoomName");
				result.add(new Room(IDRoom,IDTypeRoom,RoomName));
			}
			
			System.out.println("Thuc thi: " + pstmt.toString());
			return result;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Room selectByRoomName(String name) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Room WHERE RoomName = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			String IDRoom = rs.getString("IDRoom");
			String IDTypeRoom = rs.getString("IDTypeRoom");
			String RoomName = rs.getString("RoomName");
		
			Room result = new Room(IDRoom,IDTypeRoom,RoomName);
			
			System.out.println("Thuc thi: " + pstmt.toString());
			return result;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int selectPriceByIDRoom(String IDRoom) {
		int result=0;
		try{
			Connection c=ConnectDatabase.getConnection();
			String sql="Select Price From TypeRoom where IDTypeRoom in (select IDTypeRoom From Room where IDRoom= ?) ";
			PreparedStatement pstmt=c.prepareStatement(sql);
			pstmt.setString(1, IDRoom);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				result=rs.getInt("Price");
			}
			return result;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
