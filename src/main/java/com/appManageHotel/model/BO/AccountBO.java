package com.appManageHotel.model.BO;

import java.util.Objects;
import com.appManageHotel.model.BEAN.Account;
import com.appManageHotel.model.DAO.AccountDAOImpl;

public class AccountBO {
	
	public static AccountBO getInstance() {
		return new AccountBO();
	}
	
	public boolean checkUserNameAccount(String username) {
		Account account = AccountDAOImpl.getInstance().selectByUserName(username);
		
		// Check account null ???
		if(Objects.isNull(account)) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean checkUserNamePassWordAccount(String username, String password) {
		Account account = AccountDAOImpl.getInstance().selectByUserNameAndPassWord(username, password);
		
		// Check account null ???
		if(Objects.isNull(account)) {
			return false;
		} else {
			return true;
		}
	}
	
	public Account selectByUserNameAndPassWord(String username, String password) {
		return AccountDAOImpl.getInstance().selectByUserNameAndPassWord(username, password);
	}
}