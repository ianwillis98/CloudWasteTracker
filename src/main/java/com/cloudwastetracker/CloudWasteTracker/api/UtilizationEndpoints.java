package com.cloudwastetracker.CloudWasteTracker.api;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import com.cloudwastetracker.CloudWasteTracker.resources.ResourcesRunningOvernightModel;
import com.cloudwastetracker.CloudWasteTracker.utilization.UtilizationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilizationEndpoints {

    private CloudabilityClient client;

    public UtilizationEndpoints(CloudabilityClient client) {
        this.client = client;
    }

    @GetMapping("/api/cloudability/utilization/{resourceId}")
    public UtilizationModel fetchUtilization(@PathVariable String resourceId) {
        return this.client.fetchUtilization(resourceId).getBody();
    }

}
