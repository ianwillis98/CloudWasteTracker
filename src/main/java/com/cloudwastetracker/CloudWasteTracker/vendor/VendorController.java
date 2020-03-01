package com.cloudwastetracker.CloudWasteTracker.vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {

	private CloudabilityClient client;
	private VendorRepository vendorsRepository;

	@Autowired
	private VendorsRds rds;

	public VendorController(CloudabilityClient client, VendorRepository vendorsRepository) {
		this.client = client;
		this.vendorsRepository = vendorsRepository;
	}
	
	@GetMapping("/vendors")
	public VendorModel fetchVendors() {
		return client.fetchVendors().getBody();
	}

	@GetMapping("/rds")
	public String fetchName() {
		return this.rds.getFirstName();
	}
}