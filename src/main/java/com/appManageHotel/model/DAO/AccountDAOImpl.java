package com.appManageHotel.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.Account;

public class AccountDAOImpl implements AccountDAO{

	public static AccountDAOImpl getInstance() {
		return new AccountDAOImpl();
	}

	@Override
	public int insert(Account t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "INSERT INTO Account(IDAccount,UserName,PassWord,Role) "
					+ " VALUES (?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDAccount());
			pstmt.setString(2, t.getUserName());
			pstmt.setString(3, t.getPassWord());
			pstmt.setString(4, t.getRole());
			
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
	public int update(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String ID) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public ArrayList<Account> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Account selectByID(String ID) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			String sql = "SELECT * FROM Account WHERE IDAccount = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String IDAccount = rs.getString("IDAccount");
				String UserName = rs.getString("UserName");
				String PassWord = rs.getString("PassWord");
				String Role = rs.getString("Role");
				return (new Account(IDAccount, UserName, PassWord, Role));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<Account> selectByCondition(String Condition) {
		// TODO Auto-generated method stub
		
		try {
			ArrayList<Account> result = new ArrayList<>();
			Connection con = ConnectDatabase.getConnection();
			String sql = "SELECT * FROM Account WHERE " + Condition;
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        
	        while(rs.next()) {
				String IDAccount = rs.getString("IDAccount");
				String UserName = rs.getString("UserName");
				String PassWord = rs.getString("PassWord");
				String Role = rs.getString("Role");
				result.add(new Account(IDAccount,UserName,PassWord,Role));
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
	public Account selectByUserName(String username) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			String sql = "SELECT * FROM Account WHERE UserName = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String IDAccount = rs.getString("IDAccount");
				String UserName = rs.getString("UserName");
				String PassWord = rs.getString("PassWord");
				String Role = rs.getString("Role");
				return (new Account(IDAccount, UserName, PassWord, Role));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account selectByUserNameAndPassWord(String username, String password) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			String sql = "SELECT * FROM Account WHERE UserName = ? AND PassWord = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String IDAccount = rs.getString("IDAccount");
				String UserName = rs.getString("UserName");
				String PassWord = rs.getString("PassWord");
				String Role = rs.getString("Role");
				return (new Account(IDAccount, UserName, PassWord, Role));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
