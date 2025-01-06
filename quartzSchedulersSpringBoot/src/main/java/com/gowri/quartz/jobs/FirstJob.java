package com.gowri.quartz.jobs;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.quartz.*;
import org.slf4j.*;
import org.springframework.stereotype.Component;

/**
 * @author NaveenWodeyar
 * @date 11-Oct-2024
 * @time 10:12:40 pm
 */
@Component
public class FirstJob implements Job {
	
	private static final Logger log = LoggerFactory.getLogger(FirstJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("First job started "+LocalDate.now());
		log.info("First job start time:: {}",
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm a")));
		System.out.println("First Job!,");
        System.out.println("First Job in Qaurtz Scheduling...."+new Date(System.currentTimeMillis()));
		log.info("First job executed  "+LocalDate.now());
		log.info("Accessing EndPoint using CRON:: {}",
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm a")));
	}

}
