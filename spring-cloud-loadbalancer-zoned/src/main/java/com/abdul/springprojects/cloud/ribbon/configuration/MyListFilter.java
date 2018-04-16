package com.abdul.springprojects.cloud.ribbon.configuration;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.ZonePreferenceServerListFilter;

import com.netflix.loadbalancer.Server;

public class MyListFilter extends ZonePreferenceServerListFilter {
	
	@Override
    public List<Server> getFilteredListOfServers(List<Server> servers) {
        System.out.println("This is my version");
        return super.getFilteredListOfServers(servers);
    }

}
