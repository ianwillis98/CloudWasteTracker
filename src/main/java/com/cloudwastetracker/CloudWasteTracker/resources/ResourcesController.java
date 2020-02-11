package com.cloudwastetracker.CloudWasteTracker.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResourcesController {

    private ResourcesRepository resourcesRepository;

    public ResourcesController(ResourcesRepository resourcesRepository) {
        this.resourcesRepository = resourcesRepository;
    }

    @GetMapping("/resources")
    public Iterable<Resources> fetchResources() {
        return resourcesRepository.findAll();
    }

}
