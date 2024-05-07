package com.appManageHotel.model.BO;

import com.appManageHotel.model.BEAN.Account;
import com.appManageHotel.model.BEAN.Staff;
import com.appManageHotel.model.DAO.StaffDAOimpl;

public class StaffBO {
	public static StaffBO getInstance() {
		return new StaffBO();
	}
	
	public boolean insertStaff(Staff s, Account a) {
		if(StaffDAOimpl.getInstance().selectByCCCD(s.getCCCD()) == null ) {
			if (!AccountBO.getInstance().insertAccount(a)) return false;
			StaffDAOimpl.getInstance().insert(s);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean UpdateStaff(String IdStaff,String NewFullName,String NewCCCD) {
		Staff find = StaffDAOimpl.getInstance().selectByCCCD(NewCCCD);
		if (find != null) {
			if (find.getIDStaff().equals(IdStaff)) {
				find.setFullName(NewFullName);
				StaffDAOimpl.getInstance().update(find);
				return true;
			} else return false;
		} else {
			Staff f=StaffDAOimpl.getInstance().selectByID(IdStaff);
			f.setCCCD(NewCCCD);
			f.setFullName(NewFullName);
			StaffDAOimpl.getInstance().update(f);
			return true;
		}
	}
	
	public void Layoff(String IdStaff) {
		Staff f = StaffDAOimpl.getInstance().selectByID(IdStaff);
		f.setState(false);
		StaffDAOimpl.getInstance().update(f);
	}
}
