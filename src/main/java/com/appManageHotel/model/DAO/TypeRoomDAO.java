package com.appManageHotel.model.DAO;
import java.util.ArrayList;

import com.appManageHotel.model.BEAN.TypeRoom;

public interface TypeRoomDAO extends DAOInterface<TypeRoom>{
	public TypeRoom selectByTypeRoomName(String str);
	
	public TypeRoom selectByTypeRoomNameExceptID(String id, String typeroomname);
	
	public ArrayList<TypeRoom> selectTypeRoomMaxPrice(int number);
	
	public ArrayList<TypeRoom> selectTypeRoomMinPrice(int number);
	
	public ArrayList<TypeRoom> selectTypeRoomMaxBooked(int number);
	
}