package com.appManageHotel.model.DAO;

import java.util.ArrayList;

import com.appManageHotel.model.BEAN.Room;

public interface RoomDAO extends DAOInterface<Room>{
	public ArrayList<Room> selectByIDTypeRoom(String ID);

	public Room selectByRoomName(String name); 
	
	public int selectPriceByIDRoom(String IDRoom);
}
