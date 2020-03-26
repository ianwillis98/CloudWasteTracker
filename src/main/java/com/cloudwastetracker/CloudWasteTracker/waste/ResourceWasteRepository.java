package com.cloudwastetracker.CloudWasteTracker.waste;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ResourceWasteRepository extends JpaRepository<ResourceWaste, Long> {
    @Query(value = "Select * from resource_waste where resource_id = ?1 order by created_at ASC", nativeQuery = true)
    public List<ResourceWaste> findByResourceId(String rid);
}
