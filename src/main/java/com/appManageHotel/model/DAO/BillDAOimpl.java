package com.appManageHotel.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.Bill;

public class BillDAOimpl implements BillDAO {
	public static BillDAOimpl getInstance() {
		return new BillDAOimpl();
	}

	@Override
	public int insert(Bill t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "INSERT INTO Bill(IDBill,IDStaff,IDCustomer,Total, IDIFBookRoom) "
					+ " VALUES (?,?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDBill());
			pstmt.setString(2, t.getIDStaff());
			pstmt.setString(3, t.getIDCustomer());
			pstmt.setInt(4, t.getTotal());
			pstmt.setString(5, t.getIDIFBookRoom());
			
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
	public int update(Bill t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "UPDATE Bill"
					+ " SET IDStaff = ?,"
					+ " IDCustomer = ?," 
					+ " Total = ?,"
					+ " IDIFBookRoom = ?,"
					+ " WHERE IDBill = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDStaff());
			pstmt.setString(2, t.getIDCustomer());
			pstmt.setInt(3, t.getTotal());
			pstmt.setString(4, t.getIDIFBookRoom());
			pstmt.setString(5, t.getIDBill());
			
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
	public ArrayList<Bill> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill selectByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Bill> selectByCondition(String Condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
