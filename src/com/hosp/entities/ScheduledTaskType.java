package com.hosp.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ScheduledTaskType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCHEDULED_TASK_TYPE", schema = "HOSPITAL")
public class ScheduledTaskType implements java.io.Serializable {

	// Fields

	private Integer typeId;
	private String name;
	private Byte maxRetries;
	private Long retryTimeout;
	private Byte hhFrom;
	private Byte hhTo;
	private BigDecimal maxExecutionTime;
	private String schedulePlan;
	private String className;
	private Boolean needResources;

	// Constructors

	/** default constructor */
	public ScheduledTaskType() {
	}

	/** minimal constructor */
	public ScheduledTaskType(Integer typeId, Boolean needResources) {
		this.typeId = typeId;
		this.needResources = needResources;
	}

	/** full constructor */
	public ScheduledTaskType(Integer typeId, String name, Byte maxRetries, Long retryTimeout, Byte hhFrom, Byte hhTo, BigDecimal maxExecutionTime,
			String schedulePlan, String className, Boolean needResources) {
		this.typeId = typeId;
		this.name = name;
		this.maxRetries = maxRetries;
		this.retryTimeout = retryTimeout;
		this.hhFrom = hhFrom;
		this.hhTo = hhTo;
		this.maxExecutionTime = maxExecutionTime;
		this.schedulePlan = schedulePlan;
		this.className = className;
		this.needResources = needResources;
	}

	// Property accessors
	@Id
	@Column(name = "TYPE_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Column(name = "NAME", length = 80)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "MAX_RETRIES", precision = 2, scale = 0)
	public Byte getMaxRetries() {
		return this.maxRetries;
	}

	public void setMaxRetries(Byte maxRetries) {
		this.maxRetries = maxRetries;
	}

	@Column(name = "RETRY_TIMEOUT", precision = 10, scale = 0)
	public Long getRetryTimeout() {
		return this.retryTimeout;
	}

	public void setRetryTimeout(Long retryTimeout) {
		this.retryTimeout = retryTimeout;
	}

	@Column(name = "HH_FROM", precision = 2, scale = 0)
	public Byte getHhFrom() {
		return this.hhFrom;
	}

	public void setHhFrom(Byte hhFrom) {
		this.hhFrom = hhFrom;
	}

	@Column(name = "HH_TO", precision = 2, scale = 0)
	public Byte getHhTo() {
		return this.hhTo;
	}

	public void setHhTo(Byte hhTo) {
		this.hhTo = hhTo;
	}

	@Column(name = "MAX_EXECUTION_TIME", precision = 38, scale = 0)
	public BigDecimal getMaxExecutionTime() {
		return this.maxExecutionTime;
	}

	public void setMaxExecutionTime(BigDecimal maxExecutionTime) {
		this.maxExecutionTime = maxExecutionTime;
	}

	@Column(name = "SCHEDULE_PLAN", length = 80)
	public String getSchedulePlan() {
		return this.schedulePlan;
	}

	public void setSchedulePlan(String schedulePlan) {
		this.schedulePlan = schedulePlan;
	}

	@Column(name = "CLASS_NAME", length = 512)
	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name = "NEED_RESOURCES", nullable = false, precision = 1, scale = 0)
	public Boolean getNeedResources() {
		return this.needResources;
	}

	public void setNeedResources(Boolean needResources) {
		this.needResources = needResources;
	}

}