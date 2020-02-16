package com.cloudwastetracker.CloudWasteTracker.report;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import com.cloudwastetracker.CloudWasteTracker.rightsizing.RightsizingModel;

@Controller
public class CostReportController {
	 private CloudabilityClient cloudabilityClient;
	 
	 public CostReportController(CloudabilityClient cloudabilityClient) {
	        this.cloudabilityClient = cloudabilityClient;
	    }
	  
	  
}
