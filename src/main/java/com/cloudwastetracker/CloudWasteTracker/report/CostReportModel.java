package com.cloudwastetracker.CloudWasteTracker.report;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class CostReportModel {
	public List<CostResults> result;
	 @JsonIgnoreProperties(ignoreUnknown = true)
	public static class CostResults{
		public String vendor_account_name;
		public String adjusted_cost;
		
	}
}
