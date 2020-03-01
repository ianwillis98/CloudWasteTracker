package com.cloudwastetracker.CloudWasteTracker.rightsizing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RightsizingModel {

    @JsonProperty("result")
    public List<Result> results;

    public static class Result {

        public String nodeType;
        public double unitPrice;
        public double totalSpend;
        public int cpuCapacity;
        public int memoryCapacity;
        public int networkCapacity;
        public double hoursRunning;
        public double idle;
        public List<Recommendations> recommendations;

        public static class Recommendations {

            // how to change resource (rightsize, no action, autoscale, terminate)
            public String action;

            // what the new values would be
            public String nodeType;
            public int cpuCapacity;
            public int memoryCapacity;
            public int networkCapacity;
            public double unitPrice;
            public double risk;

            // how much is saved
            public double savings; // in dollars
            public int savingsPct; // as a percent of the total

        }
    }
}