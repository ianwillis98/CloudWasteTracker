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
    
    @GetMapping("/waste/")
    public List<ResourceWaste> fetchResourceWasteTwoDates(@RequestParam(name = "id") String resourceId,@RequestParam @DateTimeFormat(iso = ISO.DATE)LocalDate startDate, @RequestParam @DateTimeFormat(iso = ISO.DATE)LocalDate endDate){
    	return resourceWasteRepository.findByResourceIdAndDate(resourceId,startDate, endDate);
    }
	

}
