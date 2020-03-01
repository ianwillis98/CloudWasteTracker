package com.cloudwastetracker.CloudWasteTracker.rightsizing;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import com.cloudwastetracker.CloudWasteTracker.resources.ResourcesNeedingRightsizingModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RightsizingController {

    private CloudabilityClient cloudabilityClient;

    public RightsizingController(CloudabilityClient cloudabilityClient) {
        this.cloudabilityClient = cloudabilityClient;
    }

}
