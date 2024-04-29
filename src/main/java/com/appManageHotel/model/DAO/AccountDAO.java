package com.appManageHotel.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.model.BEAN.Account;
import com.appManageHotel.model.BEAN.TypeRoom;

public interface AccountDAO extends DAOInterface<Account>{
	
	public Account selectByUserName(String username);

	public Account selectByUserNameAndPassWord(String username, String password);
}
