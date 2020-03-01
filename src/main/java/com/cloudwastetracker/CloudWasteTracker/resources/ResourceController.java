package com.cloudwastetracker.CloudWasteTracker.resources;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    private CloudabilityClient client;
    private ResourceRepository resourcesRepository;

    public ResourceController(CloudabilityClient client, ResourceRepository resourcesRepository) {
        this.client = client;
        this.resourcesRepository = resourcesRepository;
    }

//    @GetMapping("/resource/{resourceId}")
//    public ResourceModel fetchResources(@PathVariable("resourceId") String resourceId) {
//        return client.fetchResource(resourceId).getBody();
//    }

    @GetMapping("/resource/{resourceId}")
    public Resource fetchResources(@PathVariable("resourceId") String resourceId) {
        return resourcesRepository.findById(resourceId).get();
    }

    @GetMapping("/resources-needing-rightsizing")
    public ResourcesNeedingRightsizingModel fetchResourcesNeedingRightsizing() {
        return this.client.fetchResourcesNeedingRightsizing().getBody();
    }

    @GetMapping("/resources-running-overnight")
    public ResourcesRunningOvernightModel fetchResourcesRunningOvernight() {
        return client.fetchResourcesRunningOvernight().getBody();
    }

}
