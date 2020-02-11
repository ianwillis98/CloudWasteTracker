package com.cloudwastetracker.CloudWasteTracker.vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import com.cloudwastetracker.CloudWasteTracker.resources.Resources;
import com.cloudwastetracker.CloudWasteTracker.resources.ResourcesRepository;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorsController {

	private VendorsRepository vendorsRepository;

	@Autowired
	private VendorsRds rds;

	public VendorsController(VendorsRepository vendorsRepository) {
		this.vendorsRepository = vendorsRepository;
	}
	
	@GetMapping("/vendors")
	public Iterable<Vendors> fetchVendors() {
		return vendorsRepository.findAll();
	}

	@GetMapping("/rds")
	public String fetchName() {
		return this.rds.getFirstName();
	}
}