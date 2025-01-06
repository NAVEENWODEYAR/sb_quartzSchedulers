package com.gowri.quartz.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gowri.quartz.jobs.FirstJob;
import com.gowri.quartz.jobs.SecondJob;
import com.gowri.quartz.model.TriggerInfo;
import com.gowri.quartz.schedulers.MainScheduler;
import com.gowri.quartz.utils.CommonUtils;

import jakarta.annotation.PostConstruct;

@Service
public class FirstJobRun {
	
    private static final Logger log = LoggerFactory.getLogger(FirstJobRun.class);

    private final MainScheduler mainScheduler;
    
    private final CommonUtils commonUtils;

    public FirstJobRun(MainScheduler mainScheduler, CommonUtils commonUtils) {
        this.mainScheduler = mainScheduler;
        this.commonUtils = commonUtils;    
    }

    @PostConstruct
    public void init() {
        try {
            TriggerInfo triggerInfo = commonUtils.getTriggerInfo(5, false, 1000L, 1000L, "info");
            mainScheduler.scheduleJob(FirstJob.class, triggerInfo); 
            log.info("Job scheduled,");
            log.info("TIMESTAMP:: {}",
    				LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm a")));
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
