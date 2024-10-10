package com.gowri.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class QuartzSchedulersSpringBootApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(QuartzSchedulersSpringBootApplication.class, args);
        Environment env = context.getEnvironment();
        
        // Get active profile
        String[] activeProfiles = env.getActiveProfiles();
        String activeProfile = activeProfiles.length > 0 ? activeProfiles[0] : "default";
        
        // Get application properties file name
        String propertySourceName = env.getProperty("spring.config.name", "application");
        
        System.out.println("\n***********************");
        System.out.println("Active Profile: " + activeProfile);
        System.out.println("Properties File: " + propertySourceName + ".properties");
    }
}
