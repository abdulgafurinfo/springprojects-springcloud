package com.abdul.springprojects.boot.rest;

 
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 

 
 
@RestController
 
@RequestMapping(value="/router")
public class RoutingService {
	
	private static Logger log = LoggerFactory.getLogger(RoutingService.class);
	
	@RequestMapping(value="/service/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> addRoute(@PathVariable("id") String id,@RequestBody ServiceConfig serviceConfig){
		 
		log.info("I am into Camel manager using Put " + id);
		log.info(serviceConfig.toString());
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
		
	}
	
	
	
	@RequestMapping(value="/service/{id}", method=RequestMethod.GET)
	public ResponseEntity<Void> getRequest(@PathVariable("id") String id){
		 
		log.info("I am into Camel mamanger " + id);
		 
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
		
	}
	
	
	/*@RequestMapping(value="/service/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> putRequest(@PathVariable("id") String id){
		 
		log.info("I am into Camel mamanger for PUT " + id);
		 
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
		
	}*/

}
