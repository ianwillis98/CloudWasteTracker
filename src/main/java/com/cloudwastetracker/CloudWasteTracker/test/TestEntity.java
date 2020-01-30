package com.cloudwastetracker.CloudWasteTracker.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String name;
	
	public TestEntity() {
		
	}
	
	public TestEntity(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() { 
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
