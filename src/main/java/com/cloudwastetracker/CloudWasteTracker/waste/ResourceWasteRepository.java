package com.cloudwastetracker.CloudWasteTracker.waste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ResourceWasteRepository extends JpaRepository<ResourceWaste, Long> {
    @Query(value = "Select * from resource_waste where resource_id = ?1 order by created_at ASC", nativeQuery = true)
    public List<ResourceWaste> findByResourceId(String rid);

    @Query(nativeQuery = true, value = "SELECT * FROM resource_waste where resource_id = ?1 group by date(created_at)")
    public List<ResourceWaste> findByResourceIdGroupByDate(String rid);

    @Query(value = "SELECT * FROM resource_waste WHERE resource_id = :id AND created_at BETWEEN :startDate AND :endDate order by created_at ASC", nativeQuery = true)
    public List<ResourceWaste> findByResourceIdAndDate(@Param("id")String resourceID, @Param("startDate")LocalDate start, @Param("endDate")LocalDate end);
}
