package com.gowri.quartz.job;

import java.nio.charset.StandardCharsets;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

/**
 * @author NaveenWodeyar
 * @date 10-Oct-2024
 * @time 9:26:13 pm
 */
@Component
public class EmailJob extends QuartzJobBean {
	
	private static final Logger log = LoggerFactory.getLogger(EmailJob.class);

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private MailProperties mailProperties;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		JobDataMap dataMap =  context.getMergedJobDataMap();
		
		String email = dataMap.getString("email");
		String subject = dataMap.getString("subject");
		String body = dataMap.getString("body");

		sendMail(mailProperties.getUsername(), email, subject, body);
	}

	private void sendMail(String fromMail, String toMail,String subject, String body) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.toString());
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(body);
			mimeMessageHelper.setFrom(fromMail);
			mimeMessageHelper.setTo(toMail);
			
			javaMailSender.send(mimeMessage);
			
		} catch (MessagingException e) {
			System.out.println(e);
			log.warn("Error while sending mail,");
		}
	}
}
