package com.cloudwastetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.cloudwastetracker.model.Vendor;

@Service
public class CloudabilityService {
	
	@Value("${cloudability_api_username}")
	private String username;
	
	@Value("${cloudability_api_password}")
	private String password;
	
	@Autowired
	private WebClient.Builder builder;
	
	@Autowired
	private RestTemplate template;
	
	public Vendor getVendors() {
		System.out.println("Ian here " + username + " " + password);
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(username, password);		
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Vendor> response = template.exchange("https://api.cloudability.com/v3/vendors", HttpMethod.GET,
				entity, Vendor.class);
		
		return response.getBody();
	}
}
