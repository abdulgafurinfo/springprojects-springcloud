package com.abdul.springprojects.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("rest-service")
public interface FeignServiceTemplate {
	
	
	@RequestMapping(value = "/")
	String home();
	
	@RequestMapping(value = "/say-hello")
	public String greet();

}
