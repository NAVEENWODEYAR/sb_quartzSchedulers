package com.gowri.quartz.service;

import org.springframework.stereotype.Service;

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
public class SchedulerForEverJob {

	private final MainScheduler mainScheduler;
	private final CommonUtils commonUtils;
	
	public SchedulerForEverJob(MainScheduler mainScheduler, CommonUtils commonUtils) {
		this.mainScheduler = mainScheduler;
		this.commonUtils = commonUtils;
	}
	
	/**
	@PostConstruct
	public void init() {
		TriggerInfo triggerInfo = commonUtils.getTriggerInfo(1, true, 5000L, 5000L, "Hello World,");
		mainScheduler.scheduleJob(SecondJob.class, triggerInfo);
	}
	*/
	
	@PostConstruct
	public void init() {
		mainScheduler.scheduleJob(SecondJob.class, "0/2 * * * * ?");
	}
}