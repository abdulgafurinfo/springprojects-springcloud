package com.abdul.springprojects.cloud.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RibbonClient(name = "rest-service")
public class RestClientService {
	
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/hello")
	public String hi(@RequestParam(value = "name", defaultValue = "Buddy") String name) {
		String response = this.restTemplate.getForObject("http://rest-service/say-hello", String.class);
		return String.format("%s, %s!", response, name);
	}

	
	
	

}
