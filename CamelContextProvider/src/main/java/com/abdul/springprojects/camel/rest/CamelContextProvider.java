package com.abdul.springprojects.camel.rest;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 

 

@RestController
public class CamelContextProvider implements CamelContextAware {
	
	public static Logger logger = LoggerFactory.getLogger(CamelContextProvider.class);
	
	@Autowired
	protected CamelContext camelContext;

	@Override
	public void setCamelContext(CamelContext camelContext) {
		// TODO Auto-generated method stub
		this.camelContext=camelContext;
		
	}

	@Override
	@RequestMapping(value="/")
	public CamelContext getCamelContext() {
		logger.info("Service Context : " + camelContext.getName()); 
		return camelContext;
	}

}
