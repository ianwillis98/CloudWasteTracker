package com.cloudwastetracker.CloudWasteTracker.vendor;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import com.cloudwastetracker.CloudWasteTracker.waste.ResourceWaste;
import com.cloudwastetracker.CloudWasteTracker.waste.ResourceWasteRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Component
public class PopulateVendorsTask {

    private static final long ONE_DAY_IN_MILLIS = 86400000;

    private CloudabilityClient client;
    private VendorRepository vendorRepository;

    public PopulateVendorsTask(CloudabilityClient client, VendorRepository vendorRepository) {
        this.client =  client;
        this.vendorRepository = vendorRepository;
    }

    //@Scheduled(fixedRate = ONE_DAY_IN_MILLIS, initialDelay = 0L)
    public void populateVendorsTask() {
        System.out.println("here");
        VendorModel vendorModel = this.client.fetchVendors().getBody();
        for (VendorModel.Result result : vendorModel.result) {
            Vendor vendor = new Vendor();
            vendor.setVendorKey(result.key);
            vendor.setVendorDescription(result.description);
            vendor.setVendorLabel(result.label);
            vendorRepository.save(vendor);
        }
    }

}
