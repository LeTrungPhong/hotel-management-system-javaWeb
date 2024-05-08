package com.appManageHotel.model.DAO;

import java.util.ArrayList;

import com.appManageHotel.model.BEAN.ImageTypeRoom;

public interface ImageTypeRoomDAO extends DAOInterface<ImageTypeRoom>{
	public int deleteByIDTypeRoom(String ID);
	
	public ArrayList<ImageTypeRoom> selectByIDTypeRoom(String id);
}
