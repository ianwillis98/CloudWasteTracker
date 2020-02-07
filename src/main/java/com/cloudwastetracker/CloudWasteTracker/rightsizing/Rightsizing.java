package com.cloudwastetracker.CloudWasteTracker.rightsizing;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rightsizing implements Serializable{
	@Id
	private int id;

	private String resourceIdentifier;

	private String vendorAccountId;

	private String date;

	private String time;

	private double totalSpend;

	private double totalWaste;

	private String nodeType;

	private int localCapacity;

	private int localDrives;

	private int cpuCapacity;

	private int memoryCapacity;

	private int cpuMax;

	private int memoryMax;
	

	public Rightsizing(int id, String resourceIdentifier, String vendorAccountId, double totalSpend,
			double totalWaste, String nodeType, int localCapacity, int localDrives, int cpuCapacity, int memoryCapacity,
			int cpuMax, int memoryMax) {
		Date date = new Date();
		this.id = id;
		this.resourceIdentifier = resourceIdentifier;
		this.vendorAccountId = vendorAccountId;
		SimpleDateFormat temp = new SimpleDateFormat("dd-MM-yyyy");
		this.date = temp.format(date);
		temp = new SimpleDateFormat("HH:mm:ss");
		this.time = temp.format(date);
		this.totalSpend = totalSpend;
		this.totalWaste = totalWaste;
		this.nodeType = nodeType;
		this.localCapacity = localCapacity;
		this.localDrives = localDrives;
		this.cpuCapacity = cpuCapacity;
		this.memoryCapacity = memoryCapacity;
		this.cpuMax = cpuMax;
		this.memoryMax = memoryMax;

	}
	
	public int getid() {
		return id;
	}
	
	public String getResourceIdentifier() {
		return resourceIdentifier;
	}

	public String getVendorAccountId() {
		return vendorAccountId;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public double getTotalSpend() {
		return totalSpend;
	}

	public double getTotalWaste() {
		return totalWaste;
	}

	public String getNodeType() {
		return nodeType;
	}

	public int getLocalCapacity() {
		return localCapacity;
	}

	public int getLocalDrives() {
		return localDrives;
	}

	public int getCpuCapacity() {
		return cpuCapacity;
	}

	public int getMemoryCapacity() {
		return memoryCapacity;
	}

	public int getCpuMax() {
		return cpuMax;
	}

	public int getMemoryMax() {
		return memoryMax;
	}

}
