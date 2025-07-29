package com.gowri.quartz.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author NaveenWodeyar
 * @date 29-Jul-2025
 * @time 8:01:13 pm
 */

public class HelloWorldJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello World from Quartz!");
    }
}
