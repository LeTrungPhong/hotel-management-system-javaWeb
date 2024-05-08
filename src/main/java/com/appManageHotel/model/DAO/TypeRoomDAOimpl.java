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
			
			String sql = "INSERT INTO TypeRoom(IDTypeRoom,TypeRoomName,Price,MaxAdult,MaxChild,NumberBook,Description) "
					+ " VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDTypeRoom());
			pstmt.setString(2, t.getTypeRoomName());
			pstmt.setInt(3, t.getPrice());
			pstmt.setInt(4, t.getMaxAdult());
			pstmt.setInt(5, t.getMaxChild());
			pstmt.setInt(6, t.getNumberBook());
			pstmt.setString(7, t.getDescription());
			
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
					+ " SET TypeRoomName = ?,"
					+ " Price = ?," 
					+ " MaxAdult = ?,"
					+ " MaxChild = ?,"
					+ " Description = ?"
					+ " WHERE IDTypeRoom = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getTypeRoomName());
			pstmt.setInt(2, t.getPrice());
			pstmt.setInt(3, t.getMaxAdult());
			pstmt.setInt(4, t.getMaxChild());
			pstmt.setString(5, t.getDescription());
			pstmt.setString(6, t.getIDTypeRoom());
			
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
				int MaxAdult = rs.getInt("MaxAdult");
				int MaxChild = rs.getInt("MaxChild");
				int NumberBook = rs.getInt("NumberBook");
				String Description = rs.getString("Description");
				result.add(new TypeRoom(IDTypeRoom,TypeRoomName,Price,MaxAdult,MaxChild,NumberBook,Description));
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
				int MaxAdult = rs.getInt("MaxAdult");
				int MaxChild = rs.getInt("MaxChild");
				int NumberBook = rs.getInt("NumberBook");
				String Description = rs.getString("Description");
				return (new TypeRoom(IDTypeRoom,TypeRoomName,Price,MaxAdult,MaxChild,NumberBook,Description));
			}
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

	@Override
	public TypeRoom selectByTypeRoomName(String typeroomname) {
		// TODO Auto-generated method stub
		
		try {
			Connection con = ConnectDatabase.getConnection();
			String sql = "SELECT * FROM TypeRoom WHERE TypeRoomName = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, typeroomname);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String IDTypeRoom = rs.getString("IDTypeRoom");
				String TypeRoomName = rs.getString("TypeRoomName");
				int Price = rs.getInt("Price");
				int MaxAdult = rs.getInt("MaxAdult");
				int MaxChild = rs.getInt("MaxChild");
				int NumberBook = rs.getInt("NumberBook");
				String Description = rs.getString("Description");
				return (new TypeRoom(IDTypeRoom,TypeRoomName,Price,MaxAdult,MaxChild,NumberBook,Description));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TypeRoom selectByTypeRoomNameExceptID(String id, String typeroomname) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM TypeRoom WHERE TypeRoomName = ? AND IDTypeRoom != ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, typeroomname);
			pstmt.setString(2, id);
			
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			
			while(rs.next()) {
				String IDTypeRoom = rs.getString("IDTypeRoom");
				String TypeRoomName = rs.getString("TypeRoomName");
				int Price = rs.getInt("Price");
				int MaxAdult = rs.getInt("MaxAdult");
				int MaxChild = rs.getInt("MaxChild");
				int NumberBook = rs.getInt("NumberBook");
				String Description = rs.getString("Description");
				return (new TypeRoom(IDTypeRoom,TypeRoomName,Price,MaxAdult,MaxChild,NumberBook,Description));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<TypeRoom> selectTypeRoomMaxPrice(int number) {
		// TODO Auto-generated method stub
		try {
			ArrayList<TypeRoom> result = new ArrayList<TypeRoom>();
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT TOP " + number + " * FROM TypeRoom ORDER BY Price DESC";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			 
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			
			while(rs.next()) {
				String IDTypeRoom = rs.getString("IDTypeRoom");
				String TypeRoomName = rs.getString("TypeRoomName");
				int Price = rs.getInt("Price");
				int MaxAdult = rs.getInt("MaxAdult");
				int MaxChild = rs.getInt("MaxChild");
				int NumberBook = rs.getInt("NumberBook");
				String Description = rs.getString("Description");
				result.add(new TypeRoom(IDTypeRoom,TypeRoomName,Price,MaxAdult,MaxChild,NumberBook,Description));
			}
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<TypeRoom> selectTypeRoomMinPrice(int number) {
		// TODO Auto-generated method stub
				ArrayList<TypeRoom> result = new ArrayList<TypeRoom>();
				try {
					Connection con = ConnectDatabase.getConnection();
					
					String sql = "SELECT TOP " + number + " * FROM TypeRoom ORDER BY Price ASC";
					
					PreparedStatement pstmt = con.prepareStatement(sql);
					
					ResultSet rs = pstmt.executeQuery();
					System.out.println("Thuc thi: " + pstmt.toString());
					
					while(rs.next()) {
						String IDTypeRoom = rs.getString("IDTypeRoom");
						String TypeRoomName = rs.getString("TypeRoomName");
						int Price = rs.getInt("Price");
						int MaxAdult = rs.getInt("MaxAdult");
						int MaxChild = rs.getInt("MaxChild");
						int NumberBook = rs.getInt("NumberBook");
						String Description = rs.getString("Description");
						result.add(new TypeRoom(IDTypeRoom,TypeRoomName,Price,MaxAdult,MaxChild,NumberBook,Description));
					}
					return result;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return null;
	}

	@Override
	public ArrayList<TypeRoom> selectTypeRoomMaxBooked(int number) {
		// TODO Auto-generated method stub
		try {
			ArrayList<TypeRoom> result = new ArrayList<TypeRoom>();
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT TOP " + number + " * FROM TypeRoom ORDER BY NumberBook DESC";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			 
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			
			while(rs.next()) {
				String IDTypeRoom = rs.getString("IDTypeRoom");
				String TypeRoomName = rs.getString("TypeRoomName");
				int Price = rs.getInt("Price");
				int MaxAdult = rs.getInt("MaxAdult");
				int MaxChild = rs.getInt("MaxChild");
				int NumberBook = rs.getInt("NumberBook");
				String Description = rs.getString("Description");
				result.add(new TypeRoom(IDTypeRoom,TypeRoomName,Price,MaxAdult,MaxChild,NumberBook,Description));
			}
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
