package com.abdul.springprojects.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.abdul.springprojects.serviceconfig.ServiceConfig;

 

 
 

@RestController
public class ServiceController {
	
	public static Logger logger = LoggerFactory.getLogger(ServiceController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String url = "http://localhost:9091/router/service/{serviceId}";
	
	private Map<String,String> urlParams = new HashMap<String, String>();
	
	
	
	
	@RequestMapping(value="/api", method=RequestMethod.PUT)
	public boolean createRequest(@RequestBody ServiceConfig serviceConfig){
		
		/*logger.info("Trying to create a request");
		urlParams.put("serviceId", serviceConfig.getServiceId());
		restTemplate.put(zuulUrl, serviceConfig,urlParams);*/
		
		
		//logger.info(serviceConfig.toString());
		/*
		UriComponentsBuilder uriBuilder = UriComponentsBuilder .fromUriString(zuulUrl);
		urlParams.put("serviceId", serviceConfig.getServiceId());
		restTemplate.put(uriBuilder.toString(), serviceConfig,urlParams);*/
		
		/*HttpHeaders requestHeaders = new HttpHeaders();
		 List <MediaType> mediaTypeList = new ArrayList<MediaType>();
	//	 mediaTypeList.add(MediaType.APPLICATION_JSON);
		 mediaTypeList.add(MediaType.ALL);
		 requestHeaders.setAccept(mediaTypeList);
		 requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		 HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
		
		 
		 ResponseEntity<Object> response = restTemplate.exchange(zuulUrl, HttpMethod.PUT, serviceConfig, ServiceConfig.class, serviceConfig.getServiceId());
		 if (response == null) {
		 return false;
		 }
		 return HttpStatus.CREATED.equals(response.getStatusCode());*/
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		urlParams.put("serviceId", serviceConfig.getServiceId());
		HttpEntity<ServiceConfig> requestEntity = new HttpEntity<ServiceConfig>(serviceConfig, headers);
		logger.info("Trying to create a request");
		restTemplate.exchange(url, HttpMethod.PUT, requestEntity, ServiceConfig.class, urlParams);
		 
		logger.info("Sucessfully create a request");
	return new ResponseEntity<Void>(HttpStatus.CREATED) != null;
		
	}
	
	
	 




}
