package com.appManageHotel.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.Service;

public class ServiceDAOimpl implements ServiceDAO{
	
	public static ServiceDAOimpl getInstance() {
		return new ServiceDAOimpl();
	}

	@Override
	public int insert(Service t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "INSERT INTO Service(IDService,ServiceName,Price,Description,IDImage,NumberUse) "
					+ " VALUES (?,?,?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDService());
			pstmt.setString(2, t.GetServiceName()); 
			pstmt.setInt(3, t.getPrice());
			pstmt.setString(4, t.getDescription());
			pstmt.setString(5, t.getIDImage());
			pstmt.setInt(6, t.getNumberUse());
			
			int kq = pstmt.executeUpdate();
			System.out.println("Thuc thi: " + sql);
			System.out.println("Co" + kq + "Ket qua thay doi");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Service t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "UPDATE Service"
					+ " SET ServiceName = ?,"
					+ " Price = ?,"
					+ " Description = ?,"
					+ " IDImage = ?"
					+ " WHERE IDService = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.GetServiceName());
			pstmt.setInt(2, t.getPrice());
			pstmt.setString(3, t.getDescription());
			pstmt.setString(4, t.getIDImage());
			pstmt.setString(5, t.getIDService());
			
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
	public ArrayList<Service> selectAll() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Service> result = new ArrayList<Service>(); 
			
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Service";
			
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String IDService = rs.getString("IDService");
				String ServiceName = rs.getString("ServiceName");
				int Price = rs.getInt("Price");
				String Description = rs.getString("Description");
				String IDImage = rs.getString("IDImage");
				int NumberUse = rs.getInt("NumberUse");
				result.add(new Service( IDService,ServiceName,Price,Description,IDImage,NumberUse));
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
	public Service selectByID(String ID) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Service WHERE IDService = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);

			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
	
			while(rs.next()) {
				String IDService = rs.getString("IDService");
				String ServiceName = rs.getString("ServiceName");
				int Price = rs.getInt("Price");
				String Description = rs.getString("Description");
				String IDImage = rs.getString("IDImage");
				int NumberUse = rs.getInt("NumberUse");
				return new Service( IDService,ServiceName,Price,Description,IDImage,NumberUse);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Service> selectByCondition(String Condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Service selectByName(String name) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Service WHERE ServiceName = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
	
			while(rs.next()) {
				String IDService = rs.getString("IDService");
				String ServiceName = rs.getString("ServiceName");
				int Price = rs.getInt("Price");
				String Description = rs.getString("Description");
				String IDImage = rs.getString("IDImage");
				int NumberUse = rs.getInt("NumberUse");
				return new Service( IDService,ServiceName,Price,Description,IDImage,NumberUse);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Service selectByNameExceptID(String id, String name) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Service WHERE ServiceName = ? AND IDService != ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);

			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
	
			while(rs.next()) {
				String IDService = rs.getString("IDService");
				String ServiceName = rs.getString("ServiceName");
				int Price = rs.getInt("Price");
				String Description = rs.getString("Description");
				String IDImage = rs.getString("IDImage");
				int NumberUse = rs.getInt("NumberUse");
				return new Service( IDService,ServiceName,Price,Description,IDImage,NumberUse);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Service> selectServiceMaxUsed(int number) {
		// TODO Auto-generated method stub
		try {
			ArrayList<Service> result = new ArrayList<Service>();
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT TOP " + number + " * FROM Service ORDER BY NumberUse DESC";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			 
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			
			while(rs.next()) {
				String IDService = rs.getString("IDService");
				String ServiceName = rs.getString("ServiceName");
				int Price = rs.getInt("Price");
				String Description = rs.getString("Description");
				String IDImage = rs.getString("IDImage");
				int NumberUse = rs.getInt("NumberUse");
				result.add(new Service( IDService,ServiceName,Price,Description,IDImage,NumberUse)); 
			}
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
