package com.cloudwastetracker.CloudWasteTracker.vendor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudwastetracker.CloudWasteTracker.record.Record;

public interface VendorRepository extends CrudRepository<Vendor, Integer>{

}