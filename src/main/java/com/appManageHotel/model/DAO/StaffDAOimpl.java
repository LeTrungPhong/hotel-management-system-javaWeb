package com.appManageHotel.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.Staff;

public class StaffDAOimpl implements StaffDAO{
	
	public static StaffDAOimpl getInstance() {
		return new StaffDAOimpl();
	}

	@Override
	public int insert(Staff t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "INSERT INTO Staff(IDStaff,FullName,CCCD,IDAccount,State) "
					+ " VALUES (?,?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDStaff());
			pstmt.setString(2, t.getFullName());
			pstmt.setString(3, t.getCCCD());
			pstmt.setString(4, t.getIDAccount());
			pstmt.setBoolean(5, t.getState());
			
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
	public int update(Staff t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "UPDATE Staff"
					+ " SET CCCD = ?,"
					+ " FullName = ?," 
					+ " IDAccount = ?,"
					+ " State = ?"
					+ " WHERE IDStaff = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getCCCD());
			pstmt.setString(2, t.getFullName());
			pstmt.setString(3, t.getIDAccount());
			pstmt.setBoolean(4, t.getState());
			pstmt.setString(5, t.getIDStaff());
			
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
	public ArrayList<Staff> selectAll() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Staff> result = new ArrayList<Staff>(); 
			
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Staff";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String IDStaff = rs.getString("IDStaff");
				String FullName = rs.getString("FullName");
				String CCCD = rs.getString("CCCD");
				String IDAccount = rs.getString("IDAccount");
				boolean State = rs.getBoolean("State");
				result.add(new Staff(IDStaff,FullName,CCCD,IDAccount,State));
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
	public Staff selectByID(String ID) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Staff WHERE IDStaff = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			

			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			
			while(rs.next()) {
				String IDStaff = rs.getString("IDStaff");
				String FullName = rs.getString("FullName");
				String CCCD = rs.getString("CCCD");
				String IDAccount = rs.getString("IDAccount");
				boolean State = rs.getBoolean("State");
				return new Staff(IDStaff,FullName,CCCD,IDAccount,State);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Staff> selectByCondition(String Condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Staff selectByCCCD(String cccd) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Staff WHERE CCCD = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cccd);
			

			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			
			while(rs.next()) {
				String IDStaff = rs.getString("IDStaff");
				String FullName = rs.getString("FullName");
				String CCCD = rs.getString("CCCD");
				String IDAccount = rs.getString("IDAccount");
				boolean State = rs.getBoolean("State");
				return new Staff(IDStaff,FullName,CCCD,IDAccount,State);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Staff selectByCCCDExceptID(String iDStaff, String cccd) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Staff WHERE CCCD = ? AND IDAccount != ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cccd);
			pstmt.setString(2, iDStaff);
			

			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			
			while(rs.next()) {
				String IDStaff = rs.getString("IDStaff");
				String FullName = rs.getString("FullName");
				String CCCD = rs.getString("CCCD");
				String IDAccount = rs.getString("IDAccount");
				boolean State = rs.getBoolean("State");
				return new Staff(IDStaff,FullName,CCCD,IDAccount,State);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Staff selectByIDAccount(String idAccount) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Staff WHERE IDAccount = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idAccount);
			

			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			
			while(rs.next()) {
				String IDStaff = rs.getString("IDStaff");
				String FullName = rs.getString("FullName");
				String CCCD = rs.getString("CCCD");
				String IDAccount = rs.getString("IDAccount");
				boolean State = rs.getBoolean("State");
				return new Staff(IDStaff,FullName,CCCD,IDAccount,State);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
