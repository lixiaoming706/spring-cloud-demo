package com.lxm.demo.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	@Transactional  //标记该方法是事务方法
	public void insertUser() {
		
		userDao.insert();
		System.out.println("插入完成.............");
		int i = 1/0;
	}
	
}
