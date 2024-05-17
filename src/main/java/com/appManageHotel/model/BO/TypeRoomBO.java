package com.appManageHotel.model.BO;

import java.time.LocalDate;
import java.util.ArrayList;

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
	
	public ArrayList<String> FindIDTypeRoomByCondition(String[] typeRoom,int PriceMin, int PriceMax,int maxAdult,int maxChild) {
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
	
	public ArrayList<TypeRoom> findTypeRoom(int MinPrice, int MaxPrice, int maxAdult, int maxChild, LocalDate timeStart, LocalDate timeEnd, String[] listTypeRoomName){
		
		if(MinPrice == 0 && MaxPrice == 0 && maxAdult == 0 && maxChild == 0 && timeStart == null && timeEnd == null && listTypeRoomName == null) {
			return TypeRoomDAOimpl.getInstance().selectAll();
		}
		
		ArrayList<String> idTypeRoomCondition = FindIDTypeRoomByCondition(listTypeRoomName, MinPrice, MaxPrice, maxAdult, maxChild);
		
//		if(idTypeRoomCondition != null) {
//			for(String s : idTypeRoomCondition) {
//				System.out.println(s);
//			}
//		}
		
		ArrayList<String> idTypeRoomFree = FindRoomFree(
				timeStart != null ? timeStart : null, 
				timeEnd != null ? timeEnd : null);
		
//		if(idTypeRoomFree != null) {
//			for(String s : idTypeRoomFree) {
//				System.out.println(s);
//			}
//		}
		
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
