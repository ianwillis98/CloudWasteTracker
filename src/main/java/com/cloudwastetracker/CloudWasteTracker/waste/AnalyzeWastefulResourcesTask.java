package com.cloudwastetracker.CloudWasteTracker.waste;

import com.cloudwastetracker.CloudWasteTracker.cloudability.CloudabilityClient;
import com.cloudwastetracker.CloudWasteTracker.resources.Resource;
import com.cloudwastetracker.CloudWasteTracker.resources.ResourceRepository;
import com.cloudwastetracker.CloudWasteTracker.rightsizing.RightsizingModel;
import com.cloudwastetracker.CloudWasteTracker.utilization.UtilizationModel;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AnalyzeWastefulResourcesTask {

    private static final long ONE_DAY_IN_MILLIS = 86400000;

    private static Logger logger = LogManager.getLogger();

    private CloudabilityClient client;
    private ResourceRepository resourceRepository;
    private ResourceWasteRepository resourceWasteRepository;

    public AnalyzeWastefulResourcesTask(CloudabilityClient client, ResourceRepository resourceRepository, ResourceWasteRepository resourceWasteRepository) {
        this.client = client;
        this.resourceRepository = resourceRepository;
        this.resourceWasteRepository = resourceWasteRepository;
    }

    @Scheduled(fixedRate = ONE_DAY_IN_MILLIS, initialDelay = ONE_DAY_IN_MILLIS / 2)
    public void analyzeWastefulResources() {
        logger.log(Level.INFO, "Beginning AnalyzeWastefulResourcesTask");

        Iterable<Resource> resources = resourceRepository.findAll();
        for (Resource resource : resources) {
            logger.log(Level.INFO, "Creating new resource waste id=" + resource.getResourceId());
            createAndSaveNewResourceWaste(resource);
        }

        logger.log(Level.INFO, "Ending AnalyzeWastefulResourcesTask");
    }

    private void createAndSaveNewResourceWaste(Resource resource) {
        String resourceId = resource.getResourceId();

        RightsizingModel rightsizingModel = null;
        UtilizationModel utilizationModel = null;
        try {
            rightsizingModel = this.client.fetchRightsizing(resourceId).getBody();
            utilizationModel = this.client.fetchUtilization(resourceId).getBody();
        } catch (Exception e) {
            return;
        }

        if (rightsizingModel != null && rightsizingModel.results.size() > 0 && rightsizingModel.results.get(0).recommendations.size() > 0
                && utilizationModel != null && utilizationModel.results.size() > 0) {

            RightsizingModel.Result rightsizingResult = rightsizingModel.results.get(0);
            RightsizingModel.Result.Recommendations rightsizingRecommendation = rightsizingModel.results.get(0).recommendations.get(0);
            UtilizationModel.Result utilizationResult = utilizationModel.results.get(0);

            ResourceWaste waste = new ResourceWaste();
            waste.setResource(resource);
            waste.setNodeType(rightsizingResult.nodeType);
            waste.setUnitPrice(rightsizingResult.unitPrice);
            waste.setTotalSpend(rightsizingResult.totalSpend);
            waste.setCpuCapacity(rightsizingResult.cpuCapacity);
            waste.setMemoryCapacity(rightsizingResult.memoryCapacity);
            waste.setNetworkCapacity(rightsizingResult.networkCapacity);
            waste.setHoursRunning(rightsizingResult.hoursRunning);
            waste.setIdle(rightsizingResult.idle);

            waste.setRecommendationAction(rightsizingRecommendation.action);
            waste.setRecommendationNodeType(rightsizingRecommendation.nodeType);
            waste.setRecommendationUnitPrice(rightsizingRecommendation.unitPrice);
            waste.setRecommendationCpuCapacity(rightsizingRecommendation.cpuCapacity);
            waste.setRecommendationMemoryCapacity(rightsizingRecommendation.memoryCapacity);
            waste.setRecommendationNetworkCapacity(rightsizingRecommendation.networkCapacity);
            waste.setRecommendationRisk(rightsizingRecommendation.risk);
            waste.setRecommendationSavings(rightsizingRecommendation.savings);
            waste.setRecommendationSavingsPct(rightsizingRecommendation.savingsPct);

            waste.setShutdownAt(utilizationResult.shutdownAt);
            waste.setPowerOnAt(utilizationResult.powerOnAt);

            resourceWasteRepository.save(waste);
        }
    }
}
