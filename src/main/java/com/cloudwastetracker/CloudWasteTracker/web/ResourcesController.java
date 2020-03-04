package com.cloudwastetracker.CloudWasteTracker.web;

import com.cloudwastetracker.CloudWasteTracker.resources.Resource;
import com.cloudwastetracker.CloudWasteTracker.resources.ResourceRepository;
import com.cloudwastetracker.CloudWasteTracker.vendor.Vendor;
import com.cloudwastetracker.CloudWasteTracker.waste.ResourceWaste;
import com.cloudwastetracker.CloudWasteTracker.waste.ResourceWasteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class ResourcesController {

    private ResourceRepository resourceRepository;
    private ResourceWasteRepository resourceWasteRepository;

    public ResourcesController(ResourceRepository resourceRepository, ResourceWasteRepository resourceWasteRepository) {
        this.resourceRepository = resourceRepository;
        this.resourceWasteRepository = resourceWasteRepository;
    }

    @RequestMapping("/resources")
    public String resources(Model model) {
        List<Resource> resources = this.resourceRepository.findAll();
        model.addAttribute("resources", resources);
        return "resources";
    }

    @RequestMapping("/resources-data")
    public String resourcesData(Model model) {
        List<ResourceWaste> resourcesData = this.resourceWasteRepository.findAll();
        Collections.reverse(resourcesData);
        model.addAttribute("resourcesData", resourcesData);
        return "resources_data";
    }
}
