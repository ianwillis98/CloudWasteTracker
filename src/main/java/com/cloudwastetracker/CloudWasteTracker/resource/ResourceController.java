package com.cloudwastetracker.CloudWasteTracker.resource;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResourceController {

    private CloudabilityClient client;
    private ResourceRepository resourcesRepository;

    public ResourceController(CloudabilityClient client, ResourceRepository resourcesRepository) {
        this.client = client;
        this.resourcesRepository = resourcesRepository;
    }

    @GetMapping("/resource/{resourceId}")
    public ResourceModel fetchResources(@PathVariable("resourceId") String resourceId) {
        return client.fetchResource(resourceId).getBody();
    }

}
