package com.appManageHotel.model.DAO;

import java.util.ArrayList;

import com.appManageHotel.model.BEAN.IFBookRoom;


public interface IFBookRoomDAO extends DAOInterface<IFBookRoom> {

	public ArrayList<IFBookRoom> selectByIDTypeRoom(String IDTypeRoom);

}
