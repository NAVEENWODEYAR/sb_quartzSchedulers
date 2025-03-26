package com.gowri.quartz.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author NaveenWodeyar
 * @date 26-Mar-2025
 * @time 9:16:27 pm
 */

@Service
public class CronJobService {

    private static int retryAttemptCount = 0;

    @Retryable(value = { RuntimeException.class }, maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 2))
    public void performTask() {
        retryAttemptCount++;
        System.out.println("Running attempt " + retryAttemptCount);

        // Simulate a failure
        if (Math.random() > 0.5) {
            System.out.println("Task failed, retrying...");
            throw new RuntimeException("Temporary failure");
        }

        System.out.println("Task completed successfully on attempt " + retryAttemptCount);
    }

    public int getRetryCount() {
        return retryAttemptCount;
    }
}
