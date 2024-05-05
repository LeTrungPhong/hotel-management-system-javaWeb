package com.appManageHotel.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.Facility;

public class FacilityDAOimpl implements FacilityDAO{
	
	public static FacilityDAOimpl getInstance() {
		return new FacilityDAOimpl();
	}
	
	@Override
	public int insert(Facility t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "INSERT INTO Facility(IDFacility,FacilityName,IDRoom,State)"
					+ " VALUES(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDFacility());
			pstmt.setString(2, t.getFacilityName());
			pstmt.setString(3, t.getIDRoom());
			pstmt.setBoolean(4, t.isState());
			
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
	public int update(Facility t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String ID) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "DELETE FROM Facility"
					+ " WHERE IDFacility = ?";
			
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
	public ArrayList<Facility> selectAll() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Facility> result = new ArrayList<Facility>(); 
			
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Facility";
			
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String IDFacility = rs.getString("IDFacility");
				String FacilityName = rs.getString("FacilityName");
				String IDRoom = rs.getString("IDRoom");
				boolean State = rs.getBoolean("State");
				result.add(new Facility(IDFacility,FacilityName,IDRoom,State));
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
	public Facility selectByID(String ID) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Facility WHERE IDFacility = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);

			ResultSet rs = pstmt.executeQuery();
			
			String IDFacility = rs.getString("IDFacility");
			String FacilityName = rs.getString("FacilityName");
			String IDRoom = rs.getString("IDRoom");
			boolean State = rs.getBoolean("State");
			Facility result = new Facility(IDFacility,FacilityName,IDRoom,State);
			
			System.out.println("Thuc thi: " + pstmt.toString());
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Facility> selectByCondition(String Condition) {
		// TODO Auto-generated method stub
		return null;
	}
}
