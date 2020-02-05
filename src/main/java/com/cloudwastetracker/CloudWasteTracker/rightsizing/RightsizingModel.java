package com.cloudwastetracker.CloudWasteTracker.rightsizing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RightsizingModel {

    public List<ResourceStatistics> result;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResourceStatistics {

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
        public double cpuMax;

    }
}
