package com.cloudwastetracker.CloudWasteTracker.cloudability;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CloudabilityClient {

	private static final String CLOUDABILITY_RIGHTSIZING_URL = "https://api.cloudability.com/v3/rightsizing/aws/recommendations/ec2?filters=resourceIdentifier==={id}";
	private final RestTemplate restTemplete;

	public CloudabilityClient(RestTemplateBuilder builder) {
		this.restTemplete = builder.build();
	}

	public ResponseEntity<RightsizingEvent> fetchEvent(String resourceIdentifier) {
		return this.restTemplete.getForEntity(CLOUDABILITY_RIGHTSIZING_URL, RightsizingEvent.class, resourceIdentifier);
	}
	
}
