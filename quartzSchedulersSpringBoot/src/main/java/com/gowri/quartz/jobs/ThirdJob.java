package com.gowri.quartz.jobs;

import java.time.*;
import org.quartz.*;
import org.slf4j.*;
import org.springframework.stereotype.Component;

/**
 * @author NaveenWodeyar
 * @date 11-Oct-2024
 * @time 10:12:40 pm
 */
@Component
public class ThirdJob implements Job {
	
	private static final Logger log = LoggerFactory.getLogger(ThirdJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
	    Instant start = Instant.now(); 
	    log.info("Dummy job started at: {}", start); 
	    System.out.println("Dummy Job started at: " + start);
	    
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

	        long durationInSeconds = Duration.between(start, end).toSeconds()/1000;
	        log.info("Total Duration: {} seconds", durationInSeconds);
	        System.out.println("Total Duration: " + durationInSeconds + " seconds");
	    }
	}
}
