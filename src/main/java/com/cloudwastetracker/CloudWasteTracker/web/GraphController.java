package com.cloudwastetracker.CloudWasteTracker.web;

import com.cloudwastetracker.CloudWasteTracker.resources.Resource;
import com.cloudwastetracker.CloudWasteTracker.resources.ResourceRepository;
import com.cloudwastetracker.CloudWasteTracker.waste.ResourceWaste;
import com.cloudwastetracker.CloudWasteTracker.waste.ResourceWasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GraphController {

    private ResourceRepository resourceRepository;
    private ResourceWasteRepository resourceWasteRepository;

    public GraphController(ResourceRepository resourceRepository, ResourceWasteRepository resourceWasteRepository) {
        this.resourceRepository = resourceRepository;
        this.resourceWasteRepository = resourceWasteRepository;
    }

    @GetMapping("/graph")
    public String getGraph(Model model) {
        String resourceId = "i-0085abcd80f153800";
        List<ResourceWaste> waste = this.resourceWasteRepository.findByResourceId(resourceId);
        model.addAttribute("waste", waste);
        return "graph";
    }

}
