package com.gowri.quartz.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.quartz.JobDetail;
import org.quartz.Trigger;

import com.gowri.quartz.jobs.FirstJob;
import com.gowri.quartz.model.TriggerInfo;
/**
 * @author NaveenWodeyar
 * @date 20-Oct-2024
 * @time 12:57:36 pm
 */
public class CommonUtilsTest {

    private CommonUtils commonUtils;

    @BeforeEach
    public void setUp() {
        commonUtils = new CommonUtils();
    }

    @Test
    public void testGetJobDetail() {
        Class<?> jobClass = FirstJob.class; 
        TriggerInfo triggerInfo = new TriggerInfo();
        triggerInfo.setInfo("Test Job Info");

        JobDetail jobDetail = commonUtils.getJobDetail(jobClass, triggerInfo);

        assertNotNull(jobDetail);
        assertEquals(jobClass.getSimpleName(), jobDetail.getKey().getName());
        assertEquals("group-1", jobDetail.getKey().getGroup());
        assertEquals(triggerInfo, jobDetail.getJobDataMap().get(jobClass.getSimpleName()));
    }

    @Test
    public void testGetJobDetailCron() {
        Class<?> jobClass = FirstJob.class; 

        JobDetail jobDetail = commonUtils.getJobDetailCron(jobClass);

        assertNotNull(jobDetail);
        assertEquals(jobClass.getSimpleName(), jobDetail.getKey().getName());
        assertEquals("group-1", jobDetail.getKey().getGroup());
    }

    @Test
    public void testGetTrigerInfoOfJob_RunForever() {
        Class<?> jobClass = FirstJob.class; 
        TriggerInfo triggerInfo = new TriggerInfo();
        triggerInfo.setRunForEver(true);
        triggerInfo.setTimeInterval(1000L);
        triggerInfo.setInitialOffSet(0L);
        
        Trigger trigger = commonUtils.getTrigerInfoOfJob(jobClass, triggerInfo);

        assertNotNull(trigger);
    }

    @Test
    public void testGetTrigerInfoOfJob_WithCount() {
        Class<?> jobClass = FirstJob.class;
        TriggerInfo triggerInfo = new TriggerInfo();
        triggerInfo.setRunForEver(false);
        triggerInfo.setTriggerCount(5);
        triggerInfo.setTimeInterval(1000L);
        triggerInfo.setInitialOffSet(0L);
        
        Trigger trigger = commonUtils.getTrigerInfoOfJob(jobClass, triggerInfo);

        assertNotNull(trigger);
    }

    @Test
    public void testGetTriggerByCronExpression() {
        Class<?> jobClass = FirstJob.class; 
        String cronExp = "0/5 * * * * ?"; 

        Trigger trigger = commonUtils.getTriggerByCronExpression(jobClass, cronExp);

        assertNotNull(trigger);
        assertEquals(jobClass.getSimpleName(), trigger.getKey().getName());
        assertEquals(cronExp, trigger.getScheduleBuilder().getClass());
    }

    @Test
    public void testGetTriggerInfo() {
        int triggerCount = 5;
        boolean runForEver = false;
        Long repeatValue = 1000L;
        Long initialOffset = 100L;
        String information = "Test Trigger Info";

        TriggerInfo triggerInfo = commonUtils.getTriggerInfo(triggerCount, runForEver, repeatValue, initialOffset, information);

        assertNotNull(triggerInfo);
        assertEquals(triggerCount, triggerInfo.getTriggerCount());
        assertEquals(runForEver, triggerInfo.isRunForEver());
        assertEquals(repeatValue, triggerInfo.getTimeInterval());
        assertEquals(initialOffset, triggerInfo.getInitialOffSet());
        assertEquals(information, triggerInfo.getInfo());
    }
}
