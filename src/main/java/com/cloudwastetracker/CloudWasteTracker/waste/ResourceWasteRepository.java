package com.cloudwastetracker.CloudWasteTracker.waste;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ResourceWasteRepository extends JpaRepository<ResourceWaste, Long> {

}
