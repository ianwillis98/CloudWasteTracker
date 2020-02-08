package com.cloudwastetracker.CloudWasteTracker.reports;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cloudwastetracker.CloudWasteTracker.rightsizing.RightsizingModel;

@Component
public class ReportsRunner implements CommandLineRunner{
	@Autowired
	private ReportsRepository reportRepo;
	
	@Autowired
	private RightsizingModel model;
	@Override
	public void run(String... args) throws Exception {
		Reports report = new Reports();
		report.setResourceIdentifier(model.result.get(0).resourceIdentifier);
		report.setVendorAccountId(model.result.get(0).vendorAccountId);
		report.setTime(new Timestamp(new Date().getTime()));
		report.setTotalSpend(model.result.get(0).totalSpend);
		report.setTotalWaste(model.result.get(0).recommendations.get(0).savings);
		report.setNodeType(model.result.get(0).nodeType);
		report.setLocalCapacity(model.result.get(0).localCapacity);
		report.setLocalDrives(model.result.get(0).localDrives);
		report.setCpuCapacity(model.result.get(0).cpuCapacity);
		report.setMemoryCapacity(model.result.get(0).memoryCapacity);
		report.setCpuMax(model.result.get(0).cpuMax);
		report.setMemoryMax(model.result.get(0).memoryMax);
		reportRepo.save(report);
	}

}
