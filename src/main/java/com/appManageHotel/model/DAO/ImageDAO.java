package com.appManageHotel.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.Image;

public class ImageDAO implements DAOInterface<Image>{
	
	public static ImageDAO getInstance() {
		return new ImageDAO();
	}

	@Override
	public int insert(Image t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "INSERT INTO Image(IDImage,IDRoom,Path)"
					+ " VALUES(?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, t.getIDImage());
			pstmt.setString(2, t.getIDRoom());
			pstmt.setString(3, t.getPath());
			
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
	public int update(Image t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "UPDATE Image"
					+ " SET IDRoom = ?,"
					+ " Path = ?,"
					+ " WHERE IDImage = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, t.getIDRoom());
			pstmt.setString(2, t.getPath());
			pstmt.setString(3, t.getIDImage());
			
			int kq = pstmt.executeUpdate();
			
			System.out.println("Thuc thi: " + pstmt.toString());
			System.out.println("Co" + kq + "Ket qua thay doi");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(String ID) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "DELETE FROM Image"
					+ " WHERE IDImage = ?";
			
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
	public ArrayList<Image> selectAll() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Image> result = new ArrayList<Image>(); 
			
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Image";
			
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String IDImage = rs.getString("IDImage");
				String IDRoom = rs.getString("IDRoom");
				String Path = rs.getString("Path");
				result.add(new Image(IDImage,IDRoom,Path));
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
	public Image selectByID(String ID) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Image WHERE IDImage = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);

			ResultSet rs = pstmt.executeQuery();
			
			String IDImage = rs.getString("IDImage");
			String IDRoom = rs.getString("IDRoom");
			String Path = rs.getString("Path");
			Image result = new Image(IDImage,IDRoom,Path);
			
			System.out.println("Thuc thi: " + pstmt.toString());
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Image selectByIDRoom(String ID) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Image WHERE IDRoom = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);

			ResultSet rs = pstmt.executeQuery();
			
			String IDImage = rs.getString("IDImage");
			String IDRoom = rs.getString("IDRoom");
			String Path = rs.getString("Path");
			Image result = new Image(IDImage,IDRoom,Path);
			
			System.out.println("Thuc thi: " + pstmt.toString());
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Image> selectByCondition(String Condition) {
		// TODO Auto-generated method stub
//		try {
//			ArrayList<Image> result = new ArrayList<Image>(); 
//			
//			Connection con = ConnectDatabase.getConnection();
//			
//			String sql = "SELECT * FROM Image WHERE ?";
//			
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, Condition);
//
//			ResultSet rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				String IDImage = rs.getString("IDImage");
//				String IDRoom = rs.getString("IDRoom");
//				String Path = rs.getString("Path");
//				result.add(new Image(IDImage,IDRoom,Path));
//			}
//			
//			System.out.println("Thuc thi: " + pstmt.toString());
//			return result;
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
		
		return null;
	}
}
