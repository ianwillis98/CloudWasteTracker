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
		
		//https://www.baeldung.com/spring-data-jpa-pagination-sorting for sorting by timestamp
		/*
		Reports repo = new Reports();
		RightsizingModel model = c.fetchRightsizing("i-003f7b7543aae4f52").getBody();
		repo.setMoney_spent(model.result.get(0).totalSpend);
		repo.setTime_stamp(new Timestamp(new Date().getTime()));
		repo.setMoney_wasted(model.result.get(0).recommendations.get(0).savings);
		repo.setServer_type(model.result.get(0).nodeType);
		repo.setLocal_capacity(model.result.get(0).localCapacity);
		repo.setLocal_drives(model.result.get(0).localDrives);
		repo.setCpu_capacity(model.result.get(0).cpuCapacity);
		repo.setMemory_capacity(model.result.get(0).memoryCapacity);
		temp.save(repo);
		*/
		task.SaveData();
		//System.out.println("Saved");
		
	}

}
