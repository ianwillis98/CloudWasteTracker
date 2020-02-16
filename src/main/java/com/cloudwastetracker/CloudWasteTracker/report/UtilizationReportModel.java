package com.cloudwastetracker.CloudWasteTracker.report;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UtilizationReportModel {
	public List<UtilizationResults> result;
	 @JsonIgnoreProperties(ignoreUnknown = true)
	public static class UtilizationResults{
		public String tag2;
		public String estimated_cost;
		
	}
}