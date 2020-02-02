package com.cloudwastetracker.CloudWasteTracker.tracker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import com.cloudwastetracker.CloudWasteTracker.vendor.VendorsModel;

@Controller
public class TrackerController {

	private CloudabilityClient client;
	
}
