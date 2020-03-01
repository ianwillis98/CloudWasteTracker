package com.cloudwastetracker.CloudWasteTracker.rightsizing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RightsizingModel {

    public List<Result> result;

    public static class Result {

        public String service;
        public String name;
        public String resourceIdentifier;
        public String vendorAccountId;

        public String nodeType;
        public double unitPrice;
        public double totalSpend;
        public double idle;
        public double cpuCapacity;
        public double memoryCapacity;
        public double networkCapacity;
        public double hoursRunning;
        public double localCapacity;
        public double localDrives;

        public List<Recommendations> recommendations;

        public static class Recommendations {
            public double savings;
        }

    }
}
