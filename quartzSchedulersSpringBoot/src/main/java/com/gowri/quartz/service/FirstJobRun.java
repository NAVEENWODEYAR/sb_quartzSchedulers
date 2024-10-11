package com.gowri.quartz.service;

import org.springframework.stereotype.Service;

import com.gowri.quartz.model.TriggerInfo;
import com.gowri.quartz.schedulers.MainScheduler;
import com.gowri.quartz.utils.CommonUtils;

import jakarta.annotation.PostConstruct;

/**
 * @author NaveenWodeyar
 * @date 11-Oct-2024
 * @time 10:41:15 pm
 */
@Service
public class FirstJobRun {

	private final MainScheduler mainScheduler;
	private final CommonUtils commonUtils;
	
	public FirstJobRun(MainScheduler mainScheduler,CommonUtils commonUtils) {
		this.mainScheduler = mainScheduler;
		this.commonUtils = commonUtils;	
	}
	
	@PostConstruct
	public void init() {
		TriggerInfo triggerInfo = commonUtils.getTriggerInfo(5, false, 1000L, 1000L, "info");
		mainScheduler.scheduleJob(FirstJobRun.class, triggerInfo);
	}
}
