package com.appManageHotel.model.DAO;

import com.appManageHotel.model.BEAN.Account;

public interface AccountDAO extends DAOInterface<Account>{
	
	public Account selectByUserName(String username);

	public Account selectByUserNameAndPassWord(String username, String password);
	
	public Account selectByIDAndUserName(String ID, String username);
}
 