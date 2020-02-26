package com.cloudwastetracker.CloudWasteTracker.cloudability;

import com.cloudwastetracker.CloudWasteTracker.measures.MeasuresModel;
import com.cloudwastetracker.CloudWasteTracker.resource.ResourceModel;
import com.cloudwastetracker.CloudWasteTracker.rightsizing.RightsizingModel;
import com.cloudwastetracker.CloudWasteTracker.utilization.UtilizationReportModel;
import com.cloudwastetracker.CloudWasteTracker.vendor.VendorModels;
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
    private static final String CLOUDABILITY_V1_UTILIZATION_URL = "https://app.cloudability.com/api/1/reporting/run?end_date=yesterday+at+23%3A59%3A59&filters=utilization_hours>0,hour%3D%3D5,tag4!%3D7933,group_name5!%3DProduction,vendor_account_name!%3D%40cp01,product_name%3D%3DAmazon+Elastic+Compute+Cloud&metrics=utilization_hours,estimated_cost&order=desc&sort_by=estimated_cost&start_date=yesterday+at+00%3A00%3A00&dimensions=category5,vendor_account_name,product_name,instance_identifier,tag6,tag5,instance_size,category3,tag7,tag2";
    private static final String CLOUDABILITY_V1_RESOURCE_URL = "https://app.cloudability.com/api/1/reporting/cost/run?end_date=2020-02-25&filters=resource_identifier=={resourceId}&metrics=unblended_cost&order=desc&sort_by=unblended_cost&start_date=2020-02-25&dimensions=resource_identifier,vendor_account_identifier,vendor_account_name,group_name4,tag6,tag5,tag4,category3,category4,item_description,instance_type,tag2,tag7,tag1,group_name5&max_results=1&offset=0";

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

    public ResponseEntity<UtilizationReportModel> fetchUtilizationReport() {
        return this.restTemplateV1.getForEntity(CLOUDABILITY_V1_UTILIZATION_URL, UtilizationReportModel.class);
    }

    public ResponseEntity<ResourceModel> fetchResource(String resourceId) {
        return this.restTemplateV1.getForEntity(CLOUDABILITY_V1_RESOURCE_URL, ResourceModel.class, resourceId);
    }

    public ResponseEntity<VendorModels> fetchVendors() {
        return this.restTemplateV3.getForEntity(CLOUDABILITY_V3_VENDORS_URL, VendorModels.class);
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
