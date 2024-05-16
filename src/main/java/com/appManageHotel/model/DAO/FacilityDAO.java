package com.appManageHotel.model.DAO;

import java.util.ArrayList;

import com.appManageHotel.model.BEAN.Facility;

public interface FacilityDAO extends DAOInterface<Facility>{
	public ArrayList<Facility> selectByIDTypeRoom(String id);
}
