package com.cloudwastetracker.CloudWasteTracker.rightsizing;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface RightsizingRepository extends PagingAndSortingRepository<Rightsizing, Integer>{
	Rightsizing findByKey(int id);
}
