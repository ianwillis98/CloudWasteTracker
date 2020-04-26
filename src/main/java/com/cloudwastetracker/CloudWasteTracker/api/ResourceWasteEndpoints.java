package com.cloudwastetracker.CloudWasteTracker.api;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;

import java.time.*;
import java.util.List;

import com.cloudwastetracker.CloudWasteTracker.waste.ResourceWaste;
import com.cloudwastetracker.CloudWasteTracker.waste.ResourceWasteRepository;
import com.cloudwastetracker.CloudWasteTracker.waste.WasteData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceWasteEndpoints {

    private CloudabilityClient client;
    private ResourceWasteRepository resourceWasteRepository;

    public ResourceWasteEndpoints(CloudabilityClient client, ResourceWasteRepository resourceWasteRepository) {
        this.client = client;
        this.resourceWasteRepository = resourceWasteRepository;
    }

    // example /api/resource/waste/i-00bcaebf4bb9884c4?startDate=1585713600&endDate=1585886400
    @GetMapping("/api/resource/waste/{resourceId}")
    public List<ResourceWaste> fetchResourceWasteById(@PathVariable String resourceId, @RequestParam(required = false) Long startDate, @RequestParam(required = false) Long endDate) {
        if (startDate == null || endDate == null) {
            startDate = LocalDate.now().atTime(LocalTime.MAX).minusWeeks(2).toEpochSecond(ZoneOffset.UTC);
            endDate = LocalDate.now().atTime(LocalTime.MAX).toEpochSecond(ZoneOffset.UTC);
        }
        return resourceWasteRepository.findByResourceIdAndDate(resourceId, startDate, endDate);
    }

    // example /api/application/waste/frontier?startDate=1585713600&endDate=1585886400
    @GetMapping("/api/application/waste/{appName}")
    public List<WasteData> fetchResourceWasteByApplicationName(@PathVariable String appName, @RequestParam(required = false) Long startDate, @RequestParam(required = false) Long endDate) {
        if (startDate == null || endDate == null) {
            startDate = LocalDate.now().atTime(LocalTime.MAX).minusWeeks(2).toEpochSecond(ZoneOffset.UTC);
            endDate = LocalDate.now().atTime(LocalTime.MAX).toEpochSecond(ZoneOffset.UTC);
        }
        return resourceWasteRepository.findByAppNameBetweenDates(appName, startDate, endDate);
    }

    // example /api/department/waste/Claims?startDate=1585713600&endDate=1585886400
    @GetMapping("/api/department/waste/{deptName}")
    public List<WasteData> fetchResourceWasteByDepartmentName(@PathVariable String deptName, @RequestParam(required = false) Long startDate, @RequestParam(required = false) Long endDate) {
        if (startDate == null || endDate == null) {
            startDate = LocalDate.now().atTime(LocalTime.MAX).minusWeeks(2).toEpochSecond(ZoneOffset.UTC);
            endDate = LocalDate.now().atTime(LocalTime.MAX).toEpochSecond(ZoneOffset.UTC);
        }
        return resourceWasteRepository.findByDepartmentBetweenDates(deptName, startDate, endDate);
    }

    // example /api/owner/waste/rubelk?startDate=1585713600&endDate=1585886400
    @GetMapping("/api/owner/waste/{ownerName}")
    public List<WasteData> fetchResourceWasteByOwnerName(@PathVariable String ownerName, @RequestParam(required = false) Long startDate, @RequestParam(required = false) Long endDate) {
        if (startDate == null || endDate == null) {
            startDate = LocalDate.now().atTime(LocalTime.MAX).minusWeeks(2).toEpochSecond(ZoneOffset.UTC);
            endDate = LocalDate.now().atTime(LocalTime.MAX).toEpochSecond(ZoneOffset.UTC);
        }
        return resourceWasteRepository.findByOwnerBetweenDates(ownerName, startDate, endDate);
    }

}
