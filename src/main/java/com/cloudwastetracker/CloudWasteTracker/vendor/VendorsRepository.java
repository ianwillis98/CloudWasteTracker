package com.cloudwastetracker.CloudWasteTracker.vendor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwastetracker.CloudWasteTracker.Record.Reports;

public interface VendorsRepository extends CrudRepository<Reports, Integer>{

}