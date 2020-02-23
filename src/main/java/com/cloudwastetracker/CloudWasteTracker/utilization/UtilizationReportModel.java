package com.cloudwastetracker.CloudWasteTracker.utilization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UtilizationReportModel {

    public List<Result> results;

    public static class Result {

        public String category5;

        @JsonProperty("vendor_account_name")
        public String vendorAccountName;

        @JsonProperty("product_name")
        public String productName;

        @JsonProperty("instance_identifier")
        public String instanceIdentifier;

        public String tag6;
        public String tag5;

        @JsonProperty("instance_size")
        public String instanceSize;

        public String category3;
        public String tag7;
        public String tag2;

        @JsonProperty("utilization_hours")
        public int utilizationHours;

        @JsonProperty("estimated_cost")
        public String estimatedCost;

    }
}
