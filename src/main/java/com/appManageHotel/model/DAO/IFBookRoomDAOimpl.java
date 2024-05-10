package com.appManageHotel.model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.IFBookRoom;

public class IFBookRoomDAOimpl implements IFBookRoomDAO {

	public static IFBookRoomDAOimpl getInstance() {
		return new IFBookRoomDAOimpl();
	}
	@Override
	public int insert(IFBookRoom t) {
		// TODO Auto-generated method stub
		try {
			Connection c=ConnectDatabase.getConnection();
			String sql="INSERT INTO IFBookRoom (IDIFBookRoom, IDRoom, ComeInDate, ComeOutDate, NumberAdult, NumberChild) "
					+ "VALUES (?,?,?,?,?,?)";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, t.getIDIFBookRoom());
			pstmt.setString(2, t.getIDRoom());
			pstmt.setDate(3, Date.valueOf(t.getComeInDate()));
			pstmt.setDate(4, Date.valueOf(t.getComeOutDate()));
			pstmt.setInt(5, t.getNumberAdult());
			pstmt.setInt(6, t.getNumberChild());
			
			int kq=pstmt.executeUpdate();
			System.out.println("Thuc thi: " + sql);
			System.out.println("Co" + kq + "Ket qua thay doi");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(IFBookRoom t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "UPDATE IFBookRoom"
					+ " SET IDRoom = ?"
					+ "	ComeInDate = ?"
					+ "	ComeOutDate = ?"
					+ "	NumberAdult = ?"
					+ "	NumberChild = ?"
					+ " WHERE IDIFBookRoom = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDRoom());
			pstmt.setDate(2, Date.valueOf(t.getComeInDate()));
			pstmt.setDate(3, Date.valueOf(t.getComeOutDate()));
			pstmt.setInt(4, t.getNumberAdult());
			pstmt.setInt(5, t.getNumberChild());
			pstmt.setString(6, t.getIDIFBookRoom());
			
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
		try {
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "DELETE FROM IFBookRoom"
					+ " WHERE IDIFBookRoom = ?";
			
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
	public ArrayList<IFBookRoom> selectAll() {
		// TODO Auto-generated method stub
		try {
			ArrayList<IFBookRoom> result = new ArrayList<IFBookRoom>(); 
			
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM IFBookRoom";
			
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String IDIFBookRoom=rs.getString("IDIFBookRoom");
				String IDRoom=rs.getString("IDRoom");
				LocalDate dayin= rs.getDate("ComeInDate").toLocalDate();
				LocalDate dayout=rs.getDate("ComeOutDate").toLocalDate();
				int nA=rs.getInt("NumberAdult");
				int nC=rs.getInt("NumberChild");
				result.add(new IFBookRoom(IDIFBookRoom, IDRoom, dayin, dayout, nA, nC));
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
	public IFBookRoom selectByID(String ID) {
		// TODO Auto-generated method stub
		try {
			IFBookRoom result = null ;
			
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM IFBookRoom where IDIFBookRoom=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String IDIFBookRoom=rs.getString("IDIFBookRoom");
				String IDRoom=rs.getString("IDRoom");
				LocalDate dayin= rs.getDate("ComeInDate").toLocalDate();
				LocalDate dayout=rs.getDate("ComeOutDate").toLocalDate();
				int nA=rs.getInt("NumberAdult");
				int nC=rs.getInt("NumberChild");
				result=new IFBookRoom(IDIFBookRoom, IDRoom, dayin, dayout, nA, nC);
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
	public ArrayList<IFBookRoom> selectByCondition(String Condition) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<IFBookRoom> selectByIDTypeRoom(String IDTypeRoom){
		try {
			ArrayList<IFBookRoom> result = new ArrayList<IFBookRoom>(); 
			
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM IFBookRoom where IDRoom in (select IDRoom from Room where IDTypeRoom=?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String IDIFBookRoom=rs.getString("IDIFBookRoom");
				String IDRoom=rs.getString("IDRoom");
				LocalDate dayin= rs.getDate("ComeInDate").toLocalDate();
				LocalDate dayout=rs.getDate("ComeOutDate").toLocalDate();
				int nA=rs.getInt("NumberAdult");
				int nC=rs.getInt("NumberChild");
				result.add(new IFBookRoom(IDIFBookRoom, IDRoom, dayin, dayout, nA, nC));
			}
			
			System.out.println("Thuc thi: " + pstmt.toString());
			return result;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
