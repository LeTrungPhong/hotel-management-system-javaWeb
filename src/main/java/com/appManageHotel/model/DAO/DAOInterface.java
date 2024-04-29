package com.appManageHotel.model.DAO;

import java.util.ArrayList;

public interface DAOInterface<T> {
	
	public int insert(T t);
	
	public int update(T t);
	
	public int delete(String ID);
	
	public ArrayList<T> selectAll();
	
	public T selectByID(String ID);
	
	public ArrayList<T> selectByCondition(String Condition);
	
}
