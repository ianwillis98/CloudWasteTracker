package com.cloudwastetracker.CloudWasteTracker.utilization;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import com.cloudwastetracker.CloudWasteTracker.resources.ResourcesRunningOvernightModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilizationController {

    private CloudabilityClient client;

    public UtilizationController(CloudabilityClient client) {
        this.client = client;
    }

}
