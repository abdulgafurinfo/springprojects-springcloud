package com.abdul.springprojects.boot.feign;

import org.apache.camel.CamelContext;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("camel-context-provider")
//@RequestMapping(value="/camel")
public interface FeignServiceTemplate {
	
	
	@RequestMapping(value = "/context")
	public CamelContext getCamelContext();
	
	 
}
