package com.appManageHotel.model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.UseService;

public class UseServiceDAOimpl implements UseServiceDAO{
	
	public static UseServiceDAOimpl getInstance() {
		return new UseServiceDAOimpl();
	}

	@Override
	public int insert(UseService t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "INSERT INTO UseService(IDUseService,IDService,UseDate,IDCustomer,Number,State,Total) "
					+ " VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDUseService());
			pstmt.setString(2, t.getIDService());
			pstmt.setDate(3, java.sql.Date.valueOf(t.getUseDate()));
			pstmt.setString(4, t.getIDCustomer());
			pstmt.setInt(5, t.getNumber());
			pstmt.setBoolean(6, t.isState());
			pstmt.setInt(7, t.getTotal());
			
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
	public int update(UseService t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "UPDATE UseService"
					+ " SET IDService = ?,"
					+ " UseDate = ?," 
					+ " IDCustomer = ?,"
					+ " Number = ?,"
					+ " State = ?,"
					+ " Total = ?"
					+ " WHERE IDUseService = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDService());
			pstmt.setDate(2, Date.valueOf(t.getUseDate()));
			pstmt.setString(3, t.getIDCustomer());
			pstmt.setInt(4, t.getNumber());
			pstmt.setBoolean(5, t.isState());
			pstmt.setInt(6, t.getTotal());
			pstmt.setString(7, t.getIDUseService());
			
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
	public ArrayList<UseService> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UseService selectByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UseService> selectByCondition(String Condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
