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
		/*
		Reports repo = new Reports();
		repo.setName("Tim");
		repo.setTime_stamp(new Timestamp(new Date().getTime()));
		repo.setMoney(19.99);
		temp.save(repo);
		*/
	}

}
