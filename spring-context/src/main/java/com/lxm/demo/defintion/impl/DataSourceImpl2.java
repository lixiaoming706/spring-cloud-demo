package com.lxm.demo.defintion.impl;

import com.lxm.demo.beans.User;
import com.lxm.demo.defintion.DataSource;

public class DataSourceImpl2 implements DataSource {

	@Override
	public User getUser() {
		
		User user = new User();
		
		user.setUserName("DataSourceImpl2.......");
		
		return null;
	}

}
