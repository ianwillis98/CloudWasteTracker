package com.cloudwastetracker.CloudWasteTracker.Record;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reports implements Serializable {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	
	@Column(name = "time")
	private Timestamp time_stamp;
	
	private double money_spent;
	
	private double money_wasted;
	
	private String server_type;
	
	private double local_capacity;
	
	private double local_drives;
	
	private double cpu_capacity;
	
	private double memory_capacity;
	
	private String resource_id;

	
	public Reports() {
		
	}

	public Timestamp getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(Timestamp time_stamp) {
		this.time_stamp = time_stamp;
	}

	public double getMoney_spent() {
		return money_spent;
	}

	public void setMoney_spent(double money_spent) {
		this.money_spent = money_spent;
	}

	public double getMoney_wasted() {
		return money_wasted;
	}

	public void setMoney_wasted(double money_wasted) {
		this.money_wasted = money_wasted;
	}

	public String getServer_type() {
		return server_type;
	}

	public void setServer_type(String server_type) {
		this.server_type = server_type;
	}

	public double getLocal_capacity() {
		return local_capacity;
	}

	public void setLocal_capacity(double local_capacity) {
		this.local_capacity = local_capacity;
	}

	public double getLocal_drives() {
		return local_drives;
	}

	public void setLocal_drives(double local_drives) {
		this.local_drives = local_drives;
	}

	public double getCpu_capacity() {
		return cpu_capacity;
	}

	public void setCpu_capacity(double cpu_capacity) {
		this.cpu_capacity = cpu_capacity;
	}

	public double getMemory_capacity() {
		return memory_capacity;
	}

	public void setMemory_capacity(double memory_capacity) {
		this.memory_capacity = memory_capacity;
	}

	public String getResource_id() {
		return resource_id;
	}

	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}
}