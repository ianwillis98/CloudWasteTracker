package com.cloudwastetracker.CloudWasteTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityProperties;

@SpringBootApplication
@EnableScheduling
public class CloudWasteTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudWasteTrackerApplication.class, args);
	}
}
