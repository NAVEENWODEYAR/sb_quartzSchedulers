package com.gowri.quartz.payload;
/**
 * @author NaveenWodeyar
 * @date 10-Oct-2024
 * @time 9:09:03 pm
 */

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class EmailRequest {
	
	@Email
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String subject;
	
	@NotEmpty
	private String body;
	
	@NotNull
	private LocalDateTime dateTime;
	
	@NotNull
	private ZoneId timeZoneId;
	
	public EmailRequest() {}

	/**
	 * @param email
	 * @param subject
	 * @param body
	 * @param dateTime
	 * @param timeZoneId
	 */
	public EmailRequest(@Email @NotEmpty String email, @NotEmpty String subject, @NotEmpty String body,
			@NotNull LocalDateTime dateTime, @NotNull ZoneId timeZoneId) {
		super();
		this.email = email;
		this.subject = subject;
		this.body = body;
		this.dateTime = dateTime;
		this.timeZoneId = timeZoneId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the dateTime
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the timeZoneId
	 */
	public ZoneId getTimeZoneId() {
		return timeZoneId;
	}

	/**
	 * @param timeZoneId the timeZoneId to set
	 */
	public void setTimeZoneId(ZoneId timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(body, dateTime, email, subject, timeZoneId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailRequest other = (EmailRequest) obj;
		return Objects.equals(body, other.body) && Objects.equals(dateTime, other.dateTime)
				&& Objects.equals(email, other.email) && Objects.equals(subject, other.subject)
				&& Objects.equals(timeZoneId, other.timeZoneId);
	}

	@Override
	public String toString() {
		return "EmailRequest [email=" + email + ", subject=" + subject + ", body=" + body + ", dateTime=" + dateTime
				+ ", timeZoneId=" + timeZoneId + "]";
	}
	
	

}
