package com.appManageHotel.model.BO;

import com.appManageHotel.model.BEAN.Image;
import com.appManageHotel.model.DAO.ImageDAOimpl;

public class ImageBO {
	public static ImageBO getInstance() {
		return new ImageBO();
	}
	
	public boolean insertImage(Image t) {
		Image image = ImageDAOimpl.getInstance().selectByNameOrPath(t.getImageName(),t.getPath());
		if(image == null) {
			ImageDAOimpl.getInstance().insert(t);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean updateImage(Image t) {
		Image image = ImageDAOimpl.getInstance().selectByNameOrPathExceptID(t.getIDImage(), t.getImageName(), t.getPath());
		if(image == null) {
			ImageDAOimpl.getInstance().update(t);
			return true;
		} else {
			return false;
		}
	}
}
