package com.lxm.web.client.dao.impl;

import org.springframework.stereotype.Component;

import com.lxm.user.domain.UserInfo;
import com.lxm.web.client.dao.UserInterface;

@Component
public class UserClientFallBack implements UserInterface {

	@Override
	public UserInfo get(Long id) {
		
		return new UserInfo()
				.setId(id)
				.setUserName("feign fall back.....");
	}

}
