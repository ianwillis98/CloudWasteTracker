package com.cloudwastetracker.CloudWasteTracker.record;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Record implements Serializable {
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
	
	private String resourceId;

	
	public Record() {
		
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


	public String getResourceId() {
		return resourceId;
	}


	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	
}