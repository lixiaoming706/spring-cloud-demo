package com.lxm.user.center.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxm.user.center.dao.UserDao;
import com.lxm.user.center.service.UserService;
import com.lxm.user.domain.UserInfo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserInfo getUserById(Long id) {
		return userDao.getOne(id);
	}

}
