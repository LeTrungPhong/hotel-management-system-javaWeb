package com.appManageHotel.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.TypeRoom;

public class TypeRoomDAOimpl implements TypeRoomDAO{
	public static TypeRoomDAOimpl getInstance() {
		return new TypeRoomDAOimpl();
	}
	
	@Override
	public int insert(TypeRoom t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "INSERT INTO TypeRoom(IDTypeRoom,TypeRoomName,Price,MaxPeople,NumberBook) "
					+ " VALUES (?,?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDTypeRoom());
			pstmt.setString(2, t.getTypeRoomName());
			pstmt.setInt(3, t.getPrice());
			pstmt.setInt(4, t.getMaxPeople());
			pstmt.setInt(5, t.getNumberBook());
			
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
	public int update(TypeRoom t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "UPDATE TypeRoom"
					+ " SET TypeRoomName = ?"
					+ " Price = ?"
					+ " MaxPeople = ?"
					+ " NumberBook = ?"
					+ " WHERE IDTypeRoom = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getTypeRoomName());
			pstmt.setInt(2, t.getPrice());
			pstmt.setInt(3, t.getMaxPeople());
			pstmt.setInt(4, t.getNumberBook());
			pstmt.setString(5, t.getIDTypeRoom());
			
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
			
			String sql = "DELETE FROM TypeRoom"
					+ " WHERE IDTypeRoom = ?";
			
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
	public ArrayList<TypeRoom> selectAll() {
		// TODO Auto-generated method stub
		try {
			ArrayList<TypeRoom> result = new ArrayList<TypeRoom>(); 
			
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM TypeRoom";
			
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String IDTypeRoom = rs.getString("IDTypeRoom");
				String TypeRoomName = rs.getString("TypeRoomName");
				int Price = rs.getInt("Price");
				int MaxPeople = rs.getInt("MaxPeople");
				int NumberBook = rs.getInt("NumberBook");
				result.add(new TypeRoom(IDTypeRoom,TypeRoomName,Price,MaxPeople,NumberBook));
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
	public TypeRoom selectByID(String ID) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM TypeRoom WHERE IDTypeRoom = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String IDTypeRoom = rs.getString("IDTypeRoom");
				String TypeRoomName = rs.getString("TypeRoomName");
				int Price = rs.getInt("Price");
				int MaxPeople = rs.getInt("MaxPeople");
				int NumberBook = rs.getInt("NumberBook");
				TypeRoom result = new TypeRoom(IDTypeRoom,TypeRoomName,Price,MaxPeople,NumberBook);
				System.out.println("Thuc thi: " + pstmt.toString());
				return result;
			}
			return null;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<TypeRoom> selectByCondition(String Condition) {
		// TODO Auto-generated method stub
		return null;
	}
}
