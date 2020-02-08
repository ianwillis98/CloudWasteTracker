package com.cloudwastetracker.CloudWasteTracker.reports;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*needs a rest controller and a table in db*/
@Entity
public class Reports implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	//add columns
	//@Column(name = "")
	private String resourceIdentifier;
	
	private String vendorAccountId;

	private Timestamp time;

	private double totalSpend;

	private double totalWaste;

	private String nodeType;

	private double localCapacity;

	private double localDrives;

	private double cpuCapacity;

	private double memoryCapacity;

	private double cpuMax;

	private double memoryMax;
	
	public Reports() {
		
	}

	public String getResourceIdentifier() {
		return resourceIdentifier;
	}

	public void setResourceIdentifier(String resourceIdentifier) {
		this.resourceIdentifier = resourceIdentifier;
	}

	public String getVendorAccountId() {
		return vendorAccountId;
	}

	public void setVendorAccountId(String vendorAccountId) {
		this.vendorAccountId = vendorAccountId;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public double getTotalSpend() {
		return totalSpend;
	}

	public void setTotalSpend(double totalSpend) {
		this.totalSpend = totalSpend;
	}

	public double getTotalWaste() {
		return totalWaste;
	}

	public void setTotalWaste(double totalWaste) {
		this.totalWaste = totalWaste;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
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

	public double getCpuMax() {
		return cpuMax;
	}

	public void setCpuMax(double cpuMax) {
		this.cpuMax = cpuMax;
	}

	public double getMemoryMax() {
		return memoryMax;
	}

	public void setMemoryMax(double memoryMax) {
		this.memoryMax = memoryMax;
	}
	
	
	

}
