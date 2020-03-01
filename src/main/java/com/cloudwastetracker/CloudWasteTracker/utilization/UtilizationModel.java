package com.cloudwastetracker.CloudWasteTracker.utilization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UtilizationModel {

    public List<Result> results;

    public static class Result {

        @JsonProperty("instance_identifier")
        public String resourceId;

        @JsonProperty("estimated_cost")
        public String estimatedCost;

        @JsonProperty("tag2")
        public String powerOnAt;

        @JsonProperty("tag7")
        public String shutdownAt;

    }
}

