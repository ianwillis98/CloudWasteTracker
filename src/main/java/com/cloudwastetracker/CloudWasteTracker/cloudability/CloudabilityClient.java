package com.cloudwastetracker.CloudWasteTracker.cloudability;

import com.cloudwastetracker.CloudWasteTracker.measures.MeasuresModel;
import com.cloudwastetracker.CloudWasteTracker.rightsizing.Rightsizing;
import com.cloudwastetracker.CloudWasteTracker.rightsizing.RightsizingModel;
import com.cloudwastetracker.CloudWasteTracker.vendor.VendorsModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class CloudabilityClient {

    private static final String CLOUDABILITY_RIGHTSIZING_URL = "https://api.cloudability.com/v3/rightsizing/aws/recommendations/ec2?filters=resourceIdentifier=={resourceIdentifier}&rank=default&maxRecsPerResource=1";
    private static final String CLOUDABILITY_VENDORS_URL = "https://api.cloudability.com/v3/vendors";
    private static final String CLOUDABILITY_MEASURES_URL = "https://app.cloudability.com/api/1/reporting/cost/measures";

    private String cloudabilityApiKey;
    private String cloudabilityPassword;

    private final RestTemplate restTemplete;

    public CloudabilityClient(RestTemplateBuilder builder, CloudabilityProperties properties) {
        this.restTemplete = builder.additionalInterceptors(
                new CloudabilityTokenInterceptor(properties.getApiKey(), properties.getPassword())).build();
    }

    public ResponseEntity<VendorsModel> fetchVendors() {
        return this.restTemplete.getForEntity(CLOUDABILITY_VENDORS_URL, VendorsModel.class);
    }

    public ResponseEntity<RightsizingModel> fetchRightsizing(String resourceIdentifier) {
        return this.restTemplete.getForEntity(CLOUDABILITY_RIGHTSIZING_URL, RightsizingModel.class, resourceIdentifier);
    }

    public ResponseEntity<String> fetchRightsizingString(String resourceIdentifier) {
        return this.restTemplete.getForEntity(CLOUDABILITY_RIGHTSIZING_URL, String.class, resourceIdentifier);
    }

    public ResponseEntity<MeasuresModel[]> fetchMeasures() {
        return this.restTemplete.getForEntity(CLOUDABILITY_MEASURES_URL, MeasuresModel[].class);
    }

    private static class CloudabilityTokenInterceptor implements ClientHttpRequestInterceptor {

        private final String apiKey;
        private final String password;

        CloudabilityTokenInterceptor(String apiKey, String password) {
            this.apiKey = apiKey;
            this.password = password;
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
                throws IOException {
            if (StringUtils.hasText(this.apiKey) && StringUtils.hasText(this.password)) {
                String token = apiKey + ":" + password;
                byte[] basicAuthValue = token.getBytes(StandardCharsets.UTF_8);
                request.getHeaders().set(HttpHeaders.AUTHORIZATION,
                        "Basic " + Base64Utils.encodeToString(basicAuthValue));
            }
            return execution.execute(request, body);
        }
    }
}
