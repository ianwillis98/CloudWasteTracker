package com.cloudwastetracker.CloudWasteTracker.rightsizing;

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
public class RightsizingRecord implements Serializable {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	
	private Timestamp timeStamp;
	
	private double moneySpent;
	
	private double moneyWasted;
	
	private String serverType;
	
	private double localCapacity;
	
	private double localDrives;
	
	private double cpuCapacity;
	
	private double memoryCapacity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resource_id")
	private Resource resource;

	
	public RightsizingRecord() {
		
	}


	public Timestamp getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}


	public double getMoneySpent() {
		return moneySpent;
	}


	public void setMoneySpent(double moneySpent) {
		this.moneySpent = moneySpent;
	}


	public double getMoneyWasted() {
		return moneyWasted;
	}


	public void setMoneyWasted(double moneyWasted) {
		this.moneyWasted = moneyWasted;
	}


	public String getServerType() {
		return serverType;
	}


	public void setServerType(String serverType) {
		this.serverType = serverType;
	}


	public double getLocalCapacity() {
		return localCapacity;
	}


	public void setLocalCapacity(double localCapacity) {
		this.localCapacity = localCapacity;
	}


	public double getLocalDrives() {
		return localDrives;
	}


	public void setLocalDrives(double localDrives) {
		this.localDrives = localDrives;
	}


	public double getCpuCapacity() {
		return cpuCapacity;
	}


	public void setCpuCapacity(double cpuCapacity) {
		this.cpuCapacity = cpuCapacity;
	}


	public double getMemoryCapacity() {
		return memoryCapacity;
	}


	public void setMemoryCapacity(double memoryCapacity) {
		this.memoryCapacity = memoryCapacity;
	}
	
	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}
}