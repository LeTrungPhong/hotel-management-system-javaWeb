package com.appManageHotel.model.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.ArrayList;

import com.appManageHotel.database.ConnectDatabase;

public class ChartBO {
	public static ChartBO getInstance() {
		return new ChartBO();
	}
	
	public ArrayList<Integer> statisticByYear(int year) {
		ArrayList<Integer> a=new ArrayList<Integer>();
		try {
			Connection con = ConnectDatabase.getConnection();
			for (int i=1;i<=12;i++) {
				String sql="select Prepayment from Bill where IDIFBookRoom in (Select IDIFBookRoom from IFBookRoom where Year(BookRoomDate)=? and Month(BookRoomDate)=?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, year);
				pstmt.setInt(2, i);
				ResultSet rs = pstmt.executeQuery();
				System.out.println("Thuc thi: " + pstmt.toString());
				int totalMonth=0;
				while (rs.next()) {
					totalMonth+= rs.getInt("Prepayment");	
				}
				a.add(totalMonth);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
		
	}
	
	public ArrayList<Integer> statisticByMonth(int month,int year) {
		ArrayList<Integer> a=new ArrayList<Integer>();
		try {
			Connection con = ConnectDatabase.getConnection();
			// Tạo đối tượng YearMonth với năm và tháng
	        YearMonth yearMonth = YearMonth.of(year, month);
	        // Lấy số ngày trong tháng
	        int daysInMonth = yearMonth.lengthOfMonth();
			for (int i = 1; i <= daysInMonth; i++) {
				String sql="select Prepayment from Bill where IDIFBookRoom in (Select IDIFBookRoom from IFBookRoom where Year(BookRoomDate)=? and Month(BookRoomDate)=? and Day(BookRoomDate)=?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, year);
				pstmt.setInt(2, month);
				pstmt.setInt(3, i);
				ResultSet rs = pstmt.executeQuery();
				System.out.println("Thuc thi: " + pstmt.toString());
				int totalDay=0;
				while (rs.next()) {
					totalDay+= rs.getInt("Prepayment");	
				}
				a.add(totalDay);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
		
	}
	
	public ArrayList<String> getTypeRoom(){
		ArrayList<String> a=new ArrayList<String>();
		try {
			Connection con = ConnectDatabase.getConnection();
				String sql="select TypeRoomName from TypeRoom";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				System.out.println("Thuc thi: " + pstmt.toString());
				while (rs.next()) {
					String typeRoomName= rs.getString("TypeRoomName");	
					a.add(typeRoomName);
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public ArrayList<Integer> StatisticNumberBook(){
		ArrayList<Integer> a=new ArrayList<Integer>();
		try {
			Connection con = ConnectDatabase.getConnection();
			ArrayList<String> b= getTypeRoom();
			for (int i = 0; i< b.size();i++) {
				String sql="select NumberBook from TypeRoom where TypeRoomName=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, b.get(i));

				ResultSet rs = pstmt.executeQuery();
				System.out.println("Thuc thi: " + pstmt.toString());
				while (rs.next()) {
					int numberBook = rs.getInt("NumberBook");	
					a.add(numberBook);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public ArrayList<Integer> StatisticByTypeRoom(){
		ArrayList<Integer> a=new ArrayList<Integer>();
		try {
			Connection con = ConnectDatabase.getConnection();
			ArrayList<String> b= getTypeRoom();
			for (int i=0; i < b.size(); i++) {
				String sql="select SUM(Prepayment) as Prepayment from Bill where IDIFBookRoom in (select IDIFBookRoom from IFBookRoom where IDRoom in (select IDRoom From Room where IDTypeRoom in (select IDTypeRoom from TypeRoom where TypeRoomName=?)))";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, b.get(i));

				ResultSet rs = pstmt.executeQuery();
				System.out.println("Thuc thi: " + pstmt.toString());
				int Pay=0;
				while (rs.next()) {
					Pay = rs.getInt("PrePayment");	
					a.add(Pay);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public ArrayList<String> getServiceName(){
		ArrayList<String> a=new ArrayList<String>();
		try {
			Connection con = ConnectDatabase.getConnection();
				String sql="select ServiceName from Service";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				System.out.println("Thuc thi: " + pstmt.toString());
				while (rs.next()) {
					String typeRoomName= rs.getString("ServiceName");	
					a.add(typeRoomName);
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public ArrayList<Integer> StatisticByService(){
		ArrayList<Integer> a = new ArrayList<Integer>();
		try {
			Connection con = ConnectDatabase.getConnection();
			ArrayList<String> b = getServiceName();
			for (int i = 0; i < b.size();i++) {
				String sql="select NumberUse from Service where ServiceName = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, b.get(i));

				ResultSet rs = pstmt.executeQuery();
				System.out.println("Thuc thi: " + pstmt.toString());
		
				while (rs.next()) {
					int n = rs.getInt("NumberUse");	
					a.add(n);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public ArrayList<Integer> MoneyOfService(){
		ArrayList<Integer> a = new ArrayList<Integer>();
		try {
			Connection con = ConnectDatabase.getConnection();
			ArrayList<String> b = getServiceName();
			for (int i = 0; i < b.size();i++) {
				String sql="select SUM(Total) AS Money FROM UseService JOIN Service ON UseService.IDService = Service.IDService WHERE ServiceName = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, b.get(i));

				ResultSet rs = pstmt.executeQuery();
				System.out.println("Thuc thi: " + pstmt.toString());
		
				while (rs.next()) {
					int n = rs.getInt("Money");	
					a.add(n);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
}
