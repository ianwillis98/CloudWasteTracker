package com.cloudwastetracker.CloudWasteTracker.api;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import com.cloudwastetracker.CloudWasteTracker.rightsizing.RightsizingModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RightsizingEndpoints {

    private CloudabilityClient client;

    public RightsizingEndpoints(CloudabilityClient client) {
        this.client = client;
    }

    @GetMapping("/api/cloudability/rightsizing/{resourceId}")
    public RightsizingModel fetchRightsizing(@PathVariable String resourceId) {
        return this.client.fetchRightsizing(resourceId).getBody();
    }

}
