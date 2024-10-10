package com.gowri.quartz.payload;

import java.util.Objects;

/**
 * @author NaveenWodeyar
 * @date 10-Oct-2024
 * @time 9:13:00 pm
 */
public class EmailResponse {

	private boolean success;
	
	private String jobId;
	
	private String jobGroup;
	
	private String message;
	
	public EmailResponse() {}

	/**
	 * @param success
	 * @param jobId
	 * @param jobGroup
	 * @param message
	 */
	public EmailResponse(boolean success, String jobId, String jobGroup, String message) {
		super();
		this.success = success;
		this.jobId = jobId;
		this.jobGroup = jobGroup;
		this.message = message;
	}

	public EmailResponse(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the jobId
	 */
	public String getJobId() {
		return jobId;
	}

	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return the jobGroup
	 */
	public String getJobGroup() {
		return jobGroup;
	}

	/**
	 * @param jobGroup the jobGroup to set
	 */
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		return Objects.hash(jobGroup, jobId, message, success);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailResponse other = (EmailResponse) obj;
		return Objects.equals(jobGroup, other.jobGroup) && Objects.equals(jobId, other.jobId)
				&& Objects.equals(message, other.message) && success == other.success;
	}

	@Override
	public String toString() {
		return "EmailResponse [success=" + success + ", jobId=" + jobId + ", jobGroup=" + jobGroup + ", message="
				+ message + "]";
	}
	
	
}
