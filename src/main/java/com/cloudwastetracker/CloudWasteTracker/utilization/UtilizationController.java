package com.cloudwastetracker.CloudWasteTracker.utilization;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilizationController {

    private CloudabilityClient client;

    public UtilizationController(CloudabilityClient client) {
        this.client = client;
    }

    @GetMapping("/utilization")
    public UtilizationReportModel fetchUtilizationReport() {
        return client.fetchUtilizationReport().getBody();
    }

}
