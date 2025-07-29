package com.gowri.quartz.jobs;

import com.gowri.quartz.jobs.HelloWorldJob;
import org.quartz.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author NaveenWodeyar
 * @date 29-Jul-2025
 * @time 8:02:06 pm
 */

@Component
public class ManualJobTrigger implements CommandLineRunner {

    private final Scheduler scheduler;

    public ManualJobTrigger(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void run(String... args) throws Exception {
        JobDetail jobDetail = JobBuilder.newJob(HelloWorldJob.class)
                .withIdentity("helloWorldJob", "group1")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("manualTrigger", "group1")
                .startNow()
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }
}
