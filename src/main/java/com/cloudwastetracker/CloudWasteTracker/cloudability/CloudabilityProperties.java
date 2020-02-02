package com.cloudwastetracker.CloudWasteTracker.cloudability;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ConfigurationProperties("cloudability")
@ConstructorBinding
@PropertySource("classpath:a.properties")
public class CloudabilityProperties {

	private String apiKey;

	private String password;
	
	public CloudabilityProperties(String apiKey, String password) {
		this.apiKey = apiKey;
		this.password = password;
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getPassword() {
		return password;
	}
}
