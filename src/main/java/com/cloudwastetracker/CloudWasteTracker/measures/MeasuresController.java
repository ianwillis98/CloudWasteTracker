package com.cloudwastetracker.CloudWasteTracker.measures;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MeasuresController {

    @Autowired
    private CloudabilityClient client;

    @GetMapping("/measures")
    public MeasuresModel[] fetchMeasures() {
        return client.fetchMeasures().getBody();
    }

}
