package com.cloudwastetracker.CloudWasteTracker.resources;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, String> {
	Long countByResourceId(String resourceID);


}
