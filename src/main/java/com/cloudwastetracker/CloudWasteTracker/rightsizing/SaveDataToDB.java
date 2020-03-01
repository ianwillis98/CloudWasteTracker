package com.cloudwastetracker.CloudWasteTracker.rightsizing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import com.cloudwastetracker.CloudWasteTracker.resources.Resource;
import com.cloudwastetracker.CloudWasteTracker.resources.ResourceRepository;

@Component
public class SaveDataToDB {
	@Autowired
	RightsizingRecordRepository temp;

	@Autowired
	CloudabilityClient c;
	
	@Autowired
	ResourceRepository r;
	
	public void saveData(String id){
		
//		//https://www.baeldung.com/spring-data-jpa-pagination-sorting for sorting by timestamp
//
//		RightsizingRecord repo = new RightsizingRecord();
//		ResourcesNeedingRightsizingModel model = c.fetchResourcesNeedingRightsizing(id).getBody();
//		repo.setMoneySpent(model.result.get(0).totalSpend);
//		repo.setTimeStamp(new Timestamp(new Date().getTime()));
//		repo.setMoneyWasted(model.result.get(0).recommendations.get(0).savings);
//		repo.setServerType(model.result.get(0).nodeType);
//		repo.setLocalCapacity(model.result.get(0).localCapacity);
//		repo.setLocalDrives(model.result.get(0).localDrives);
//		repo.setCpuCapacity(model.result.get(0).cpuCapacity);
//		repo.setMemoryCapacity(model.result.get(0).memoryCapacity);
//		//repo.setResourceId(id);
//		temp.save(repo);
		
	}
	
	public void saveDataAllMembers() {
		Iterable<Resource> iter = r.findAll();
		
		for (Resource ele: iter) {
			this.saveData(ele.getResourceId());
		}
	}

}
