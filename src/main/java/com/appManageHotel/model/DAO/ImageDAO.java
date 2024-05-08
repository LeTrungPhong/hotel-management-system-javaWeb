package com.appManageHotel.model.DAO;

import java.util.ArrayList;

import com.appManageHotel.model.BEAN.Image;

public interface ImageDAO extends DAOInterface<Image>{
	public Image selectByNameOrPath(String name, String path);
	
	public Image selectByNameOrPathExceptID(String id, String name, String path);
	
	public ArrayList<Image> selectByIDTypeRoom(String id);
}
