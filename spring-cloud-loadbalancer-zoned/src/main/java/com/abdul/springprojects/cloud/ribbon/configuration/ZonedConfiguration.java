package com.abdul.springprojects.cloud.ribbon.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name = "rest-info2", configuration = CustomZonedConfiguration.class)
public class ZonedConfiguration {

}
