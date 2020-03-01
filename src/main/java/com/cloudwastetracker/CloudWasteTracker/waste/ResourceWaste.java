package com.cloudwastetracker.CloudWasteTracker.waste;

import com.cloudwastetracker.CloudWasteTracker.resources.Resource;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ResourceWaste {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    private String nodeType;
    private double unitPrice;
    private double totalSpend;
    private int cpuCapacity;
    private int memoryCapacity;
    private int networkCapacity;
    private double hoursRunning;
    private double idle;

    private String recommendationAction;
    private String recommendationNodeType;
    private int recommendationCpuCapacity;
    private int recommendationMemoryCapacity;
    private int recommendationNetworkCapacity;
    private double recommendationUnitPrice;
    private double recommendationRisk;
    private double recommendationSavings;
    private int recommendationSavingsPct;

    private boolean runningOvernight;

    public Long getId() {
        return id;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalSpend() {
        return totalSpend;
    }

    public void setTotalSpend(double totalSpend) {
        this.totalSpend = totalSpend;
    }

    public int getCpuCapacity() {
        return cpuCapacity;
    }

    public void setCpuCapacity(int cpuCapacity) {
        this.cpuCapacity = cpuCapacity;
    }

    public int getMemoryCapacity() {
        return memoryCapacity;
    }

    public void setMemoryCapacity(int memoryCapacity) {
        this.memoryCapacity = memoryCapacity;
    }

    public int getNetworkCapacity() {
        return networkCapacity;
    }

    public void setNetworkCapacity(int networkCapacity) {
        this.networkCapacity = networkCapacity;
    }

    public double getHoursRunning() {
        return hoursRunning;
    }

    public void setHoursRunning(double hoursRunning) {
        this.hoursRunning = hoursRunning;
    }

    public double getIdle() {
        return idle;
    }

    public void setIdle(double idle) {
        this.idle = idle;
    }

    public String getRecommendationAction() {
        return recommendationAction;
    }

    public void setRecommendationAction(String recommendationAction) {
        this.recommendationAction = recommendationAction;
    }

    public String getRecommendationNodeType() {
        return recommendationNodeType;
    }

    public void setRecommendationNodeType(String recommendationNodeType) {
        this.recommendationNodeType = recommendationNodeType;
    }

    public int getRecommendationCpuCapacity() {
        return recommendationCpuCapacity;
    }

    public void setRecommendationCpuCapacity(int recommendationCpuCapacity) {
        this.recommendationCpuCapacity = recommendationCpuCapacity;
    }

    public int getRecommendationMemoryCapacity() {
        return recommendationMemoryCapacity;
    }

    public void setRecommendationMemoryCapacity(int recommendationMemoryCapacity) {
        this.recommendationMemoryCapacity = recommendationMemoryCapacity;
    }

    public int getRecommendationNetworkCapacity() {
        return recommendationNetworkCapacity;
    }

    public void setRecommendationNetworkCapacity(int recommendationNetworkCapacity) {
        this.recommendationNetworkCapacity = recommendationNetworkCapacity;
    }

    public double getRecommendationUnitPrice() {
        return recommendationUnitPrice;
    }

    public void setRecommendationUnitPrice(double recommendationUnitPrice) {
        this.recommendationUnitPrice = recommendationUnitPrice;
    }

    public double getRecommendationRisk() {
        return recommendationRisk;
    }

    public void setRecommendationRisk(double recommendationRisk) {
        this.recommendationRisk = recommendationRisk;
    }

    public double getRecommendationSavings() {
        return recommendationSavings;
    }

    public void setRecommendationSavings(double recommendationSavings) {
        this.recommendationSavings = recommendationSavings;
    }

    public int getRecommendationSavingsPct() {
        return recommendationSavingsPct;
    }

    public void setRecommendationSavingsPct(int recommendationSavingsPct) {
        this.recommendationSavingsPct = recommendationSavingsPct;
    }

    public boolean isRunningOvernight() {
        return runningOvernight;
    }

    public void setRunningOvernight(boolean runningOvernight) {
        this.runningOvernight = runningOvernight;
    }
}
