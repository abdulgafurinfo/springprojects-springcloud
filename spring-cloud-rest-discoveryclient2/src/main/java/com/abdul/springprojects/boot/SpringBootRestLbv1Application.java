package com.abdul.springprojects.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class SpringBootRestLbv1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestLbv1Application.class, args);
	}
}