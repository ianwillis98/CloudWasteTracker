package com.cloudwastetracker.CloudWasteTracker.vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import com.cloudwastetracker.CloudWasteTracker.resource.Resource;
import com.cloudwastetracker.CloudWasteTracker.resource.ResourceRepository;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {

	private VendorRepository vendorsRepository;

	@Autowired
	private VendorsRds rds;

	public VendorController(VendorRepository vendorsRepository) {
		this.vendorsRepository = vendorsRepository;
	}
	
	@GetMapping("/vendors")
	public Iterable<Vendor> fetchVendors() {
		return vendorsRepository.findAll();
	}

	@GetMapping("/rds")
	public String fetchName() {
		return this.rds.getFirstName();
	}
}