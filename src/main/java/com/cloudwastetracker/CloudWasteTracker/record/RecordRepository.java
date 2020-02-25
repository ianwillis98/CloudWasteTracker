package com.cloudwastetracker.CloudWasteTracker.record;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface RecordRepository extends PagingAndSortingRepository<Record, Integer>{
	
}