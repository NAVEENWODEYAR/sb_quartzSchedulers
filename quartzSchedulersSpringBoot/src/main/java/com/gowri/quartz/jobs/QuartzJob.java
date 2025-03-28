package com.gowri.quartz.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * @author NaveenWodeyar
 * @date 29-Mar-2025
 * @time 12:12:48 am
 */

@Component
public class QuartzJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
	}

}
