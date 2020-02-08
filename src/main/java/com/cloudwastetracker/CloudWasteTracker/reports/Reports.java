package com.cloudwastetracker.CloudWasteTracker.reports;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Reports")
@Entity
public class Reports {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	//add columns
	//@Column(name = "")
	@Column(name = "resource_id")
	private String resourceIdentifier;
	
	@Column (name = "vendor_account_id")
	private String vendorAccountId;

	@Column (name = "timestamp")
	private Timestamp time;
	
	@Column(name = "total_money_spent")
	private double totalSpend;

	@Column(name = "total_money_wasted")
	private double totalWaste;

	@Column(name = "server_type")
	private String nodeType;

	@Column(name = "local_capacity")
	private double localCapacity;

	@Column(name = "local_drives")
	private double localDrives;

	@Column(name = "cpu_capacity")
	private double cpuCapacity;
	
	@Column(name = "memory_capacity")
	private double memoryCapacity;

	@Column(name = "cpu_max")
	private double cpuMax;

	@Column(name = "memory_max")
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
