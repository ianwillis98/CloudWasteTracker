package com.cloudwastetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.cloudwastetracker.model.Vendor;

@SpringBootApplication
public class CloudWasteTrackerApplication {

	@Bean
	public WebClient.Builder getWebClient() {
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth("username", "password");

		return WebClient.builder().defaultHeader("Authorization", headers.get("Authorization").get(0));
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext cfc = SpringApplication.run(CloudWasteTrackerApplication.class, args);
		CloudabilityService cs = cfc.getBean(CloudabilityService.class);
		System.out.println("Ian here3 " + cs);
		Vendor v = cs.getVendors();
		System.out.println("Ian here4 " + v.result.get(0).key);
	}

}
