package com.gowri.quartz.jobs;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        long startTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("############################");
        log.info("\n********** Started ************\n");
        log.info("Start Time: {}", sdf.format(new Date(startTime)));

        try {
        	log.info("executing job");
            System.out.println("SECOND JOB");

        } catch (Exception e) {
            log.error("Error executing SecondJob", e);
            throw new JobExecutionException(e);
        } finally {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            log.info("End Time: {}", sdf.format(new Date(endTime)));
            log.info("Total Duration: {} ms", duration);
            System.out.println("End Time: " + sdf.format(new Date(endTime)));
            System.out.println("Total Duration: " + duration + " ms");
            log.info("\n********** Finished ************\n");
            System.out.println("############################");
        }
    }

}
