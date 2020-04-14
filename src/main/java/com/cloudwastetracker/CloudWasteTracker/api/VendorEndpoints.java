package com.cloudwastetracker.CloudWasteTracker.api;

import com.cloudwastetracker.CloudWasteTracker.vendor.VendorModel;
import com.cloudwastetracker.CloudWasteTracker.vendor.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorEndpoints {

	private CloudabilityClient client;
	private VendorRepository vendorsRepository;

	public VendorEndpoints(CloudabilityClient client, VendorRepository vendorsRepository) {
		this.client = client;
		this.vendorsRepository = vendorsRepository;
	}
	
	@GetMapping("/api/cloudability/vendors")
	public VendorModel fetchVendors() {
		return client.fetchVendors().getBody();
	}

}