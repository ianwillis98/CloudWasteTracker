package com.cloudwastetracker.CloudWasteTracker.web;

import com.cloudwastetracker.CloudWasteTracker.resources.ResourceRepository;
import com.cloudwastetracker.CloudWasteTracker.waste.ResourceWaste;
import com.cloudwastetracker.CloudWasteTracker.waste.ResourceWasteRepository;
import com.cloudwastetracker.CloudWasteTracker.waste.WasteData;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;

@Controller
public class GraphController {

    private ResourceRepository resourceRepository;
    private ResourceWasteRepository resourceWasteRepository;

    public GraphController(ResourceRepository resourceRepository, ResourceWasteRepository resourceWasteRepository) {
        this.resourceRepository = resourceRepository;
        this.resourceWasteRepository = resourceWasteRepository;
    }

    @GetMapping("/graph_of_resource/{resourceId}")
    public String getGraph(Model model, @PathVariable String resourceId) {
	    LocalDate s = LocalDate.now();
	    LocalDate start = s.minusWeeks(2);
	    LocalDate end = s.plusDays(1);
	    
        List<ResourceWaste> waste = this.resourceWasteRepository.findByResourceIdAndDate(resourceId, (int)start.atStartOfDay().toEpochSecond(ZoneOffset.UTC), (int) end.atStartOfDay().toEpochSecond(ZoneOffset.UTC));

        model.addAttribute("waste", waste);
        model.addAttribute("resourceId", resourceId);
        return "graph_of_resource";
    }
   
   @GetMapping("/graph/{resourceId}/{startDate}/{endDate}")
   public String getGraph1(Model model, @PathVariable String resourceId,@PathVariable int startDate, @PathVariable int endDate){
   	List <ResourceWaste> waste = this.resourceWasteRepository.findByResourceIdAndDate(resourceId,startDate, endDate);
   	model.addAttribute("waste", waste);
    model.addAttribute("resourceId", resourceId);
    model.addAttribute("startDate", startDate);
    model.addAttribute("endDate", endDate);
    return "filtergraph";
   }

   @GetMapping("/graph_of_app/{appName}")
   public String getAppGraph1(Model model, @PathVariable String appName) {
	   LocalDate s = LocalDate.now();
	   LocalDate start = s.minusWeeks(2);
	   LocalDate end = s.plusDays(1);
	   List<WasteData> waste = this.resourceWasteRepository.findByAppNameBetweenDates(appName, (int) start.atStartOfDay().toEpochSecond(ZoneOffset.UTC), (int) end.atStartOfDay().toEpochSecond(ZoneOffset.UTC));
	   
	   model.addAttribute("waste", waste);
	   model.addAttribute("appName", appName);
	   return "graph_of_app";
   }
   
   @GetMapping("/graph_of_dept/{dept}")
   public String getDeptGraph(Model model, @PathVariable String dept) {
	   LocalDate s = LocalDate.now();
	   LocalDate start = s.minusWeeks(2);
	   LocalDate end = s.plusDays(1);
	   List<WasteData> waste = this.resourceWasteRepository.findByDepartmentBetweenDates(dept, (int) start.atStartOfDay().toEpochSecond(ZoneOffset.UTC), (int) end.atStartOfDay().toEpochSecond(ZoneOffset.UTC));
	   
	   model.addAttribute("waste", waste);
	   model.addAttribute("dept", dept);
	   return "graph_of_department";
   }
   
   @GetMapping("/graph_of_owner/{owner}")
   public String getOwnerGraph(Model model, @PathVariable String owner) {
	   LocalDate s = LocalDate.now();
	   LocalDate start = s.minusWeeks(2);
	   LocalDate end = s.plusDays(1);
	   
	   List<WasteData> waste = this.resourceWasteRepository.findByOwnerBetweenDates(owner, (int) start.atStartOfDay().toEpochSecond(ZoneOffset.UTC), (int) end.atStartOfDay().toEpochSecond(ZoneOffset.UTC));
	   
	   model.addAttribute("waste", waste);
	   model.addAttribute("owner", owner);
	   return "graph_of_owner";
   }
   
   @GetMapping("/graph_of_resource/")
   public String getResourceGraphBetweenDates(Model model, @RequestParam(name = "id") String resourceId, @RequestParam(name = "startDate") int startDate, @RequestParam(name = "endDate") int endDate) {
	   List<ResourceWaste> waste = this.resourceWasteRepository.findByResourceIdAndDate(resourceId, startDate, endDate);
	   
	   model.addAttribute("waste", waste);
	   model.addAttribute("resourceId", resourceId);
	   return "graph_of_resource";
   }
   
   @GetMapping("/graph_of_app/")
   public String getAppGraphBetweenDates(Model model, @RequestParam(name = "app") String appName, @RequestParam(name = "startDate") int startDate, @RequestParam(name = "endDate") int endDate) {
	   List<WasteData> waste = this.resourceWasteRepository.findByAppNameBetweenDates(appName, startDate, endDate);
	   
	   model.addAttribute("waste", waste);
	   model.addAttribute("appName", appName);
	   return "graph_of_app";
   }
   
   @GetMapping("/graph_of_dept/")
   public String getDeptGraphBetweenDates(Model model, @RequestParam(name = "dept") String dept, @RequestParam(name = "startDate") int startDate, @RequestParam(name = "endDate") int endDate) {
	   List<WasteData> waste = this.resourceWasteRepository.findByDepartmentBetweenDates(dept, startDate, endDate);
	   
	   model.addAttribute("waste", waste);
	   model.addAttribute("dept", dept);
	   return "graph_of_department";
   }
   
   @GetMapping("/graph_of_owner/")
   public String getOwnerGraphBetweenDates(Model model, @RequestParam(name = "owner") String owner, @RequestParam(name = "startDate") int startDate, @RequestParam(name = "endDate") int endDate) {
	   List<WasteData> waste = this.resourceWasteRepository.findByOwnerBetweenDates(owner, startDate, endDate);
	   
	   model.addAttribute("waste", waste);
	   model.addAttribute("owner", owner);
	   return "graph_of_owner";
   }
}
