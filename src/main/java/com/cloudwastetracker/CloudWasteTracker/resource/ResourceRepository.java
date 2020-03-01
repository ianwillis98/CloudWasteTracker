package com.cloudwastetracker.CloudWasteTracker.resource;

import org.springframework.data.repository.CrudRepository;

public interface ResourceRepository extends CrudRepository<Resource, String> {
	Long countByResourceId(String resourceID);


}
