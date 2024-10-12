package com.gowri.quartz.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author NaveenWodeyar
 * @date 12-Oct-2024
 * @time 7:03:30 pm
 */
public class SecondJob implements Job {

	private static final Logger log = LoggerFactory.getLogger(SecondJob.class);
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("\n**********************\n");
		System.out.println("SECOND JOB");
		log.info("\n**********************\n");
	}

}
