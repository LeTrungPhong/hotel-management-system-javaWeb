package com.appManageHotel.model.BO;

import com.appManageHotel.model.BEAN.Room;
import com.appManageHotel.model.DAO.RoomDAOimpl;

public class RoomBO {

	public static RoomBO getInstance() {
		return new RoomBO();
	}
	public boolean InsertRoom(Room t) {
		Room f=RoomDAOimpl.getInstance().selectByRoomName(t.getRoomName());
		if (f != null) {
			return false;
		} else {
			RoomDAOimpl.getInstance().insert(t);
			return true;
		}
	}
	public boolean UpdateRoom(Room t, String newName) {
		Room f=RoomDAOimpl.getInstance().selectByRoomName(newName);
		if (f != null) {
			return false;
		} else {
			t.setRoomName(newName);
			RoomDAOimpl.getInstance().update(t);
			return true;
		}
	}
}
