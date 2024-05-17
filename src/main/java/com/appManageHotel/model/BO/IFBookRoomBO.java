package com.appManageHotel.model.BO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.Bill;
import com.appManageHotel.model.BEAN.Customer;
import com.appManageHotel.model.BEAN.IFBookRoom;
import com.appManageHotel.model.DAO.BillDAOimpl;
import com.appManageHotel.model.DAO.CustomerDAOimpl;
import com.appManageHotel.model.DAO.IFBookRoomDAOimpl;
import com.appManageHotel.model.DAO.RoomDAOimpl;

public class IFBookRoomBO {
	
	public static IFBookRoomBO getInstance() {
		return new IFBookRoomBO();
	}
	
	public boolean bookRoom(IFBookRoom t,String IDTypeRoom,Customer r, int totalBill, int PrepaymentBill) {
		try {
			Connection con = ConnectDatabase.getConnection();
			String sql="select IDRoom from Room where IDTypeRoom=? except select IDRoom from IFBookRoom where (?<=ComeInDate and ComeInDate<=?) or (?<=ComeOutDate and ComeOutDate<=?) or (ComeInDate<=? and ComeOutDate>=?)  ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, IDTypeRoom);
			pstmt.setDate(2, Date.valueOf(t.getComeInDate()));
			pstmt.setDate(3, Date.valueOf(t.getComeOutDate()));
			pstmt.setDate(4, Date.valueOf(t.getComeInDate()));
			pstmt.setDate(5, Date.valueOf(t.getComeOutDate()));
			pstmt.setDate(6, Date.valueOf(t.getComeInDate()));
			pstmt.setDate(7, Date.valueOf(t.getComeOutDate()));
			
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			if (rs.next()) {
				String IDRoom=rs.getString("IDRoom");
				t.setIDRoom(IDRoom);
				
			}
			else return false;
			IFBookRoomDAOimpl.getInstance().insert(t);
			CustomerDAOimpl.getInstance().insert(r);
			String id = UUID.randomUUID().toString();
			Bill b = new Bill(id, "Staffweb", r.getIDCustomer(),PrepaymentBill, totalBill, t.getIDIFBookRoom());
			BillDAOimpl.getInstance().insert(b);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean bookRoomByAccount(IFBookRoom t,String IDTypeRoom,Customer r, int totalBill, int PrepaymentBill) {
		try {
			Connection con = ConnectDatabase.getConnection();
			String sql="select IDRoom from Room where IDTypeRoom=? except select IDRoom from IFBookRoom where (?<=ComeInDate and ComeInDate<=?) or (?<=ComeOutDate and ComeOutDate<=?) or (ComeInDate<=? and ComeOutDate>=?)  ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, IDTypeRoom);
			pstmt.setDate(2, Date.valueOf(t.getComeInDate()));
			pstmt.setDate(3, Date.valueOf(t.getComeOutDate()));
			pstmt.setDate(4, Date.valueOf(t.getComeInDate()));
			pstmt.setDate(5, Date.valueOf(t.getComeOutDate()));
			pstmt.setDate(6, Date.valueOf(t.getComeInDate()));
			pstmt.setDate(7, Date.valueOf(t.getComeOutDate()));

			
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Thuc thi: " + pstmt.toString());
			if (rs.next()) {
				String IDRoom=rs.getString("IDRoom");
				t.setIDRoom(IDRoom);
			}
			else return false;
			IFBookRoomDAOimpl.getInstance().insert(t);
			String id = UUID.randomUUID().toString();
			Bill b = new Bill(id, "Staffweb", r.getIDCustomer(),PrepaymentBill, totalBill, t.getIDIFBookRoom());
			BillDAOimpl.getInstance().insert(b);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	public void cancelling(IFBookRoom t) {
		t.setState(false);
		IFBookRoomDAOimpl.getInstance().update(t);
	}
	
	public ArrayList<IFBookRoom> findByTime(LocalDate inn, LocalDate outt){
		try {
			ArrayList<IFBookRoom> result = new ArrayList<IFBookRoom>();
			Connection con = ConnectDatabase.getConnection();
			String sql = "SELECT * FROM IFBookRoom WHERE (ComeInDate <= ? AND ComeOutDate >= ?) OR (ComeInDate >= ? AND ComeInDate <= ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, Date.valueOf(inn));
			pstmt.setDate(2, Date.valueOf(inn));
			pstmt.setDate(3, Date.valueOf(inn));
			pstmt.setDate(4, Date.valueOf(outt));
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String IDIFBookRoom = rs.getString("IDIFBookRoom");
				String IDRoom = rs.getString("IDRoom");
				LocalDate dayin = rs.getDate("ComeInDate").toLocalDate();
				LocalDate dayout =rs.getDate("ComeOutDate").toLocalDate();
				int nA = rs.getInt("NumberAdult");
				int nC = rs.getInt("NumberChild");
				boolean state = rs.getBoolean("State");
				boolean CheckIn = rs.getBoolean("CheckIn");
				result.add(new IFBookRoom(IDIFBookRoom, IDRoom, dayin, dayout, nA, nC,state,CheckIn));
			}
			return result;
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<IFBookRoom> findIFBookRoom(int MinPrice, int MaxPrice, int maxAdult, int maxChild, LocalDate inn, LocalDate outt, String[] listTypeRoomName){
		inn = inn != null ? inn : LocalDate.now();
		outt = outt != null ? outt : LocalDate.now().plusDays(1);
		
		ArrayList<String> listIDTypeRoomCondition = TypeRoomBO.getInstance().FindIDTypeRoomByCondition(listTypeRoomName, MinPrice, MaxPrice, maxAdult, maxChild);
		
		ArrayList<IFBookRoom> listIFBookRoom = findByTime(inn, outt);
		
		ArrayList<IFBookRoom> listIF = new ArrayList<IFBookRoom>();
		
		if(listIFBookRoom != null) {
			for(int i = 0; i < listIFBookRoom.size(); ++i) {
				if(listIDTypeRoomCondition != null) {
					for(int j = 0; j < listIDTypeRoomCondition.size(); ++j) {
						if(listIDTypeRoomCondition.get(j).equals(RoomDAOimpl.getInstance().selectByID(listIFBookRoom.get(i).getIDRoom()).getIDTypeRoom())) {
							listIF.add(listIFBookRoom.get(i));
							break;
						}
					}
				}
			}
		}
		
		return listIF;
	}
	
	public boolean bookRoomStaff(IFBookRoom ifBookRoom, Customer customer, String IDStaff, int pre, int total) {
		if(IFBookRoomDAOimpl.getInstance().checkRoomByTimeAndIDRoom(ifBookRoom.getIDRoom(), ifBookRoom.getComeInDate(), ifBookRoom.getComeOutDate())) {
			Customer cusTemp = CustomerDAOimpl.getInstance().selectByCCCD(customer.getCCCD());
			String IDBill = UUID.randomUUID().toString();
			if(cusTemp != null) {
				IFBookRoomDAOimpl.getInstance().insert(ifBookRoom);
				BillDAOimpl.getInstance().insert(new Bill(IDBill,IDStaff,cusTemp.getIDCustomer(),pre,total,ifBookRoom.getIDIFBookRoom()));
				return true;
			} else {
				CustomerDAOimpl.getInstance().insert(customer);
				IFBookRoomDAOimpl.getInstance().insert(ifBookRoom);
				BillDAOimpl.getInstance().insert(new Bill(IDBill,IDStaff,customer.getIDCustomer(),pre,total,ifBookRoom.getIDIFBookRoom()));
				return true;
			}
		} else {
			return false;
		}
	}
}