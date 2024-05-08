package com.appManageHotel.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.Image;

public class ImageDAOimpl implements ImageDAO{
	public static ImageDAOimpl getInstance() {
		return new ImageDAOimpl();
	}

	@Override
	public int insert(Image t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "INSERT INTO Image(IDImage,ImageName,Path)"
					+ " VALUES(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDImage());
			pstmt.setString(2, t.getImageName());
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
					+ " SET ImageName = ?,"
					+ " Path = ?"
					+ " WHERE IDImage = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getImageName());
			pstmt.setString(2, t.getPath());
			pstmt.setString(3, t.getIDImage());
			
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
				String ImageName = rs.getString("ImageName");
				String Path = rs.getString("Path");
				result.add(new Image(IDImage,ImageName,Path));
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
			while(rs.next()) {
				String IDImage = rs.getString("IDImage");
				String ImageName = rs.getString("ImageName");
				String Path = rs.getString("Path");
				return (new Image(IDImage, ImageName, Path));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Image selectByIDRoom(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Image> selectByCondition(String Condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image selectByNameOrPath(String name, String path) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Image WHERE ImageName = ? OR Path = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, path);
			
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			
			while(rs.next()) {
				String IDImage = rs.getString("IDImage");
				String ImageName = rs.getString("ImageName");
				String Path = rs.getString("Path");
				return new Image(IDImage,ImageName,Path);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Image selectByNameOrPathExceptID(String id, String name, String path) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Image WHERE (ImageName = ? OR Path = ?) AND IDImage != ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, path);
			pstmt.setString(3, id);
			
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			
			while(rs.next()) {
				String IDImage = rs.getString("IDImage");
				String ImageName = rs.getString("ImageName");
				String Path = rs.getString("Path");
				return new Image(IDImage,ImageName,Path);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Image> selectByIDTypeRoom(String id) {
		// TODO Auto-generated method stub
		try {
			ArrayList<Image> result = new ArrayList<Image>();
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT Image.* FROM (TypeRoom JOIN ImageTypeRoom on TypeRoom.IDTypeRoom = ImageTypeRoom.IDTypeRoom) JOIN Image ON ImageTypeRoom.IDImage = Image.IDImage"
					+ " WHERE TypeRoom.IDTypeRoom = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			
			while(rs.next()) {
				String IDImage = rs.getString("IDImage");
				String ImageName = rs.getString("ImageName");
				String Path = rs.getString("Path");
				result.add(new Image(IDImage,ImageName,Path));
			}
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
