package com.gowri.quartz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gowri.quartz.jobs.Job3;
import com.gowri.quartz.jobs.SecondJob;
import com.gowri.quartz.model.TriggerInfo;
import com.gowri.quartz.schedulers.MainScheduler;
import com.gowri.quartz.utils.CommonUtils;

import jakarta.annotation.PostConstruct;

/**
 * @author NaveenWodeyar
 * @date 12-Oct-2024
 * @time 7:06:16 pm
 */
@Service
public class Job3Scheduler {
	
    private static final Logger log = LoggerFactory.getLogger(Job3Scheduler.class);

	private final MainScheduler mainScheduler;
	
	private final CommonUtils commonUtils;
	
	public Job3Scheduler(MainScheduler mainScheduler, CommonUtils commonUtils) {
		this.mainScheduler = mainScheduler;
		this.commonUtils = commonUtils;
	}	
	
	@PostConstruct
	public void init() {
		TriggerInfo triggerInfo = commonUtils.getTriggerInfo(1, true, 5000L, 5000L, "JOB-3,");
		mainScheduler.scheduleJob(Job3.class, triggerInfo);
		log.info("scheduling the job using Trigger_Info");
	}
	
}
