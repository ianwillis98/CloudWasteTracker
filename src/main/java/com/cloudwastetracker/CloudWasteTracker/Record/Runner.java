package com.cloudwastetracker.CloudWasteTracker.Record;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner{
	@Autowired
	ReportsRepository temp;

	@Override
	public void run(String... args) throws Exception {
		
		//https://www.baeldung.com/spring-data-jpa-pagination-sorting for sorting by timestamp
		
		Reports repo = new Reports();
		repo.setTime_stamp(new Timestamp(new Date().getTime()));
		temp.save(repo);
		
	}

}
