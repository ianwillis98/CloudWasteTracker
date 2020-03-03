package com.cloudwastetracker.CloudWasteTracker.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourcesNeedingRightsizingModel {

    @JsonProperty("result")
    public List<Result> results;

    public static class Result {

        @JsonProperty("resourceIdentifier")
        public String resourceId;
        public double unitPrice;
        public double totalSpend;
        public double idle;
        public double hoursRunning;
        public List<Recommendations> recommendations;

        public static class Recommendations {

            public String action;
            public double savings;
            public int savingsPct;
        }

    }
}
