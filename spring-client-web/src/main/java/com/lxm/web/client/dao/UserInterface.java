package com.lxm.web.client.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lxm.user.domain.UserInfo;
import com.lxm.web.client.dao.impl.UserClientFallBack;

@FeignClient(value = "user-service",fallback = UserClientFallBack.class)
//@Component
public interface  UserInterface {
	
	@GetMapping("/user/{id}")
	public UserInfo get(@PathVariable("id") Long id) ;

}
