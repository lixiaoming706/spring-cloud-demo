package com.lxm.demo.cotroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lxm.demo.domain.User;

@RestController
public class UserController {
	
	@GetMapping("/user/{id}")
	public User findUserById(@PathVariable("id") String userId) {
		User user = new User("lxm","28");
		user.setUserName("lxm").setPassWord(userId);
		System.out.println("id====>"+userId);
		return user;
	}
}
