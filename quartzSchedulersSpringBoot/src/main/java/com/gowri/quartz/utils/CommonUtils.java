package com.gowri.quartz.utils;

import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.stereotype.Service;

import com.gowri.quartz.model.TriggerInfo;

/**
 * @author NaveenWodeyar
 * @date 11-Oct-2024
 * @time 10:24:57 pm
 */
@Service
public class CommonUtils {

	public JobDetail getJobDetail(Class className, TriggerInfo triggerInfo) {
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put(className.getSimpleName(), triggerInfo);
		return JobBuilder.newJob(className)
				.withIdentity(className.getSimpleName(),"group-1")
				.setJobData(jobDataMap)
				.build();
	}
	
	public Trigger getTrigerInfoOfJob(Class className, TriggerInfo triggerInfo) {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInMilliseconds(triggerInfo.getTimeInterval());
		
		if (triggerInfo.isRunForEver()) {
			scheduleBuilder.repeatForever();
		}else {
			scheduleBuilder.withRepeatCount(triggerInfo.getTriggerCount());
		}
		
		return TriggerBuilder.newTrigger()
				.startAt(new Date(System.currentTimeMillis()+triggerInfo.getInitialOffSet()))
				.withSchedule(scheduleBuilder)
				.build();
	}
	
	public TriggerInfo getTriggerInfo(int triggerCount, boolean runForEver, Long repeatValue, Long initialOffset, String information) {
		TriggerInfo triggerInfo = new TriggerInfo();
					triggerInfo.setRunForEver(runForEver);
					triggerInfo.setTriggerCount(triggerCount);
					triggerInfo.setInitialOffSet(initialOffset);
					triggerInfo.setTimeInterval(repeatValue);
					triggerInfo.setInfo(information);
					
					return triggerInfo;
					
	}
	
	
}
