package com.appManageHotel.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.Customer;

public class CustomerDAOimpl implements CustomerDAO{
	
	public static CustomerDAOimpl getInstance() {
		return new CustomerDAOimpl();
	}

	@Override
	public int insert(Customer t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "INSERT INTO Customer(IDCustomer,CCCD,FullName,Birth,SDT,IDAccount,Gender)"
					+ " VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDCustomer());
			pstmt.setString(2, t.getCCCD());
			pstmt.setString(3, t.getFullName());
			pstmt.setDate(4, java.sql.Date.valueOf(LocalDate.of(2004, 2, 11))); 
			pstmt.setString(5, t.getSDT());
			pstmt.setString(6, t.getIDAccount());
			pstmt.setString(7, t.getGender());
			
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
	public int update(Customer t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "UPDATE Customer"
					+ " SET CCCD = ?,"
					+ " FullName = ?," 
					+ " Birth = ?,"
					+ " SDT = ?,"
					+ " IDAccount = ?,"
					+ " Gender = ?"
					+ " WHERE IDCustomer = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getCCCD());
			pstmt.setString(2, t.getFullName());
			pstmt.setDate(3, java.sql.Date.valueOf(t.getBirth()));
			pstmt.setString(4, t.getSDT());
			pstmt.setString(5, t.getIDAccount());
			pstmt.setString(6, t.getGender());
			pstmt.setString(7, t.getIDCustomer());
			
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
	public ArrayList<Customer> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer selectByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Customer> selectByCondition(String Condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer selectByIDAccount(String ID) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Customer WHERE IDAccount = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			

			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			
			while(rs.next()) {
				String IDCustomer = rs.getString("IDCustomer");
				String FullName = rs.getString("FullName");
				String CCCD = rs.getString("CCCD");
				String Gender = rs.getString("Gender");
				String SDT = rs.getString("SDT");
				String IDAccount = rs.getString("IDAccount");
				LocalDate Birth = rs.getDate("Birth").toLocalDate();
				return new Customer(IDCustomer,FullName,CCCD,Gender,SDT,Birth,IDAccount);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer selectByCCCD(String IDCard) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Customer WHERE CCCD = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, IDCard);
			

			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			
			while(rs.next()) {
				String IDCustomer = rs.getString("IDCustomer");
				String FullName = rs.getString("FullName");
				String CCCD = rs.getString("CCCD");
				String Gender = rs.getString("Gender");
				String SDT = rs.getString("SDT");
				String IDAccount = rs.getString("IDAccount");
				LocalDate Birth = rs.getDate("Birth").toLocalDate();
				return new Customer(IDCustomer,FullName,CCCD,Gender,SDT,Birth,IDAccount);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer selectByCCCDAndDifferentIDCard(String ID, String IDCard) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM Customer WHERE IDAccount != ? AND CCCD = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			pstmt.setString(2, IDCard);
			

			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			
			while(rs.next()) {
				String IDCustomer = rs.getString("IDCustomer");
				String FullName = rs.getString("FullName");
				String CCCD = rs.getString("CCCD");
				String Gender = rs.getString("Gender");
				String SDT = rs.getString("SDT");
				String IDAccount = rs.getString("IDAccount");
				LocalDate Birth = rs.getDate("Birth").toLocalDate();
				return new Customer(IDCustomer,FullName,CCCD,Gender,SDT,Birth,IDAccount);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
