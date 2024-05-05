package com.appManageHotel.model.BO;

import com.appManageHotel.model.BEAN.ImageTypeRoom;
import com.appManageHotel.model.BEAN.TypeRoom;
import com.appManageHotel.model.DAO.ImageTypeRoomDAOimpl;
import com.appManageHotel.model.DAO.TypeRoomDAOimpl;

public class TypeRoomBO {
	
	public static TypeRoomBO getInstance() {
		return new TypeRoomBO();
	}
	
	public boolean insertTypeRoom(TypeRoom t, String[] IDImages) {
		if(TypeRoomDAOimpl.getInstance().selectByTypeRoomName(t.getTypeRoomName()) == null) {
			TypeRoomDAOimpl.getInstance().insert(t);
			for(String IDImage : IDImages) {
				ImageTypeRoomDAOimpl.getInstance().insert(new ImageTypeRoom(IDImage, t.getIDTypeRoom()));
			}
			return true;
		}
		return false;
	}
	
	public boolean updateTypeRoom(TypeRoom t, String[] IDImages) {
		if(TypeRoomDAOimpl.getInstance().selectByTypeRoomNameExceptID(t.getIDTypeRoom(), t.getTypeRoomName()) == null) {
			TypeRoomDAOimpl.getInstance().update(t);
			ImageTypeRoomDAOimpl.getInstance().deleteByIDTypeRoom(t.getIDTypeRoom());
			for(String IDImage : IDImages) {
				ImageTypeRoomDAOimpl.getInstance().insert(new ImageTypeRoom(IDImage, t.getIDTypeRoom()));
			}
			return true;
		} else {
			return false;
		}
	}
}
