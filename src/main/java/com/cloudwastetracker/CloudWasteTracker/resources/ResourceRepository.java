package com.cloudwastetracker.CloudWasteTracker.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ResourceRepository extends JpaRepository<Resource, String> {
	Long countByResourceId(String resourceID);
	 

	     

}
