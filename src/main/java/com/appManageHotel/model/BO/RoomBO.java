package com.appManageHotel.model.BO;

import java.time.LocalDate;
import java.util.ArrayList;
import com.appManageHotel.model.BEAN.Room;
import com.appManageHotel.model.BEAN.TypeRoom;
import com.appManageHotel.model.DAO.RoomDAOimpl;
import com.appManageHotel.model.DAO.TypeRoomDAOimpl;

public class RoomBO {

	public static RoomBO getInstance() {
		return new RoomBO();
	}
	
	public boolean InsertRoom(Room t) {
		Room f = RoomDAOimpl.getInstance().selectByRoomName(t.getRoomName());
		if (f != null) {
			return false;
		} else {
			RoomDAOimpl.getInstance().insert(t);
			return true;
		}
	}
	
	public boolean UpdateRoom(String IDRoom, String newName) {
		Room f = RoomDAOimpl.getInstance().selectByRoomName(newName);
		if (f != null) {
			return false;
		} else {
			Room r = RoomDAOimpl.getInstance().selectByID(IDRoom);
			r.setRoomName(newName);
			RoomDAOimpl.getInstance().update(r);
			return true;
		}
	}
	
	public ArrayList<String> FindRoomByCondition(String[] typeRoom,int PriceMin, int PriceMax,int maxAdult,int maxChild) {
		if(typeRoom == null) {
			return TypeRoomDAOimpl.getInstance().selectIDTypeRoomByPriceAndNumberPeople(PriceMin, PriceMax, maxAdult, maxChild);
		} else {
			return TypeRoomDAOimpl.getInstance().selectIDTypeRoomByIDTypeRoomAndPriceAndNumberPeople(typeRoom, PriceMin, PriceMax, maxAdult, maxChild);
		}
	}
	
	public ArrayList<String> FindRoomFree(LocalDate inn, LocalDate outt){
		if(inn == null || outt == null) {
			ArrayList<TypeRoom> allTypeRoom = TypeRoomDAOimpl.getInstance().selectAll();
			ArrayList<String> listIDTypeRoom = new ArrayList<String>();
			for(TypeRoom i : allTypeRoom) {
				listIDTypeRoom.add(i.getIDTypeRoom());
			}
			return listIDTypeRoom;
		} else {
			return TypeRoomDAOimpl.getInstance().selectIDTypeRoomByTime(inn, outt);
		}
	}
	
	public ArrayList<TypeRoom> findRoom(int MinPrice, int MaxPrice, int maxAdult, int maxChild, LocalDate timeStart, LocalDate timeEnd, String[] listTypeRoomName){
		
		if(MinPrice == 0 && MaxPrice == 0 && maxAdult == 0 && maxChild == 0 && timeStart == null && timeEnd == null && listTypeRoomName == null) {
			return TypeRoomDAOimpl.getInstance().selectAll();
		}
		
		ArrayList<String> idTypeRoomCondition = FindRoomByCondition(listTypeRoomName, MinPrice, MaxPrice, maxAdult, maxChild);
		
		if(idTypeRoomCondition != null) {
			for(String s : idTypeRoomCondition) {
				System.out.println(s);
			}
		}
		
		ArrayList<String> idTypeRoomFree = FindRoomFree(
				timeStart != null ? timeStart : null, 
				timeEnd != null ? timeEnd : null);
		
		if(idTypeRoomFree != null) {
			for(String s : idTypeRoomFree) {
				System.out.println(s);
			}
		}
		
		ArrayList<String> mergedList = new ArrayList<>();
		if(idTypeRoomCondition != null && idTypeRoomFree != null) {
			for(String str1 : idTypeRoomCondition) {
				for(String str2 : idTypeRoomFree) {
					if(str1.equals(str2)) {
						mergedList.add(str1);
					}
				}
			}
		}
		
		ArrayList<TypeRoom> listTypeRoom = new ArrayList<TypeRoom>();
		if(mergedList != null) {
			for(int i = 0; i < mergedList.size(); ++i) {
				listTypeRoom.add(TypeRoomDAOimpl.getInstance().selectByID(mergedList.get(i)));
			}
		}
		
		return listTypeRoom;
	}
}
