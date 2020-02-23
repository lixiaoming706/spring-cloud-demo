package com.lxm.user.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EntityScan(basePackages= {"com.lxm.user.domain"}) 
@EnableCircuitBreaker
public class SpringUserServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringUserServiceApplication.class, args);
	}
}
