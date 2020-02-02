package com.cloudwastetracker.CloudWasteTracker.vendor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;

@Controller
public class VendorsController {

	private final VendorsRepository vendorsRepository;

	private final CloudabilityClient cloudabilityClient;

	public VendorsController(VendorsRepository vendorsRepository, CloudabilityClient cloudabilityClient) {
		this.vendorsRepository = vendorsRepository;
		this.cloudabilityClient = cloudabilityClient;
	}
	
	@GetMapping("/vendors")
	@ResponseBody
	public VendorsModel fetchVendors() {		
		return this.cloudabilityClient.fetchVendors().getBody();
	}
}
