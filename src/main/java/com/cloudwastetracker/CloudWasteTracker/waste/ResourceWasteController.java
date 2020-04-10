package com.cloudwastetracker.CloudWasteTracker.waste;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceWasteController {

    private CloudabilityClient client;
    private ResourceWasteRepository resourceWasteRepository;

    public ResourceWasteController(CloudabilityClient client, ResourceWasteRepository resourceWasteRepository) {
        this.client = client;
        this.resourceWasteRepository = resourceWasteRepository;
    }

    @GetMapping("/waste/{resourceId}")
    public List<ResourceWaste> fetchResourceWaste(@PathVariable String resourceId) {
        return resourceWasteRepository.findByResourceId(resourceId);
    }
    // note if you need to pass in a space replace it with %20 to encode it
    // it's the only way to pass in a url with spaces in the url parameters
    /*example localhost:5000/waste/?id=i-00bcaebf4bb9884c4&startDate=2020-04-01&endDate=2020-04-30*/
    @GetMapping("/waste/")
    public List<ResourceWaste> fetchResourceWasteTwoDates(@RequestParam(name = "id") String resourceId,@RequestParam @DateTimeFormat(iso = ISO.DATE)LocalDate startDate, @RequestParam @DateTimeFormat(iso = ISO.DATE)LocalDate endDate){
    	return resourceWasteRepository.findByResourceIdAndDate(resourceId,startDate, endDate);
    }
    //example http://localhost:5000/waste_of_app/?app=TestFIT01&startDate=2020-04-01&endDate=2020-04-30
    @GetMapping("/waste_of_app/")
    public List<WasteData> fetchWasteByAppName(@RequestParam(name = "app") String appName,@RequestParam @DateTimeFormat(iso = ISO.DATE)LocalDate startDate, @RequestParam @DateTimeFormat(iso = ISO.DATE)LocalDate endDate){
    	return resourceWasteRepository.findByAppNameBetweenDates(appName, startDate, endDate);
    }
    
    //example http://localhost:5000/waste_of_department/?dept=Claims&startDate=2020-04-01&endDate=2020-04-30
    @GetMapping("/waste_of_department/")
    public List<WasteData> fetchWasteBydepartment(@RequestParam(name = "dept") String department,@RequestParam @DateTimeFormat(iso = ISO.DATE)LocalDate startDate, @RequestParam @DateTimeFormat(iso = ISO.DATE)LocalDate endDate){
    	return resourceWasteRepository.findByDepartmentBetweenDates(department, startDate, endDate);
    }
    
    @GetMapping("/waste_of_app/{appName}")
    public List<WasteData> fetchWasteByApp(@PathVariable String appName){
    	return resourceWasteRepository.findByAppName(appName);
    }
    

    @GetMapping("/waste_of_department/{department}")
    public List<WasteData> fetchWasteByDepartment(@PathVariable String department){
    	return resourceWasteRepository.findByDepartment(department);
    }
    
    @GetMapping("/waste_of_owner/{owner}")
    public List<WasteData> fetchWasteByOwner(@PathVariable String owner){
    	return resourceWasteRepository.findByOwner(owner);
    }
    @GetMapping("waste_of_owner/")
    public List<WasteData> fetchWasteByOwnerBetweenDates(@RequestParam(name = "owner")String owner, @RequestParam @DateTimeFormat(iso = ISO.DATE)LocalDate startDate, @RequestParam @DateTimeFormat(iso = ISO.DATE)LocalDate endDate){
    	return resourceWasteRepository.findByOwnerBetweenDates(owner, startDate, endDate);
    }

}
