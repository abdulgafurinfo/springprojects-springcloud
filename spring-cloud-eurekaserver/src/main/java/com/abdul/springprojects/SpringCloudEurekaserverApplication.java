package com.abdul.springprojects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaserverApplication.class, args);
	}
}
