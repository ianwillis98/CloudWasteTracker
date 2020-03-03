package com.cloudwastetracker.CloudWasteTracker.rightsizing;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RightsizingController {

    private CloudabilityClient client;

    public RightsizingController(CloudabilityClient client) {
        this.client = client;
    }

    @GetMapping("/rightsizing/{resourceId}")
    public RightsizingModel fetchRightsizing(@PathVariable String resourceId) {
        return this.client.fetchRightsizing(resourceId).getBody();
    }

}
