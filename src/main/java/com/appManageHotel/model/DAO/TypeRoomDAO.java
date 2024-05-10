package com.appManageHotel.model.DAO;
import java.time.LocalDate;
import java.util.ArrayList;

import com.appManageHotel.model.BEAN.TypeRoom;

public interface TypeRoomDAO extends DAOInterface<TypeRoom>{
	public TypeRoom selectByTypeRoomName(String str);
	
	public TypeRoom selectByTypeRoomNameExceptID(String id, String typeroomname);
	
	public ArrayList<TypeRoom> selectTypeRoomMaxPrice(int number);
	
	public ArrayList<TypeRoom> selectTypeRoomMinPrice(int number);
	
	public ArrayList<TypeRoom> selectTypeRoomMaxBooked(int number);
	
	public ArrayList<String> selectIDTypeRoomByTime(LocalDate timeIn, LocalDate timeOut);
	
	public ArrayList<String> selectIDTypeRoomByPriceAndNumberPeople(int minPrice, int maxPrice, int maxAdult, int maxChild);
	
	public ArrayList<String> selectIDTypeRoomByIDTypeRoomAndPriceAndNumberPeople(String[] listIDTypeRoom, int minPrice, int maxPrice, int maxAdult, int maxChild);

	public int selectPriceByIDTypeRoom(String IDTypeRoom);
}