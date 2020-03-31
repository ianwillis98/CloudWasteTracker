package com.cloudwastetracker.CloudWasteTracker.waste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResourceWasteRepository extends JpaRepository<ResourceWaste, Long> {
    @Query(value = "Select * from resource_waste where resource_id = ?1 order by created_at ASC", nativeQuery = true)
    public List<ResourceWaste> findByResourceId(String rid);
}
