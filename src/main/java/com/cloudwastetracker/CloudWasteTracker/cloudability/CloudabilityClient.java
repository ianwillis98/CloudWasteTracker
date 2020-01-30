package com.cloudwastetracker.CloudWasteTracker.cloudability;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CloudabilityClient {

	private static final String CLOUDABILITY_RIGHTSIZING_URL = "https://api.cloudability.com/v3/rightsizing/aws/recommendations/ec2?vendorIds={id}";
	private final RestTemplate restTemplete;
	
	public CloudabilityClient() {
		this.restTemplete = null;
	}
}
