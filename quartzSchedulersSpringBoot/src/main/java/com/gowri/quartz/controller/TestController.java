package com.gowri.quartz.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author NaveenWodeyar
 * @date 24-Dec-2024
 * @time 10:25:13 pm
 */
@RestController
@RequestMapping("/v1/test")
public class TestController {
	
	private static final Logger log = LoggerFactory.getLogger(TestController.class);
	
	@GetMapping
	public String testEndPoint() {
		log.info("Accessing EndPoint using CRON:: {}",
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm a")));
		return "SERVICE::UP";
	}

}
