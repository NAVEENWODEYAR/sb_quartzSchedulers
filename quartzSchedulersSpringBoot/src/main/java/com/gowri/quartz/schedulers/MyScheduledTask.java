package com.gowri.quartz.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author NaveenWodeyar
 * @date 24-Mar-2025
 * @time 6:37:01 pm
 */

@Component
public class MyScheduledTask {

    private boolean taskExecuted = false;

    // Task executed every day at 1:00 AM
    @Scheduled(cron = "0 1 * * * ?")
    public void executeTaskAt1AM() {
        System.out.println("Task executed at 1:00 AM: " + System.currentTimeMillis());
        taskExecuted = true;
    }

    // Task executed every 1 minute
    @Scheduled(cron = "0 * * * * ?")
    public void executeTaskEvery1Minute() {
        System.out.println("Task executed every 1 minute: " + System.currentTimeMillis());
        taskExecuted = true;
    }

    // Task executed every 2 minutes
    @Scheduled(cron = "0 */2 * * * ?")
    public void executeTaskEvery2Minutes() {
        System.out.println("Task executed every 2 minutes: " + System.currentTimeMillis());
        taskExecuted = true;
    }

    // Task executed every 5 minutes
    @Scheduled(cron = "0 */5 * * * ?")
    public void executeTaskEvery5Minutes() {
        System.out.println("Task executed every 5 minutes: " + System.currentTimeMillis());
        taskExecuted = true;
    }

    // Task executed every 45 minutes
    @Scheduled(cron = "0 */45 * * * ?")
    public void executeTaskEvery45Minutes() {
        System.out.println("Task executed every 45 minutes: " + System.currentTimeMillis());
        taskExecuted = true;
    }

    // Task executed every 1 hour
    @Scheduled(cron = "0 0 * * * ?")
    public void executeTaskEvery1Hour() {
        System.out.println("Task executed every 1 hour: " + System.currentTimeMillis());
        taskExecuted = true;
    }

    // Task executed every 1 hour 30 minutes
    @Scheduled(cron = "0 30 * * * ?")
    public void executeTaskEvery1Hour30Minutes() {
        System.out.println("Task executed every 1 hour 30 minutes: " + System.currentTimeMillis());
        taskExecuted = true;
    }

    // Task executed once a day at midnight (12:00 AM)
    @Scheduled(cron = "0 0 0 * * ?")
    public void executeTaskOnceADay() {
        System.out.println("Task executed once a day at midnight: " + System.currentTimeMillis());
        taskExecuted = true;
    }

    // Task executed once a week, at 12:00 PM (noon) on Sunday
    @Scheduled(cron = "0 0 12 ? * SUN")
    public void executeTaskOnceAWeek() {
        System.out.println("Task executed once a week at 12:00 PM on Sunday: " + System.currentTimeMillis());
        taskExecuted = true;
    }

    // Task executed once a month, at 12:00 PM on the 1st day of the month
    @Scheduled(cron = "0 0 12 1 * ?")
    public void executeTaskOnceAMonth() {
        System.out.println("Task executed once a month at 12:00 PM on the 1st day of the month: " + System.currentTimeMillis());
        taskExecuted = true;
    }

    // Task executed daily at 12:00 PM (noon)
    @Scheduled(cron = "0 0 12 * * ?")
    public void executeTaskDailyAt12PM() {
        System.out.println("Task executed daily at 12:00 PM: " + System.currentTimeMillis());
        taskExecuted = true;
    }

    // Task executed daily at 4:00 AM
    @Scheduled(cron = "0 0 4 * * ?")
    public void executeTaskDailyAt4AM() {
        System.out.println("Task executed daily at 4:00 AM: " + System.currentTimeMillis());
        taskExecuted = true;
    }

    // Getter to check if the task was executed
    public boolean isTaskExecuted() {
        return taskExecuted;
    }
}
