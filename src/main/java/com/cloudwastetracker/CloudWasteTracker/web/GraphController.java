package com.cloudwastetracker.CloudWasteTracker.web;

import com.cloudwastetracker.CloudWasteTracker.resources.Resource;
import com.cloudwastetracker.CloudWasteTracker.resources.ResourceRepository;
import com.cloudwastetracker.CloudWasteTracker.waste.ResourceWaste;
import com.cloudwastetracker.CloudWasteTracker.waste.ResourceWasteRepository;
import com.cloudwastetracker.CloudWasteTracker.waste.WasteData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class GraphController {

    private ResourceRepository resourceRepository;
    private ResourceWasteRepository resourceWasteRepository;

    public GraphController(ResourceRepository resourceRepository, ResourceWasteRepository resourceWasteRepository) {
        this.resourceRepository = resourceRepository;
        this.resourceWasteRepository = resourceWasteRepository;
    }

   @GetMapping("/graph/{resourceId}")
    public String getGraph(Model model, @PathVariable String resourceId) {
       
        List<ResourceWaste> waste = this.resourceWasteRepository.findByResourceIdGroupByDate(resourceId);

        model.addAttribute("waste", waste);
        model.addAttribute("resourceId", resourceId);
        return "graph";
    }
   
   @GetMapping("/graph_of_app/{appName}")
   public String getAppGraph(Model model, @PathVariable String appName) {
	   List<WasteData> waste = this.resourceWasteRepository.findByAppName(appName);
	   
	   model.addAttribute("waste", waste);
	   model.addAttribute("appName", appName);
	   return "graph_of_app";
   }
   
   @GetMapping("/graph_of_department/{dept}")
   public String getDeptGraph(Model model, @PathVariable String dept) {
	   List<WasteData> waste = this.resourceWasteRepository.findByDepartment(dept);
	   
	   model.addAttribute("waste", waste);
	   model.addAttribute("dept", dept);
	   return "graph_of_dept";
   }

}
