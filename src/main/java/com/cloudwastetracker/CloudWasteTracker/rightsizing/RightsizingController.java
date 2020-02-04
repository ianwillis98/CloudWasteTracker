package com.cloudwastetracker.CloudWasteTracker.rightsizing;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import com.cloudwastetracker.CloudWasteTracker.vendor.VendorsModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RightsizingController {

    private CloudabilityClient cloudabilityClient;

    public RightsizingController(CloudabilityClient cloudabilityClient) {
        this.cloudabilityClient = cloudabilityClient;
    }

    @GetMapping("/rightsizing/{resourceIdentifier}")
    @ResponseBody
    public RightsizingModel fetchVendors(@PathVariable String resourceIdentifier) {
        return this.cloudabilityClient.fetchRightsizing(resourceIdentifier).getBody();
    }
}
