package com.cloudwastetracker.CloudWasteTracker.waste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResourceWasteRepository extends JpaRepository<ResourceWaste, Long> {
    @Query(value = "Select * from resource_waste where resource_id = ?1 order by created_at ASC", nativeQuery = true)
    public List<ResourceWaste> findByResourceId(String rid);

    @Query(nativeQuery = true, value = "SELECT * FROM resource_waste where resource_id = ?1 group by date(created_at)")
    public List<ResourceWaste> findByResourceIdGroupByDate(String rid);

    @Query(value = "SELECT * FROM resource_waste WHERE resource_id = :id AND created_at BETWEEN from_unixtime(:startDate) AND from_unixtime(:endDate) order by created_at ASC", nativeQuery = true)
    public List<ResourceWaste> findByResourceIdAndDate(@Param("id")String resourceID, @Param("startDate")int start, @Param("endDate")int end);
    
    @Query(value = "select created_at as 'date', sum(total_spend) as 'totalSpent', sum(recommendation_savings) as 'totalWaste' from resource_waste where resource_id in "
    		+ "(SELECT resource_id FROM resource where application_name = :appName) AND created_at BETWEEN from_unixtime(:startDate) AND from_unixtime(:endDate) group by date(created_at) order by created_at ASC;", nativeQuery = true)
    public List<WasteData> findByAppNameBetweenDates(@Param("appName") String appName, @Param("startDate")int start, @Param("endDate")int end);
    
    @Query(value = "select created_at as 'date', sum(total_spend) as 'totalSpent', sum(recommendation_savings) as 'totalWaste' from resource_waste where resource_id in "
    		+ "(SELECT resource_id FROM resource where department = :department) AND created_at BETWEEN from_unixtime(:startDate) AND from_unixtime(:endDate) group by date(created_at) order by created_at ASC;", nativeQuery = true)
    public List<WasteData> findByDepartmentBetweenDates(@Param("department") String department, @Param("startDate")int start, @Param("endDate")int end);
    
    @Query(value = "select created_at as 'date', sum(total_spend) as 'totalSpent', sum(recommendation_savings) as 'totalWaste' from resource_waste where resource_id in "
    		+ "(SELECT resource_id FROM resource where application_name = :appName) group by date(created_at) order by created_at ASC;", nativeQuery = true)
    public List<WasteData> findByAppName(@Param("appName") String appName);
    
    @Query(value = "select created_at as 'date', sum(total_spend) as 'totalSpent', sum(recommendation_savings) as 'totalWaste' from resource_waste where resource_id in "
    		+ "(SELECT resource_id FROM resource where department = :department) group by date(created_at) order by created_at ASC;", nativeQuery = true)
    public List<WasteData> findByDepartment(@Param("department") String department);
    
    @Query(value = "select created_at as 'date', sum(total_spend) as 'totalSpent', sum(recommendation_savings) as 'totalWaste' from resource_waste where resource_id in "
    		+ "(SELECT resource_id FROM resource where resource_owner = :owner) AND created_at BETWEEN from_unixtime(:startDate) AND from_unixtime(:endDate) group by date(created_at) order by created_at ASC;", nativeQuery = true)
    public List<WasteData> findByOwnerBetweenDates(@Param("owner") String owner, @Param("startDate")int start, @Param("endDate")int end);
    
    @Query(value = "select created_at as 'date', sum(total_spend) as 'totalSpent', sum(recommendation_savings) as 'totalWaste' from resource_waste where resource_id in "
    		+ "(SELECT resource_id FROM resource where resource_owner = :owner) group by date(created_at) order by created_at ASC;", nativeQuery = true)
    public List<WasteData> findByOwner(@Param("owner") String owner);
    
}
