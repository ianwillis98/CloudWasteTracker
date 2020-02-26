package com.cloudwastetracker.CloudWasteTracker.utilization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UtilizationReportModel {

    public List<Result> results;

    public static class Result {
    	
        public String category5;
        //Billing account
        
        @JsonProperty("vendor_account_name")
        public String vendorAccountName;
        //account name
        
        @JsonProperty("product_name")
        public String productName;
        //aws product type
        
        @JsonProperty("instance_identifier")
        public String instanceIdentifier;
        //aws instance id
        
        public String tag6;
        //resource name (value)
        public String tag5;
        //resource owner (value)
        @JsonProperty("instance_size")
        public String instanceSize;
        //server type
        public String category3;
        //application name
        public String tag7;
        //shutdown instance at utc 
        public String tag2;
        //power instance at utc
        @JsonProperty("utilization_hours")
        public int utilizationHours;
        //hours utilized

        @JsonProperty("estimated_cost")
        public String estimatedCost;
        //estimated Cost

    }
}
