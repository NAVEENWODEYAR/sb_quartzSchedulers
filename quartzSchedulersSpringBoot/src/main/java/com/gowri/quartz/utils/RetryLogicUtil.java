package com.gowri.quartz.utils;

import org.springframework.stereotype.Service;

/**
 * @author NaveenWodeyar
 * @date 26-Mar-2025
 * @time 8:56:39 pm
 */

@Service
public class RetryLogicUtil  {

    public void doSomethingUnreliable() {
        int maxAttempts = 4;
        int attempt = 0;
        boolean success = false;

        while (attempt < maxAttempts && !success) {
            try {
                System.out.println("Attempting to do something unreliable...");
                if (Math.random() > 0.5) {
                    throw new RuntimeException("Random failure");
                }
                System.out.println("Operation succeeded");
                success = true; // exit loop if successful
            } catch (RuntimeException e) {
                attempt++;
                if (attempt >= maxAttempts) {
                    System.out.println("Operation failed after multiple attempts.");
                } else {
                    System.out.println("Retrying... attempt " + (attempt + 1));
                    try {
                        Thread.sleep(2000); // backoff delay
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
