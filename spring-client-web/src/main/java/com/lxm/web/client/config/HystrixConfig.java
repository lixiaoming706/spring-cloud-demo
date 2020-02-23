package com.lxm.web.client.config;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCircuitBreaker //开启熔断降级
@EnableHystrixDashboard
public class HystrixConfig {
	
	
}
