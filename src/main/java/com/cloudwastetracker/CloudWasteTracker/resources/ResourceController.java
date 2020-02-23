package com.cloudwastetracker.CloudWasteTracker.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResourceController {

    private ResourceRepository resourcesRepository;

    public ResourceController(ResourceRepository resourcesRepository) {
        this.resourcesRepository = resourcesRepository;
    }

    @GetMapping("/resources")
    public Iterable<Resource> fetchResources() {
        return resourcesRepository.findAll();
    }

}
