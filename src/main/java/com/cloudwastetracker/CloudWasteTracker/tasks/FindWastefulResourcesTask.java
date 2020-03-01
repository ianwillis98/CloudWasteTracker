package com.cloudwastetracker.CloudWasteTracker.tasks;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import com.cloudwastetracker.CloudWasteTracker.resource.ResourceRepository;
import com.cloudwastetracker.CloudWasteTracker.utilization.UtilizationReportModel;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FindWastefulResourcesTask {

    private static final long ONE_DAY_IN_MILLIS = 86400000;
    private static final long TEN_SECONDS_IN_MILLIS = 10000;

    private static Logger logger = LogManager.getLogger();

    private CloudabilityClient client;
    private ResourceRepository resourceRepository;

    public FindWastefulResourcesTask(CloudabilityClient client, ResourceRepository resourceRepository) {
        this.client = client;
        this.resourceRepository = resourceRepository;
    }

    @Scheduled(fixedRate = ONE_DAY_IN_MILLIS, initialDelay = 0)
    public void saveDataToDB() {
        logger.log(Level.INFO, "Beginning FindWasteFullResourcesTask");
        // run rightsizing
        // run utilization

        UtilizationReportModel utilizationReportModel = client.fetchUtilizationReport().getBody();
        for (UtilizationReportModel.Result result : utilizationReportModel.results) {
            if (resourceRepository.existsById(result.resourceId)) {
                System.out.println("exists + " + result.resourceId);
            } else {
                System.out.println("does not + " + result.resourceId);
            }
            //logger.log(Level.INFO, "resource id: " + result.resourceId);
        }


        System.out.println("ian here scheduling");
    }

}
