package com.lxm.user.center.ctroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lxm.user.center.service.UserService;
import com.lxm.user.domain.UserInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserCtroller {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/{id}")
	@HystrixCommand /* (fallbackMethod ="build" ) */
	public UserInfo getUser(@PathVariable Long id) {
		System.out.println("id===>"+id);
		System.out.println("id===>"+id);
		System.out.println("id===>"+id);
		System.out.println("id===>"+id);
		UserInfo userById = userService.getUserById(id);
		return userService.getUserById(id);
	}
	
	public UserInfo build(@PathVariable Long id) {
		return new UserInfo()
				.setId(id)
				.setUserName("sevice happend exception");
	}
	
}
