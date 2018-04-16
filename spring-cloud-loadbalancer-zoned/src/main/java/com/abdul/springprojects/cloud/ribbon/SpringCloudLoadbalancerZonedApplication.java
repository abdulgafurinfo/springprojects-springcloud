package com.abdul.springprojects.cloud.ribbon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
 

 

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudLoadbalancerZonedApplication implements CommandLineRunner {

	private static Logger log = LoggerFactory.getLogger(SpringCloudLoadbalancerZonedApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudLoadbalancerZonedApplication.class, args);
	}
	
	   @Autowired
	    private DiscoveryClient discoveryClient;
	  /*  @Autowired
	    private LoadBalancerClient loadBalancer;*/
	   
	   @Override
		public void run(String... args) throws Exception {
		
		   System.out.println("getall");
	        for (ServiceInstance s : discoveryClient.getInstances("rest-info")) {
	        	 
	            System.out.println(s.getHost() + ":" + s.getPort());
	        }
		}

	/*@Override
	public void run(String... args) throws Exception {
		System.out.println("all");
        for (ServiceInstance s : discoveryClient.getInstances("rest-service")) {
        	 
            System.out.println(s.getHost() + ":" + s.getPort());
        }
        
         
        for (String s : discoveryClient.getServices()) {
       	 
            System.out.println("services under  discovery  : " +s);
        }
        System.out.println("from lb");
        ServiceInstance instance = loadBalancer.choose("rest-service");
        System.out.println(instance.getHost() + ":" + instance.getPort());
		
	}
*/}
