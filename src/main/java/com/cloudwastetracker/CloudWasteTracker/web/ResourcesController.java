package com.cloudwastetracker.CloudWasteTracker.web;

import com.cloudwastetracker.CloudWasteTracker.resources.Resource;
import com.cloudwastetracker.CloudWasteTracker.resources.ResourceRepository;
import com.cloudwastetracker.CloudWasteTracker.vendor.Vendor;
import com.cloudwastetracker.CloudWasteTracker.waste.ResourceWaste;
import com.cloudwastetracker.CloudWasteTracker.waste.ResourceWasteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
//        for (Resource resource : resources) {
//            resource.setResourceId(resource.getResourceId().substring(0, 5) + "...");
//            resource.setApplicationId(resource.getAccountId().substring(0, 2) + "...");
//            resource.setAccountId(resource.getAccountId().substring(0, 2) + "...");
//            resource.setAccountName(resource.getAccountName().substring(0, 3) + "...");
//            resource.setResourceOwner(resource.getResourceOwner().substring(0, 3) + "...");
//            resource.setDisbursementCode(resource.getDisbursementCode().substring(0, 3) + "...");
//        }
        model.addAttribute("resources", resources);
        return "resources";
    }

    @RequestMapping("/resources-data")
    public String resourcesData(Model model) {
        List<ResourceWaste> resourcesData = this.resourceWasteRepository.findAll();
//        for (ResourceWaste waste : resourcesData) {
//            waste.getResource().setResourceId(waste.getResource().getResourceId().substring(0, 5) + "...");
//        }
        Collections.reverse(resourcesData);
        model.addAttribute("resourcesData", resourcesData);
        return "resources_data";
    }

    @RequestMapping("/resources/{resourceId}")
    public String resourceData(Model model, @PathVariable("resourceId") String resourceId) {
        List<ResourceWaste> resourceData  = this.resourceWasteRepository.findByResourceId(resourceId);
//        for (ResourceWaste waste : resourceData) {
//            waste.getResource().setResourceId(waste.getResource().getResourceId().substring(0, 5) + "...");
//        }
        Collections.reverse(resourceData);
        model.addAttribute("resourcesData", resourceData);
        return "resources_data";
    }

}
