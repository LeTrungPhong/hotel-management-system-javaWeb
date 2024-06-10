package com.appManageHotel.model.DAO;

import java.time.LocalDate;
import java.util.ArrayList;

import com.appManageHotel.model.BEAN.IFBookRoom;


public interface IFBookRoomDAO extends DAOInterface<IFBookRoom> {

	public ArrayList<IFBookRoom> selectByIDTypeRoom(String IDTypeRoom);
	
	public boolean checkRoomByTimeAndIDRoom(String IDRoom, LocalDate inn, LocalDate outt);
	
	public ArrayList<IFBookRoom> selectByStateAndCheckIn(boolean state, boolean checkIn);
	
	public IFBookRoom selectByIDRoomToExtend(String idRoom,LocalDate end, LocalDate out);
	
}
