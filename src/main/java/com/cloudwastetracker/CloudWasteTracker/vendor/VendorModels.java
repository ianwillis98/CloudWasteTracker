package com.cloudwastetracker.CloudWasteTracker.vendor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VendorModels {

	public List<VendorModels> result;

	public static class VendorModel {

		public String key;
		public String label;
		public String description;

	}
}
