package com.appManageHotel.model.BO;

import java.util.Objects;
import com.appManageHotel.model.BEAN.Account;
import com.appManageHotel.model.DAO.AccountDAOImpl;

import jakarta.servlet.http.Cookie;

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
	
	public Account selectAccountByCookie(Cookie cookie) {
		if(cookie != null) {
			String IDAccount = cookie.getValue();
    		Account account = AccountDAOImpl.getInstance().selectByID(IDAccount);
    		return account;
		}
		return null;
	}
	
	public boolean updateAccount(Account t, String NewPassWord) {
		Account account = AccountDAOImpl.getInstance().selectByIDAndUserName(t.getIDAccount(), t.getUserName());
		if(account != null) {
			if(!account.getPassWord().equals(t.getPassWord())) return false;
			System.out.println(NewPassWord);
			AccountDAOImpl.getInstance().update(new Account(t.getIDAccount(), t.getUserName(), NewPassWord, account.getRole()));
			return true;
		}
		return false;
	}
	
	public boolean insertAccount(Account t) {
		Account find = AccountDAOImpl.getInstance().selectByUserName(t.getUserName());
		if (find == null) {
			AccountDAOImpl.getInstance().insert(t);
			return true;
		} else {
			return false;
		}
	}
}
