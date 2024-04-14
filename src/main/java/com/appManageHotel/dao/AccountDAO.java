package com.appManageHotel.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.appManageHotel.database.ConnectDatabase;
import com.appManageHotel.models.Account;

public class AccountDAO implements DAOInterface<Account>{
	
	public static AccountDAO getInstance() {
		return new AccountDAO();
	}

	@Override
	public int insert(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Account> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account selectByID(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Account> selectByCondition(String Condition) {
		// TODO Auto-generated method stub
		return null;
	}
}
