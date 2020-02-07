package com.cloudwastetracker.CloudWasteTracker.rightsizing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RightsizingModel {

    public List<ResourceStatistics> result;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResourceStatistics {
    	public int id;
        public String resourceIdentifier;
        public String vendorAccountId;
        public double totalSpend;
        public String nodeType;
        public int localCapacity;
        public int localDrives;
        public int cpuCapacity;
        public int memoryCapacity;
        public int cpuMax;
        public int memoryMax;

        public List<Recommendations> recommendations;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Recommendations {

            public double savings;
        }
    }
}
