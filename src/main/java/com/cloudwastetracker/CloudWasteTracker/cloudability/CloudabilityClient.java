package com.cloudwastetracker.CloudWasteTracker.cloudability;

import com.cloudwastetracker.CloudWasteTracker.resources.ResourceModel;
import com.cloudwastetracker.CloudWasteTracker.resources.ResourcesNeedingRightsizingModel;
import com.cloudwastetracker.CloudWasteTracker.resources.ResourcesRunningOvernightModel;
import com.cloudwastetracker.CloudWasteTracker.rightsizing.RightsizingModel;
import com.cloudwastetracker.CloudWasteTracker.utilization.UtilizationModel;
import com.cloudwastetracker.CloudWasteTracker.vendor.VendorModel;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class CloudabilityClient {

    private static final String CLOUDABILITY_V1_RESOURCES_RUNNING_OVERNIGHT_URL = "https://app.cloudability.com/api/1/reporting/run?end_date=yesterday+at+23%3A59%3A59&filters=utilization_hours>0,hour%3D%3D5,tag4!%3D7933,group_name5!%3DProduction,vendor_account_name!%3D%40cp01,product_name%3D%3DAmazon+Elastic+Compute+Cloud&metrics=utilization_hours,estimated_cost&order=desc&sort_by=estimated_cost&start_date=yesterday+at+00%3A00%3A00&dimensions=instance_identifier,tag2,tag7,date&max_results=50&offset=0";
    private static final String CLOUDABILITY_V1_RESOURCE_URL = "https://app.cloudability.com/api/1/reporting/cost/run?end_date=2020-02-25&filters=resource_identifier=={resourceId}&metrics=unblended_cost&order=desc&sort_by=unblended_cost&start_date=2020-02-25&dimensions=vendor_account_identifier,vendor_account_name,group_name4,tag6,tag5,tag4,category3,category4,item_description,instance_type,tag2,tag7,tag1,group_name5&max_results=1&offset=0";
    private static final String CLOUDABILITY_V1_UTILIZATION_URL = "https://app.cloudability.com/api/1/reporting/run?end_date=yesterday+at+23%3A59%3A59&filters=instance_identifier=={resourceId}&metrics=utilization_hours,estimated_cost&order=desc&sort_by=estimated_cost&start_date=yesterday+at+00%3A00%3A00&dimensions=instance_identifier,tag2,tag7,date";

    private static final String CLOUDABILITY_V3_RIGHTSIZING_URL = "https://api.cloudability.com/v3/rightsizing/aws/recommendations/ec2?filters=resourceIdentifier=={resourceId}&maxRecsPerResource=1&rank=preference";
    private static final String CLOUDABILITY_V3_RESOURCES_NEEDING_RIGHTSIZING_URL = "https://api.cloudability.com/v3/rightsizing/aws/recommendations/ec2?rank=default&maxRecsPerResource=1&offset=0&sort=-recommendations.savings&limit=50&duration=ten-day";
    private static final String CLOUDABILITY_V3_VENDORS_URL = "https://api.cloudability.com/v3/vendors";

    private final RestTemplate restTemplateV1;
    private final RestTemplate restTemplateV3;

    public CloudabilityClient(RestTemplateBuilder builder, CloudabilityProperties properties) {
        this.restTemplateV1 = builder.additionalInterceptors(
                new CloudabilityV1TokenInterceptor(properties.getEmail(), properties.getPassword())).errorHandler(new CloudabilityErrorHandler()).build();
        this.restTemplateV3 = builder.additionalInterceptors(
                new CloudabilityV3TokenInterceptor(properties.getApiKey(), properties.getPassword())).errorHandler(new CloudabilityErrorHandler()).build();
    }

    public ResponseEntity<ResourcesRunningOvernightModel> fetchResourcesRunningOvernight() {
        return this.restTemplateV1.getForEntity(CLOUDABILITY_V1_RESOURCES_RUNNING_OVERNIGHT_URL, ResourcesRunningOvernightModel.class);
    }

    public ResponseEntity<ResourceModel> fetchResource(String resourceId) {
        return this.restTemplateV1.getForEntity(CLOUDABILITY_V1_RESOURCE_URL, ResourceModel.class, resourceId);
    }

    public ResponseEntity<UtilizationModel> fetchUtilization(String resourceId) {
        return this.restTemplateV1.getForEntity(CLOUDABILITY_V1_UTILIZATION_URL, UtilizationModel.class, resourceId);
    }

    public ResponseEntity<VendorModel> fetchVendors() {
        return this.restTemplateV3.getForEntity(CLOUDABILITY_V3_VENDORS_URL, VendorModel.class);
    }

    public ResponseEntity<ResourcesNeedingRightsizingModel> fetchResourcesNeedingRightsizing() {
        return this.restTemplateV3.getForEntity(CLOUDABILITY_V3_RESOURCES_NEEDING_RIGHTSIZING_URL, ResourcesNeedingRightsizingModel.class);
    }

    public ResponseEntity<RightsizingModel> fetchRightsizing(String resourceId) {
        return this.restTemplateV3.getForEntity(CLOUDABILITY_V3_RIGHTSIZING_URL, RightsizingModel.class, resourceId);
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

    public static class CloudabilityErrorHandler extends DefaultResponseErrorHandler {

        private static Logger logger = LogManager.getLogger();

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            logger.log(Level.ERROR, "Error during cloudability api call = " + response.getRawStatusCode() + " : " + response.getBody());
            response.close();
        }
    }
}
