package com.lxm.web.client.ctroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lxm.user.domain.UserInfo;
import com.lxm.web.client.dao.UserInterface;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@DefaultProperties(defaultFallback="batchFallBack")
public class UserWebController {
	
	@Autowired
	private UserInterface userInterface;
	
	@GetMapping("/user/{id}")
	public UserInfo get(@PathVariable("id") Long id) {
		return userInterface.get(id);
	}
	
	@HystrixCommand(fallbackMethod = "fallBack")
	@GetMapping("/user/get")
	public UserInfo build() {
		int i  = 10/0;
		return new UserInfo()
				.setUserName("GET ....")
				.setAge(18);
	}
	
	@GetMapping("/get/user/{id}")
	@HystrixCommand
	public UserInfo generate(@PathVariable("id") Long id) {
		int i  = 10/0;
		return new UserInfo()
				.setUserName("GET ....")
				.setAge(18);
	}
	
	public UserInfo fallBack() {
		return new UserInfo()
				.setUserName("fall back...")
				.setAge(20);
	}
	
	public UserInfo batchFallBack() {
		return new UserInfo()
				.setUserName("batch fall back...")
				.setAge(20);
	}
}
