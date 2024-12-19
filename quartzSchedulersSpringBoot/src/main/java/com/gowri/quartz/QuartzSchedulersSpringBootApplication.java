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

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    private static Date startTime;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(QuartzSchedulersSpringBootApplication.class, args);
        
        Environment env = context.getEnvironment();

        String activeProfile = getActiveProfile(env);
        
        String propertySourceName = env.getProperty("spring.config.name", "application");
        
        startTime = new Date();

        logStartupInfo(activeProfile, propertySourceName);
    }

    private static String getActiveProfile(Environment env) {
        String[] activeProfiles = env.getActiveProfiles();
        return activeProfiles.length > 0 ? activeProfiles[0] : "default";
    }

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
