package com.gowri.quartz.schedulers;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowri.quartz.model.TriggerInfo;
import com.gowri.quartz.utils.CommonUtils;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 * @author NaveenWodeyar
 * @date 11-Oct-2024
 * @time 10:14:49 pm
 */
@Service
public class MainScheduler {
	
	private static final Logger log = LoggerFactory.getLogger(MainScheduler.class);
	
	@Autowired
	private CommonUtils commonUtils;

	private final Scheduler scheduler;
	
	public MainScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
		}

	@PostConstruct
	public void startScheduler() {
		try {
			scheduler.start();
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}
	
	@PreDestroy
	public void closeScheduler() {
		try {
			scheduler.shutdown();
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void scheduleJob(Class className, TriggerInfo triggerInfo) {
		try {
			JobDetail jobDetail = commonUtils.getJobDetail(className, triggerInfo);
			Trigger trigerInfoOfJob = commonUtils.getTrigerInfoOfJob(className, triggerInfo);
			scheduler.scheduleJob(jobDetail,trigerInfoOfJob);
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void scheduleJob(Class className, String cronExpression) {
		try {
			JobDetail jobDetail = commonUtils.getJobDetailCron(className);
			Trigger trigerInfoOfJob = commonUtils.getTriggerByCronExpression(className, cronExpression);
			scheduler.scheduleJob(jobDetail,trigerInfoOfJob);
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}

}
