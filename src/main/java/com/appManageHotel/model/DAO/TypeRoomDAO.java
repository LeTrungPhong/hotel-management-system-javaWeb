package com.appManageHotel.model.DAO;
import com.appManageHotel.model.BEAN.TypeRoom;

public interface TypeRoomDAO extends DAOInterface<TypeRoom>{
	public TypeRoom selectByTypeRoomName(String str);
	
	public TypeRoom selectByTypeRoomNameExceptID(String id, String typeroomname);
}