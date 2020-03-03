package com.cloudwastetracker.CloudWasteTracker.waste;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceWasteController {

    private CloudabilityClient client;
    private ResourceWasteRepository resourceWasteRepository;

    public ResourceWasteController(CloudabilityClient client, ResourceWasteRepository resourceWasteRepository) {
        this.client = client;
        this.resourceWasteRepository = resourceWasteRepository;
    }

    @GetMapping("/waste/{resourceId}")
    public ResourceWaste fetchResourceWaste(@PathVariable String resourceId) {
        return null;
    }

}
