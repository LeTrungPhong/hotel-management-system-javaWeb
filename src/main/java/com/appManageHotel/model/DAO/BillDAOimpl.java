package com.appManageHotel.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			
			String sql = "INSERT INTO Bill(IDBill,IDStaff,IDCustomer,Total, IDIFBookRoom, Prepayment) "
					+ " VALUES (?,?,?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDBill());
			pstmt.setString(2, t.getIDStaff());
			pstmt.setString(3, t.getIDCustomer());
			pstmt.setInt(4, t.getTotal());
			pstmt.setString(5, t.getIDIFBookRoom());
			pstmt.setInt(6, t.getPrepayment());
			
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
					+ " Prepayment = ?"
					+ " WHERE IDBill = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDStaff());
			pstmt.setString(2, t.getIDCustomer());
			pstmt.setInt(3, t.getTotal());
			pstmt.setString(4, t.getIDIFBookRoom());
			pstmt.setInt(5, t.getPrepayment());
			pstmt.setString(6,t.getIDBill());
			
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

	@Override
	public ArrayList<Bill> selectByIDCustomer(String id) {
		// TODO Auto-generated method stub
		try {
			ArrayList<Bill> result = new ArrayList<Bill>();
			Connection con = ConnectDatabase.getConnection();
			String sql = "SELECT * FROM Bill WHERE IDCustomer = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String IDBill = rs.getString("IDBill");
				String IDStaff = rs.getString("IDStaff");
				String IDCustomer = rs.getString("IDCustomer");
				int Total = rs.getInt("Total");
				String IDIFBookRoom = rs.getString("IDIFBookRoom");
				int Prepayment = rs.getInt("Prepayment");
				result.add(new Bill(IDBill, IDStaff, IDCustomer,Prepayment, Total, IDIFBookRoom));
			}
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Bill selectByIDIFBookRoom(String idIFBookRoom) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			String sql = "SELECT * FROM Bill WHERE IDIFBookRoom = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idIFBookRoom);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String IDBill = rs.getString("IDBill");
				String IDStaff = rs.getString("IDStaff");
				String IDCustomer = rs.getString("IDCustomer");
				int Total = rs.getInt("Total");
				String IDIFBookRoom = rs.getString("IDIFBookRoom");
				int Prepayment = rs.getInt("Prepayment");
				return (new Bill(IDBill, IDStaff, IDCustomer,Prepayment, Total, IDIFBookRoom));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Bill> selectByIDCustomerComeInDateDESC(String idCustomer) {
		// TODO Auto-generated method stub
		try {
			ArrayList<Bill> result = new ArrayList<Bill>();
			Connection con = ConnectDatabase.getConnection();
			String sql = "SELECT * FROM Bill JOIN IFBookRoom ON Bill.IDIFBookRoom = IFBookRoom.IDIFBookRoom "
					+ " WHERE Bill.IDCustomer = ? "
					+ " ORDER BY IFBookRoom.ComeInDate DESC ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idCustomer);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String IDBill = rs.getString("IDBill");
				String IDStaff = rs.getString("IDStaff");
				String IDCustomer = rs.getString("IDCustomer");
				int Total = rs.getInt("Total");
				String IDIFBookRoom = rs.getString("IDIFBookRoom");
				int Prepayment = rs.getInt("Prepayment");
				result.add(new Bill(IDBill, IDStaff, IDCustomer,Prepayment, Total, IDIFBookRoom));
			}
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

