package com.cloudwastetracker.CloudWasteTracker.Record;

import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import com.cloudwastetracker.CloudWasteTracker.resources.Resource;
import com.cloudwastetracker.CloudWasteTracker.resources.ResourceRepository;
import com.cloudwastetracker.CloudWasteTracker.rightsizing.RightsizingModel;

@Component
public class SaveDataToDB {
	@Autowired
	RecordRepository temp;

	@Autowired
	CloudabilityClient c;
	
	@Autowired
	ResourceRepository r;
	
	public void saveData(String id){
		
		//https://www.baeldung.com/spring-data-jpa-pagination-sorting for sorting by timestamp
		
		Record repo = new Record();
		RightsizingModel model = c.fetchRightsizing(id).getBody();
		repo.setMoney_spent(model.result.get(0).totalSpend);
		repo.setTime_stamp(new Timestamp(new Date().getTime()));
		repo.setMoney_wasted(model.result.get(0).recommendations.get(0).savings);
		repo.setServer_type(model.result.get(0).nodeType);
		repo.setLocal_capacity(model.result.get(0).localCapacity);
		repo.setLocal_drives(model.result.get(0).localDrives);
		repo.setCpu_capacity(model.result.get(0).cpuCapacity);
		repo.setMemory_capacity(model.result.get(0).memoryCapacity);
		repo.setResource_id(id);
		temp.save(repo);
		
	}
	
	public void saveDataAllMembers() {
		Iterable<Resource> iter = r.findAll();
		
		for (Resource ele: iter) {
			this.saveData(ele.getResourceId());
		}
	}

}
