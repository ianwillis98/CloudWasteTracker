package com.cloudwastetracker.CloudWasteTracker.vendor;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface VendorsRepository extends PagingAndSortingRepository<Vendor, String>{

	Vendor findByKey(String key);
}
