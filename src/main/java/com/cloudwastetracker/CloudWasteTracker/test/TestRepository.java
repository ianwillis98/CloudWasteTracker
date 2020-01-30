package com.cloudwastetracker.CloudWasteTracker.test;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TestRepository extends PagingAndSortingRepository<TestEntity, Long>{

	TestEntity findByName(String name);
	
}
