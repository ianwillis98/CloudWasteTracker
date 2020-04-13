package com.cloudwastetracker.CloudWasteTracker.waste;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;

import java.util.List;

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
    //example http://localhost:5000/waste/?id=i-00bcaebf4bb9884c4&startDate=1585713600&endDate=1585886400
    @GetMapping("/waste/")
    public List<ResourceWaste> fetchResourceWasteTwoDates(@RequestParam(name = "id") String resourceId,@RequestParam int startDate, @RequestParam int endDate){
    	return resourceWasteRepository.findByResourceIdAndDate(resourceId,startDate, endDate);
    }
    //example http://localhost:5000/waste_of_app/?app=frontier&startDate=1585713600&endDate=1588219200
    @GetMapping("/waste_of_app/")
    public List<WasteData> fetchWasteByAppName(@RequestParam(name = "app") String appName,@RequestParam int startDate, @RequestParam int endDate){
    	return resourceWasteRepository.findByAppNameBetweenDates(appName, startDate, endDate);
    }
    
    //example http://localhost:5000/waste_of_department/?dept=Claims&startDate=1585713600&endDate=1588219200
    @GetMapping("/waste_of_department/")
    public List<WasteData> fetchWasteBydepartment(@RequestParam(name = "dept") String department,@RequestParam int startDate, @RequestParam int endDate){
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
    //note: The timezone of our database is UTC/GMT not EDT
    //http://localhost:5000/waste_of_owner/?owner=rubelk&startDate=1585713600&endDate=1588219200
    @GetMapping("waste_of_owner/")
    public List<WasteData> fetchWasteByOwnerBetweenDates(@RequestParam(name = "owner")String owner, @RequestParam int startDate, @RequestParam int endDate){
    	return resourceWasteRepository.findByOwnerBetweenDates(owner, startDate, endDate);
    }

}
