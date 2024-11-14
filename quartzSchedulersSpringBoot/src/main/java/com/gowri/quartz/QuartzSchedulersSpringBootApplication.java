package com.gowri.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableScheduling 
public class QuartzSchedulersSpringBootApplication {

    private static final Logger log = LoggerFactory.getLogger(QuartzSchedulersSpringBootApplication.class);

    // Date format for logging timestamps
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    // Variable to hold the application start time
    private static Date startTime;

    public static void main(String[] args) {
        // Run the Spring application and get the application context
        ApplicationContext context = SpringApplication.run(QuartzSchedulersSpringBootApplication.class, args);
        
        // Access the environment to retrieve properties
        Environment env = context.getEnvironment();

        // Retrieve the active profiles, defaulting to "default" if none are set
        String activeProfile = getActiveProfile(env);
        
        // Get the name of the properties file used (default is "application")
        String propertySourceName = env.getProperty("spring.config.name", "application");
        
        // Record the application start time
        startTime = new Date();

        // Log application startup details
        logStartupInfo(activeProfile, propertySourceName);
    }

    // Helper method to retrieve the active profile
    private static String getActiveProfile(Environment env) {
        String[] activeProfiles = env.getActiveProfiles();
        return activeProfiles.length > 0 ? activeProfiles[0] : "default";
    }

    // Logs application startup information
    private static void logStartupInfo(String activeProfile, String propertySourceName) {
        System.out.println("\n***********************");
        System.out.println("Active Profile: " + activeProfile);
        System.out.println("Properties File: " + propertySourceName + ".properties");
        System.out.println("Application Start Time: " + dateFormat.format(startTime));
        System.out.println("\n***********************");
    }

    // Scheduled task that runs every 10 seconds to log application status
    @Scheduled(fixedRate = 1000)
    public void logApplicationStatus() {
        log.info("Application is running. Current time: {}", dateFormat.format(new Date()));
    }
}
