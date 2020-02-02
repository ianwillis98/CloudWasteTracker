package com.cloudwastetracker.CloudWasteTracker.vendor;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vendor implements Serializable {

	@Id
	private String key;

	private String label;

	private String description;

	public Vendor() {

	}

	public Vendor(String key, String label, String description) {
		this.key = key;
		this.label = label;
		this.description = description;
	}

	public String getKey() {
		return key;
	}

	public String getLabel() {
		return label;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Vendor{" + "key=" + key + ", label=" + label + ", description=" + description + "}";
	}
}
