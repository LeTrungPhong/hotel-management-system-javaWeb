package com.appManageHotel.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.ImageTypeRoom;

public class ImageTypeRoomDAOimpl implements ImageTypeRoomDAO{

	public static ImageTypeRoomDAOimpl getInstance() {
		return new ImageTypeRoomDAOimpl();
	}
	
	@Override
	public int insert(ImageTypeRoom t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "INSERT INTO ImageTypeRoom(IDImage,IDTypeRoom) "
					+ " VALUES (?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDImage());
			pstmt.setString(2, t.getIDTypeRoom());
			
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
	public int update(ImageTypeRoom t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ImageTypeRoom> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageTypeRoom selectByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ImageTypeRoom> selectByCondition(String Condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByIDTypeRoom(String ID) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "DELETE FROM ImageTypeRoom"
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
	public ArrayList<ImageTypeRoom> selectByIDTypeRoom(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
