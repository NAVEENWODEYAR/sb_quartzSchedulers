package com.gowri.quartz.schedulers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author NaveenWodeyar
 * @date 24-Mar-2025
 * @time 6:37:51 pm
 */

@SpringBootTest
public class MyScheduledTaskTest {

    @Autowired
    private MyScheduledTask myScheduledTask;

    @BeforeEach
    public void setUp() {
        // Reset task execution state before each test
        myScheduledTask = Mockito.spy(myScheduledTask);
    }

    @Test
    public void testExecuteTaskAt1AM() {
        // Simulate executing the task
        myScheduledTask.executeTaskAt1AM();

        // Assert that the task has been executed
        assertTrue(myScheduledTask.isTaskExecuted(), "Task at 1 AM should have been executed.");
    }

    @Test
    public void testExecuteTaskEvery1Minute() {
        // Simulate executing the task
        myScheduledTask.executeTaskEvery1Minute();

        // Assert that the task has been executed
        assertTrue(myScheduledTask.isTaskExecuted(), "Task every 1 minute should have been executed.");
    }

    @Test
    public void testExecuteTaskEvery2Minutes() {
        // Simulate executing the task
        myScheduledTask.executeTaskEvery2Minutes();

        // Assert that the task has been executed
        assertTrue(myScheduledTask.isTaskExecuted(), "Task every 2 minutes should have been executed.");
    }

    @Test
    public void testExecuteTaskEvery5Minutes() {
        // Simulate executing the task
        myScheduledTask.executeTaskEvery5Minutes();

        // Assert that the task has been executed
        assertTrue(myScheduledTask.isTaskExecuted(), "Task every 5 minutes should have been executed.");
    }

    @Test
    public void testExecuteTaskEvery45Minutes() {
        // Simulate executing the task
        myScheduledTask.executeTaskEvery45Minutes();

        // Assert that the task has been executed
        assertTrue(myScheduledTask.isTaskExecuted(), "Task every 45 minutes should have been executed.");
    }

    @Test
    public void testExecuteTaskEvery1Hour() {
        // Simulate executing the task
        myScheduledTask.executeTaskEvery1Hour();

        // Assert that the task has been executed
        assertTrue(myScheduledTask.isTaskExecuted(), "Task every 1 hour should have been executed.");
    }

    @Test
    public void testExecuteTaskEvery1Hour30Minutes() {
        // Simulate executing the task
        myScheduledTask.executeTaskEvery1Hour30Minutes();

        // Assert that the task has been executed
        assertTrue(myScheduledTask.isTaskExecuted(), "Task every 1 hour 30 minutes should have been executed.");
    }

    @Test
    public void testExecuteTaskOnceADay() {
        // Simulate executing the task
        myScheduledTask.executeTaskOnceADay();

        // Assert that the task has been executed
        assertTrue(myScheduledTask.isTaskExecuted(), "Task once a day should have been executed.");
    }

    @Test
    public void testExecuteTaskOnceAWeek() {
        // Simulate executing the task
        myScheduledTask.executeTaskOnceAWeek();

        // Assert that the task has been executed
        assertTrue(myScheduledTask.isTaskExecuted(), "Task once a week should have been executed.");
    }

    @Test
    public void testExecuteTaskOnceAMonth() {
        // Simulate executing the task
        myScheduledTask.executeTaskOnceAMonth();

        // Assert that the task has been executed
        assertTrue(myScheduledTask.isTaskExecuted(), "Task once a month should have been executed.");
    }

    @Test
    public void testExecuteTaskDailyAt12PM() {
        // Simulate executing the task
        myScheduledTask.executeTaskDailyAt12PM();

        // Assert that the task has been executed
        assertTrue(myScheduledTask.isTaskExecuted(), "Task daily at 12 PM should have been executed.");
    }

    @Test
    public void testExecuteTaskDailyAt4AM() {
        // Simulate executing the task
        myScheduledTask.executeTaskDailyAt4AM();

        // Assert that the task has been executed
        assertTrue(myScheduledTask.isTaskExecuted(), "Task daily at 4 AM should have been executed.");
    }
}
