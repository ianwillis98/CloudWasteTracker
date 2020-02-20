package com.cloudwastetracker.CloudWasteTracker.cloudability;

import com.cloudwastetracker.CloudWasteTracker.measures.MeasuresModel;
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

@Component
public class CloudabilityClient {

    private static final String CLOUDABILITY_V1_MEASURES_URL = "https://app.cloudability.com/api/1/reporting/cost/measures";

    private static final String CLOUDABILITY_V3_RIGHTSIZING_URL = "https://api.cloudability.com/v3/rightsizing/aws/recommendations/ec2?filters=resourceIdentifier=={resourceIdentifier}&rank=default&maxRecsPerResource=1";
    private static final String CLOUDABILITY_V3_VENDORS_URL = "https://api.cloudability.com/v3/vendors";

    private final RestTemplate restTemplateV1;
    private final RestTemplate restTemplateV3;

    public CloudabilityClient(RestTemplateBuilder builder, CloudabilityProperties properties) {
        this.restTemplateV1 = builder.additionalInterceptors(
                new CloudabilityV1TokenInterceptor(properties.getEmail(), properties.getPassword())).build();
        this.restTemplateV3 = builder.additionalInterceptors(
                new CloudabilityV3TokenInterceptor(properties.getApiKey(), properties.getPassword())).build();
    }

    public ResponseEntity<MeasuresModel[]> fetchMeasures() {
        return this.restTemplateV1.getForEntity(CLOUDABILITY_V1_MEASURES_URL, MeasuresModel[].class);
    }

    public ResponseEntity<VendorsModel> fetchVendors() {
        return this.restTemplateV3.getForEntity(CLOUDABILITY_V3_VENDORS_URL, VendorsModel.class);
    }

    public ResponseEntity<RightsizingModel> fetchRightsizing(String resourceIdentifier) {
        return this.restTemplateV3.getForEntity(CLOUDABILITY_V3_RIGHTSIZING_URL, RightsizingModel.class, resourceIdentifier);
    }

    public ResponseEntity<String> fetchRightsizingString(String resourceIdentifier) {
        return this.restTemplateV3.getForEntity(CLOUDABILITY_V3_RIGHTSIZING_URL, String.class, resourceIdentifier);
    }

    private static class CloudabilityV1TokenInterceptor implements ClientHttpRequestInterceptor {

        private final String email;
        private final String password;

        CloudabilityV1TokenInterceptor(String email, String password) {
            this.email = email;
            this.password = password;
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
                throws IOException {
            if (StringUtils.hasText(this.email) && StringUtils.hasText(this.password)) {
                String token = email + ":" + password;
                byte[] basicAuthValue = token.getBytes(StandardCharsets.UTF_8);
                request.getHeaders().set(HttpHeaders.AUTHORIZATION,
                        "Basic " + Base64Utils.encodeToString(basicAuthValue));
            }
            return execution.execute(request, body);
        }
    }

    private static class CloudabilityV3TokenInterceptor implements ClientHttpRequestInterceptor {

        private final String apiKey;
        private final String password;

        CloudabilityV3TokenInterceptor(String apiKey, String password) {
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
