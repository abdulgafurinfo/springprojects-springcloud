package com.abdul.springprojects.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {
	
	@Autowired
	FeignServiceTemplate feignClient;
	
	@RequestMapping("/home")
	public String goToHome() {
		return feignClient.home();
	}
	
	@RequestMapping("/getGreetings")
	public String getGreeting() {
		return feignClient.greet();
	}
	
	
	

}
