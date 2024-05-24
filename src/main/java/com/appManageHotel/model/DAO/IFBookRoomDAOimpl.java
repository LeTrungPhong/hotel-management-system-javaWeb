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
			String sql="INSERT INTO IFBookRoom (IDIFBookRoom, IDRoom, ComeInDate, ComeOutDate, NumberAdult, NumberChild, State, CheckIn, ComeInDateReal, ComeOutDateReal, BookRoomDate) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, t.getIDIFBookRoom());
			pstmt.setString(2, t.getIDRoom());
			pstmt.setDate(3, Date.valueOf(t.getComeInDate()));
			pstmt.setDate(4, Date.valueOf(t.getComeOutDate()));
			pstmt.setInt(5, t.getNumberAdult());
			pstmt.setInt(6, t.getNumberChild());
			pstmt.setBoolean(7, t.isState());
			pstmt.setBoolean(8, t.getCheckIn());
			pstmt.setDate(9, t.getComeInDateReal() != null ? Date.valueOf(t.getComeInDateReal()) : null);
			pstmt.setDate(10, t.getComeOutDateReal() != null ? Date.valueOf(t.getComeOutDateReal()) : null);
			pstmt.setDate(11, t.getBookRoomDate() != null ? Date.valueOf(t.getBookRoomDate()) : null);
			
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
					+ " SET IDRoom = ?,"
					+ "	ComeInDate = ?,"
					+ "	ComeOutDate = ?,"
					+ "	NumberAdult = ?,"
					+ "	NumberChild = ?,"
					+ " State = ?,"
					+ " CheckIn = ?,"
					+ " ComeInDateReal = ?,"
					+ " ComeOutDateReal = ?,"
					+ " BookRoomDate = ?"
					+ " WHERE IDIFBookRoom = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getIDRoom());
			pstmt.setDate(2, Date.valueOf(t.getComeInDate()));
			pstmt.setDate(3, Date.valueOf(t.getComeOutDate()));
			pstmt.setInt(4, t.getNumberAdult());
			pstmt.setInt(5, t.getNumberChild());
			pstmt.setBoolean(6, t.isState());
			pstmt.setBoolean(7, t.getCheckIn());
			pstmt.setDate(8, t.getComeInDateReal() != null ? Date.valueOf(t.getComeInDateReal()) : null);
			pstmt.setDate(9, t.getComeOutDateReal() != null ? Date.valueOf(t.getComeOutDateReal()) : null);
			pstmt.setDate(10, t.getBookRoomDate() != null ? Date.valueOf(t.getBookRoomDate()) : null);
			pstmt.setString(11, t.getIDIFBookRoom());
			
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
				boolean state = rs.getBoolean("State");
				boolean check=rs.getBoolean("CheckIn");
				LocalDate ComeInDateReal = rs.getDate("ComeInDateReal") != null ? rs.getDate("ComeInDateReal").toLocalDate() : null;
				LocalDate ComeOutDateReal = rs.getDate("ComeOutDateReal") != null ? rs.getDate("ComeOutDateReal").toLocalDate() : null;
				LocalDate BookRoomDate = rs.getDate("BookRoomDate") != null ? rs.getDate("BookRoomDate").toLocalDate() : null;
				result.add(new IFBookRoom(IDIFBookRoom, IDRoom, dayin, dayout, nA, nC, state, check, ComeInDateReal, ComeOutDateReal, BookRoomDate));
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
			Connection con = ConnectDatabase.getConnection();
			
			String sql = "SELECT * FROM IFBookRoom where IDIFBookRoom = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			
			while(rs.next()) {
				String IDIFBookRoom=rs.getString("IDIFBookRoom");
				String IDRoom=rs.getString("IDRoom");
				LocalDate dayin= rs.getDate("ComeInDate").toLocalDate();
				LocalDate dayout=rs.getDate("ComeOutDate").toLocalDate();
				int nA=rs.getInt("NumberAdult");
				int nC=rs.getInt("NumberChild");
				boolean state = rs.getBoolean("State");
				boolean check=rs.getBoolean("CheckIn");
				LocalDate ComeInDateReal = rs.getDate("ComeInDateReal") != null ? rs.getDate("ComeInDateReal").toLocalDate() : null;
				LocalDate ComeOutDateReal = rs.getDate("ComeOutDateReal") != null ? rs.getDate("ComeOutDateReal").toLocalDate() : null;
				LocalDate BookRoomDate = rs.getDate("BookRoomDate") != null ? rs.getDate("BookRoomDate").toLocalDate() : null;
				return new IFBookRoom(IDIFBookRoom, IDRoom, dayin, dayout, nA, nC,state,check, ComeInDateReal, ComeOutDateReal, BookRoomDate);
			}
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
				boolean state = rs.getBoolean("State");
				boolean check=rs.getBoolean("CheckIn");
				LocalDate ComeInDateReal = rs.getDate("ComeInDateReal") != null ? rs.getDate("ComeInDateReal").toLocalDate() : null;
				LocalDate ComeOutDateReal = rs.getDate("ComeOutDateReal") != null ? rs.getDate("ComeOutDateReal").toLocalDate() : null;
				LocalDate BookRoomDate = rs.getDate("BookRoomDate") != null ? rs.getDate("BookRoomDate").toLocalDate() : null;
				result.add(new IFBookRoom(IDIFBookRoom, IDRoom, dayin, dayout, nA, nC,state,check, ComeInDateReal, ComeOutDateReal, BookRoomDate));
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
	public boolean checkRoomByTimeAndIDRoom(String IDRoom, LocalDate inn, LocalDate outt) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDatabase.getConnection();
			String sql = "SELECT * FROM IFBookRoom WHERE IDRoom = ? AND ((ComeInDate >= ? AND ComeInDate <= ?) OR (ComeOutDate > ? AND ComeInDate <= ?))";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, IDRoom);
			pstmt.setDate(2, Date.valueOf(inn));
			pstmt.setDate(3, Date.valueOf(outt));
			pstmt.setDate(4, Date.valueOf(inn));
			pstmt.setDate(5, Date.valueOf(inn));
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			while(rs.next()) {
				return false;
			}
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		return true;
	}
	@Override
	public ArrayList<IFBookRoom> selectByStateAndCheckIn(boolean stateInput, boolean checkInInput) {
		// TODO Auto-generated method stub
		try {
			ArrayList<IFBookRoom> result = new ArrayList<IFBookRoom>(); 
			Connection con = ConnectDatabase.getConnection();
			String sql = "SELECT * FROM IFBookRoom WHERE State = ? AND CheckIn = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setBoolean(1, stateInput);
			pstmt.setBoolean(2, checkInInput);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			while(rs.next()) {
				String IDIFBookRoom = rs.getString("IDIFBookRoom");
				String IDRoom = rs.getString("IDRoom");
				LocalDate dayin = rs.getDate("ComeInDate").toLocalDate();
				LocalDate dayout = rs.getDate("ComeOutDate").toLocalDate();
				int nA = rs.getInt("NumberAdult");
				int nC = rs.getInt("NumberChild");
				boolean state = rs.getBoolean("State");
				boolean check = rs.getBoolean("CheckIn");
				LocalDate ComeInDateReal = rs.getDate("ComeInDateReal") != null ? rs.getDate("ComeInDateReal").toLocalDate() : null;
				LocalDate ComeOutDateReal = rs.getDate("ComeOutDateReal") != null ? rs.getDate("ComeOutDateReal").toLocalDate() : null;
				LocalDate BookRoomDate = rs.getDate("BookRoomDate") != null ? rs.getDate("BookRoomDate").toLocalDate() : null;
				result.add(new IFBookRoom(IDIFBookRoom, IDRoom, dayin, dayout, nA, nC,state,check, ComeInDateReal, ComeOutDateReal, BookRoomDate));
			}
			return result;
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
}