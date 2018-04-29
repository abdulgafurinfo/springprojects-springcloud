package com.abdul.springprojects.boot.rest;

 
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abdul.springprojects.util.GlobalCamelContext;

@RestController
@RequestMapping(value="/router")
public class RouteManager {
	
	
private static Logger log = LoggerFactory.getLogger(RouteManager.class);


@Autowired
private GlobalCamelContext camelContext;
	
	@RequestMapping(value="/service/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> addRoute(@PathVariable("id") String id,@RequestBody ServiceConfig serviceConfig){
		EndPointBuilder  endPointBuilder = new EndPointBuilder();
		log.trace("I am into Camel manager using " + id);
		log.trace(serviceConfig.toString());
		endPointBuilder.resolve(serviceConfig);
		log.trace("Created end point for: "  + id);
		try {
			camelContext.getCamelContext().addRoutes(endPointBuilder);
		} catch (Exception e) {
			log.trace("failed end point: "  + id);
			e.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
		
	}
	
	
	

}
