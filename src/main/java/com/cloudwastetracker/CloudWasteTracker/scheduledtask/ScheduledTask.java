package com.cloudwastetracker.CloudWasteTracker.scheduledtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cloudwastetracker.CloudWasteTracker.Record.SaveDataToDB;
@Component
public class ScheduledTask {
	@Autowired
	SaveDataToDB task;
	// 12 hours converted to milliseconds
	@Scheduled(fixedRate = 12 * 60 * 60 * 1000)
	public void saveDataToDB() {
		
		task.saveDataAllMembers();
		
	}

}
