package com.abdul.springprojects.cloud.ribbon.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerListFilter;

@Configuration
public class CustomZonedConfiguration {

	@Bean
    public ServerListFilter<Server> ribbonServerListFilter(IClientConfig config) {
        System.out.println("My ribbonServerListFilter will be used");
        MyListFilter filter = new MyListFilter();
        filter.initWithNiwsConfig(config);
        return filter;
	}
        
        
}
