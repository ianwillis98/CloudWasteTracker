package com.cloudwastetracker.CloudWasteTracker.cloudability;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:secrets.properties")
public class CloudabilityProperties {

	@Value("${CloudabilityApiKey}")
	private String apiKey;
	@Value("${CloudabilityPassword}")
	private String password;

	public String getApiKey() {
		return apiKey;
	}

	public String getPassword() {
		return password;
	}

}
