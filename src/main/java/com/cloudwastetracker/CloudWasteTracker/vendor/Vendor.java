package com.cloudwastetracker.CloudWasteTracker.vendor;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vendor implements Serializable {

	@Id
	private String vendorKey;

	private String vendorLabel;
	
	private String vendorDescription;

	public Vendor() {

	}

	public String getVendorKey() {
		return vendorKey;
	}
	
	public void setVendorKey(String k) {
		this.vendorKey = k;
	}

	public String getVendorLabel() {
		return vendorLabel;
	}
	
	public void setVendorLabel(String l) {
		this.vendorLabel = l;
	}

	public String getVendorDescription() {
		return vendorDescription;
	}
	
	public void setVendorDescription(String d) {
		this.vendorDescription = d;
	}

}
