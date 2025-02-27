package com.gowri.quartz.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author NaveenWodeyar
 * @date 27-Feb-2025
 * @time 9:42:04 pm
 */

class TestControllerTest {

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
	
	 private MockMvc mockMvc;

	    @Mock
	    private Logger logger;

	    @InjectMocks
	    private TestController testController;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
	    }

	    @Test
	    void testTestEndPoint() throws Exception {
	        // Arrange
	        String expectedResponse = "SERVICE::UP";
	        
	        // Log mock (optional: simulate logging or verify)
	        String formattedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm a"));
	        String expectedLogMessage = "Accessing EndPoint using CRON:: " + formattedDate;
	        
	        // Act
	        mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/v1/test")
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.status().isOk())
	                .andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.content().string(expectedResponse));

	        // Assert
	        verify(logger, times(1)).info(expectedLogMessage);
	    }

}
