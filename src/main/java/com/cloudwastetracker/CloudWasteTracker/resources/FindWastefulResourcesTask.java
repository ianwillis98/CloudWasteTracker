package com.cloudwastetracker.CloudWasteTracker.resources;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
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

    // cut off gathering more resources for mvp
    //@Scheduled(fixedRate = ONE_DAY_IN_MILLIS, initialDelay = TEN_SECONDS_IN_MILLIS)
    public void findWastefulResources() {
        logger.log(Level.INFO, "Beginning FindWastefulResourcesTask");

        ResourcesRunningOvernightModel overnightModel = client.fetchResourcesRunningOvernight().getBody();
        if (overnightModel != null) {
            for (int i = 0; i < overnightModel.results.size(); i++) {
                ResourcesRunningOvernightModel.Result result = overnightModel.results.get(i);
                if (resourceRepository.existsById(result.resourceId)) {
                    logger.log(Level.INFO, "Updating existing resource from overnight report " + i + ":" + (overnightModel.results.size()-1) + " id=" + result.resourceId);
                } else {
                    logger.log(Level.INFO, "Saving new resource from overnight report " + i + ":" + (overnightModel.results.size()-1) + " id=" + result.resourceId);
                }
                fetchAndSaveNewResource(result.resourceId, true);
            }
        }

        ResourcesNeedingRightsizingModel rightsizingModel = client.fetchResourcesNeedingRightsizing().getBody();
        if (rightsizingModel != null) {
            for (int i = 0; i < rightsizingModel.results.size(); i++) {
                ResourcesNeedingRightsizingModel.Result result = rightsizingModel.results.get(i);
                if (resourceRepository.existsById(result.resourceId)) {
                    logger.log(Level.INFO, "Updating existing resource from rightsizing report " + i + ":" + (rightsizingModel.results.size()-1) + " id=" + result.resourceId);
                } else {
                    logger.log(Level.INFO, "Saving new resource from rightsizing report " + i + ":" + (rightsizingModel.results.size()-1) + " id=" + result.resourceId);
                }
                fetchAndSaveNewResource(result.resourceId, false);
            }
        }

        logger.log(Level.INFO, "Ending FindWastefulResourcesTask");
    }

    private void fetchAndSaveNewResource(String resourceId, boolean runningOvernight) {
        ResourceModel model = client.fetchResource(resourceId).getBody();
        if (model != null && model.results.size() > 0) {
            ResourceModel.Result result = model.results.get(0);

            // rightsizing endpoint can't be filtered to exclude production apps
            if (result.environment.equals("Production")) return;

            Resource resource = new Resource();
            resource.setResourceId(resourceId);
            resource.setResourceName(result.resourceName);
            resource.setResourceOwner(result.resourceOwner);
            resource.setApplicationId(result.applicationId);
            resource.setApplicationName(result.applicationName);
            resource.setApplicationOwner(result.applicationOwner);
            resource.setAccountId(result.accountId);
            resource.setAccountName(result.accountName);
            resource.setDepartment(result.department);
            resource.setItemDescription(result.itemDescription);
            resource.setInstanceType(result.instanceType);
            resource.setDisbursementCode(result.disbursementCode);
            resource.setEnvironment(result.environment);
            resourceRepository.save(resource);
        }
    }
}
