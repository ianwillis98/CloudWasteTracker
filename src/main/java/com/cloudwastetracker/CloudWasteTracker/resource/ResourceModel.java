package com.cloudwastetracker.CloudWasteTracker.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceModel {

    public List<Result> results;

    public static class Result {

        // getting resourceId slows down api call
        // @JsonProperty("resource_identifier")
        // public String resourceId;
        @JsonProperty("tag4")
        public String applicationId;
        @JsonProperty("category3")
        public String applicationName;
        @JsonProperty("category4")
        public String applicationOwner;
        @JsonProperty("vendor_account_identifier")
        public String accountId;
        @JsonProperty("vendor_account_name")
        public String accountName;
        @JsonProperty("group_name4")
        public String department;
        @JsonProperty("tag6")
        public String resourceName;
        @JsonProperty("tag5")
        public String resourceOwner;
        @JsonProperty("item_description")
        public String itemDescription;
        @JsonProperty("instance_type")
        public String instanceType;
        @JsonProperty("tag2")
        public String powerOnAt;
        @JsonProperty("tag7")
        public String shutdownAt;
        @JsonProperty("tag1")
        public String disbursementCode;
        @JsonProperty("group_name5")
        public String environment;

    }
}
