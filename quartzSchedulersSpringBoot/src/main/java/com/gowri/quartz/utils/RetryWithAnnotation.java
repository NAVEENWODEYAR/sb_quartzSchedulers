package com.gowri.quartz.utils;

import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.retry.annotation.Backoff;

/**
 * @author NaveenWodeyar
 * @date 26-Mar-2025
 * @time 9:01:43 pm
 */


@Service
public class RetryWithAnnotation {

    @Retryable(value = { Exception.class }, maxAttempts = 4, backoff = @Backoff(delay = 2000))
    public void doSomethingUnreliable() throws Exception {
        System.out.println("Attempting to do something unreliable...");
        if (Math.random() > 0.5) {
            throw new Exception("Random failure");
        }
        System.out.println("Operation succeeded");
    }
}
