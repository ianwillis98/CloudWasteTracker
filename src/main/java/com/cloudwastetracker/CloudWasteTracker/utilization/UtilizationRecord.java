package com.cloudwastetracker.CloudWasteTracker.utilization;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cloudwastetracker.CloudWasteTracker.resources.Resource;

@Entity
public class UtilizationRecord implements Serializable {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	
	private Timestamp timeStamp;
	
	private String billingAccount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resource_id")
	private Resource resource;
	
	private String resourceName;
	
	private String resourceOwner;
	
	private String serverType;
	
	private String applicationName;
	
	private String instanceTurnOffTime;
	
	private String instanceTurnOnTime;
	
	private Double estimatedCost;

	public UtilizationRecord() {
		
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getBillingAccount() {
		return billingAccount;
	}

	public void setBillingAccount(String billingAccount) {
		this.billingAccount = billingAccount;
	}

	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceOwner() {
		return resourceOwner;
	}

	public void setResourceOwner(String resourceOwner) {
		this.resourceOwner = resourceOwner;
	}

	public String getServerType() {
		return serverType;
	}

	public void setServerType(String serverType) {
		this.serverType = serverType;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getInstanceTurnOffTime() {
		return instanceTurnOffTime;
	}

	public void setInstanceTurnOffTime(String instanceTurnOffTime) {
		this.instanceTurnOffTime = instanceTurnOffTime;
	}

	public String getInstanceTurnOnTime() {
		return instanceTurnOnTime;
	}

	public void setInstanceTurnOnTime(String instanceTurnOnTime) {
		this.instanceTurnOnTime = instanceTurnOnTime;
	}

	public Double getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(Double estimatedCost) {
		this.estimatedCost = estimatedCost;
	}
}
