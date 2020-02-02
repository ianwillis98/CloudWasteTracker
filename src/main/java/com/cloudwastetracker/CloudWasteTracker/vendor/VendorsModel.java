package com.cloudwastetracker.CloudWasteTracker.vendor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VendorsModel {

	private List<VendorModel> result;

	public VendorsModel() {

	}

	public VendorsModel(List<VendorModel> result) {
		this.result = result;
	}

	public List<VendorModel> getResult() {
		return result;
	}

	public static class VendorModel {

		private String key;
		private String label;
		private String description;

		public VendorModel() {

		}

		public VendorModel(String key, String label, String description) {
			this.key = key;
			this.label = label;
			this.description = description;
		}

		public String getKey() {
			return key;
		}

		public String getLabel() {
			return label;
		}

		public String getDescription() {
			return description;
		}
	}
}
