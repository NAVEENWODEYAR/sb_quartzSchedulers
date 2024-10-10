package com.gowri.quartz.controller;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gowri.quartz.job.EmailJob;
import com.gowri.quartz.payload.EmailRequest;
import com.gowri.quartz.payload.EmailResponse;

import jakarta.validation.Valid;

/**
 * @author NaveenWodeyar
 * @date 10-Oct-2024
 * @time 9:17:02 pm
 */
@RestController("/api/v1")
public class EmailSchedulerController {
	
	private static final Logger log = LoggerFactory.getLogger(EmailSchedulerController.class);
	
	@Autowired
	private Scheduler scheduler;
	
	
	@GetMapping
	public ResponseEntity<String> test(){
		return  ResponseEntity.ok("connected!,");
	}
	
	@PostMapping("/email")
	public ResponseEntity<EmailResponse> scheduleEmail(@Valid @RequestBody EmailRequest request){
		try {
			ZonedDateTime dateTime = ZonedDateTime.of(request.getDateTime(), request.getTimeZoneId());
			if (dateTime.isBefore(ZonedDateTime.now())) {
				EmailResponse emailResponse = new EmailResponse(false,"dateTime must be in the future,");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(emailResponse);
			}
			JobDetail jobDetail = buildJobDetail(request);
			Trigger jobTrigger = buildJobTrigger(jobDetail, dateTime);
			
			scheduler.scheduleJob(jobDetail,jobTrigger);
		
			EmailResponse emailResponse = new EmailResponse(true,jobDetail.getKey().getName(),jobDetail.getKey().getGroup(),"Email sent successfully!,");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(emailResponse);
	
		} catch (SchedulerException e) {
			log.error("Error while scheduling the job!,");
			EmailResponse emailResponse = new EmailResponse(false, "Error while scheduling email, Please try again.");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(emailResponse);
		}
	}
	

	private JobDetail buildJobDetail(EmailRequest request) {
		JobDataMap jobDataMap = new JobDataMap();
					jobDataMap.put("email", request.getEmail());
					jobDataMap.put("subject", request.getSubject());
					jobDataMap.put("body", request.getBody());
					
		return JobBuilder.newJob(EmailJob.class)
				.withIdentity(UUID.randomUUID().toString(),"email-jobs")
				.withDescription("send e-mail job")
				.usingJobData(jobDataMap)
				.storeDurably()
				.build();
		
	}
	
	private Trigger buildJobTrigger(JobDetail jobDetail, ZonedDateTime startAt) {
		return TriggerBuilder.newTrigger()
				.forJob(jobDetail)
				.withIdentity(jobDetail.getKey().getName(),"email-triggers")
				.withDescription("Send email triggers")
				.startAt(Date.from(startAt.toInstant()))
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow())
				.build();
	}
	
	
}
