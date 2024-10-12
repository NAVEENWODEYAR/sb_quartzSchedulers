package com.gowri.quartz.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author NaveenWodeyar
 * @date 11-Oct-2024
 * @time 10:21:42 pm
 */
public class TriggerInfo implements Serializable{
	
    private static final long serialVersionUID = 1L;

	private int triggerCount;
	
	private boolean isRunForEver;
	
	private Long timeInterval;
	
	private Long initialOffSet;
	
	private String info;
	
	public TriggerInfo() {}

	/**
	 * @param triggerCount
	 * @param isRunForEver
	 * @param timeInterval
	 * @param initialOffSet
	 * @param info
	 */
	public TriggerInfo(int triggerCount, boolean isRunForEver, Long timeInterval, Long initialOffSet, String info) {
		super();
		this.triggerCount = triggerCount;
		this.isRunForEver = isRunForEver;
		this.timeInterval = timeInterval;
		this.initialOffSet = initialOffSet;
		this.info = info;
	}

	/**
	 * @return the triggerCount
	 */
	public int getTriggerCount() {
		return triggerCount;
	}

	/**
	 * @param triggerCount the triggerCount to set
	 */
	public void setTriggerCount(int triggerCount) {
		this.triggerCount = triggerCount;
	}

	/**
	 * @return the isRunForEver
	 */
	public boolean isRunForEver() {
		return isRunForEver;
	}

	/**
	 * @param isRunForEver the isRunForEver to set
	 */
	public void setRunForEver(boolean isRunForEver) {
		this.isRunForEver = isRunForEver;
	}

	/**
	 * @return the timeInterval
	 */
	public Long getTimeInterval() {
		return timeInterval;
	}

	/**
	 * @param timeInterval the timeInterval to set
	 */
	public void setTimeInterval(Long timeInterval) {
		this.timeInterval = timeInterval;
	}

	/**
	 * @return the initialOffSet
	 */
	public Long getInitialOffSet() {
		return initialOffSet;
	}

	/**
	 * @param initialOffSet the initialOffSet to set
	 */
	public void setInitialOffSet(Long initialOffSet) {
		this.initialOffSet = initialOffSet;
	}

	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public int hashCode() {
		return Objects.hash(info, initialOffSet, isRunForEver, timeInterval, triggerCount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TriggerInfo other = (TriggerInfo) obj;
		return Objects.equals(info, other.info) && Objects.equals(initialOffSet, other.initialOffSet)
				&& isRunForEver == other.isRunForEver && Objects.equals(timeInterval, other.timeInterval)
				&& triggerCount == other.triggerCount;
	}

	@Override
	public String toString() {
		return "TriggerInfo [triggerCount=" + triggerCount + ", isRunForEver=" + isRunForEver + ", timeInterval="
				+ timeInterval + ", initialOffSet=" + initialOffSet + ", info=" + info + "]";
	}
	
	
}
