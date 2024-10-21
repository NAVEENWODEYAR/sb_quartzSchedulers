package com.gowri.quartz.jobs;

import java.time.Instant;
import java.time.Duration;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author NaveenWodeyar
 * @date 11-Oct-2024
 * @time 10:12:40 pm
 */
@Component
public class Job3 implements Job {
	
	private static final Logger log = LoggerFactory.getLogger(Job3.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
	    Instant start = Instant.now(); 
	    log.info("Dummy job started at: {}", start); 
	    System.out.println("Dummy Job started at: " + start);
	    
	    // Job execution logic
	    try {
	        log.info("Dummy job executed"); 
	        System.out.println("Dummy Job! First Job in Quartz Scheduling...." + start);
	    } catch (Exception e) {
	        log.error("Error executing Dummy Job", e);
	        throw new JobExecutionException(e);
	    } finally {
	        Instant end = Instant.now(); 
	        log.info("Dummy job ended at: {}", end);
	        System.out.println("Dummy Job ended at: " + end);

	        // Calculate and log duration
	        long durationInSeconds = Duration.between(start, end).toSeconds();
	        log.info("Total Duration: {} seconds", durationInSeconds);
	        System.out.println("Total Duration: " + durationInSeconds + " seconds");
	    }
	}
}
