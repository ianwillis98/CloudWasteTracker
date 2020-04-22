package com.cloudwastetracker.CloudWasteTracker.api;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import com.cloudwastetracker.CloudWasteTracker.resources.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResourceEndpoints {

    private CloudabilityClient client;
    private ResourceRepository resourcesRepository;

    public ResourceEndpoints(CloudabilityClient client, ResourceRepository resourcesRepository) {
        this.client = client;
        this.resourcesRepository = resourcesRepository;
    }

    @GetMapping("/api/resource")
    public List<Resource> fetchResources() {
        return resourcesRepository.findAll();
    }

    @GetMapping("/api/resource/{resourceId}")
    public Resource fetchResources(@PathVariable("resourceId") String resourceId) {
        return resourcesRepository.findById(resourceId).get();
    }

    @GetMapping("/api/cloudability/resource/{resourceId}")
    public ResourceModel fetchCloudabilityResources(@PathVariable("resourceId") String resourceId) {
        return client.fetchResource(resourceId).getBody();
    }

    @GetMapping("/api/cloudability/resources-needing-rightsizing")
    public ResourcesNeedingRightsizingModel fetchResourcesNeedingRightsizing() {
        return this.client.fetchResourcesNeedingRightsizing().getBody();
    }

    @GetMapping("/api/cloudability/resources-running-overnight")
    public ResourcesRunningOvernightModel fetchResourcesRunningOvernight() {
        return client.fetchResourcesRunningOvernight().getBody();
    }

}
