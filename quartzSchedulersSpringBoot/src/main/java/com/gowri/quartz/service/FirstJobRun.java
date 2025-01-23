package com.gowri.quartz.service;

import org.springframework.stereotype.Service;
import com.gowri.quartz.jobs.FirstJob;
import com.gowri.quartz.model.TriggerInfo;
import com.gowri.quartz.schedulers.MainScheduler;
import com.gowri.quartz.utils.CommonUtils;
import jakarta.annotation.PostConstruct;

@Service
public class FirstJobRun {

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
