package com.cloudwastetracker.CloudWasteTracker.cloudability;

import java.util.List;

public class RightsizingEvent {

	private List<Result> result;

	public RightsizingEvent(List<Result> result) {
		this.result = result;
	}

	public static class Result {

		private String nodeType;
		private double unitPrice;

		public Result(String nodeType, double unitPrice) {
			this.nodeType = nodeType;
			this.unitPrice = unitPrice;
		}
	}
}
