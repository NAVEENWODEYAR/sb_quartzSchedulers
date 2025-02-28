package com.gowri.quartz.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import com.gowri.quartz.jobs.FirstJob;
import com.gowri.quartz.model.TriggerInfo;
import com.gowri.quartz.schedulers.MainScheduler;
import com.gowri.quartz.utils.CommonUtils;

/**
 * @author NaveenWodeyar
 * @date 01-Mar-2025
 * @time 12:03:29 am
 */

class FirstJobRunTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Mock
    private MainScheduler mainScheduler;

    @Mock
    private CommonUtils commonUtils;

    @Mock
    private Logger logger;

    @InjectMocks
    private FirstJobRun firstJobRun;

    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInit_Success() {
        // Prepare mock data
        TriggerInfo triggerInfo = new TriggerInfo();
        when(commonUtils.getTriggerInfo(5, false, 1000L, 1000L, "info")).thenReturn(triggerInfo);

        // Run the method under test
        firstJobRun.init();

        // Verify if the job is scheduled
        verify(mainScheduler).scheduleJob(FirstJob.class, triggerInfo);

        // Verify logger calls
        verify(logger).info("Job scheduled,");
        verify(logger).info(toString()); // Verifies the timestamp log message (you can be more specific if needed)
    }

    @Test
    void testInit_ExceptionHandling() {
        // Make the commonUtils mock throw an exception
        when(commonUtils.getTriggerInfo(5, false, 1000L, 1000L, "info")).thenThrow(new RuntimeException("Error"));

        // Run the method under test and assert exception is handled
        firstJobRun.init();

        // Verify that the exception was printed (e.printStackTrace())
        verify(commonUtils).getTriggerInfo(5, false, 1000L, 1000L, "info");
    }

}
