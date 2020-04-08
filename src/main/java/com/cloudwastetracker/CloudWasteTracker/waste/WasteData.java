package com.cloudwastetracker.CloudWasteTracker.waste;

import java.time.LocalDateTime;

public interface WasteData {
	public LocalDateTime getDate();
	public double getTotalSpent();
	public double getTotalWaste();
}
