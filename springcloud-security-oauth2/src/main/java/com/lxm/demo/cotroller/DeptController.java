package com.lxm.demo.cotroller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
	
	@GetMapping("/dept")
	@PreAuthorize("hasAuthority('p3')")
	public String dept() {
		return "this is dept";
	}
}
