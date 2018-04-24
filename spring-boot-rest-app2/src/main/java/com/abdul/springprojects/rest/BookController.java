package com.abdul.springprojects.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/books")
public class BookController {
	
	@RequestMapping(value = "/microservices")
	  public String available() {
	    return "Microservices Architecture";
	  }

	  @RequestMapping(value = "/checkprice")
	  public String checkedPrice() {
	    return "5" + " EUR";
	  }

}
