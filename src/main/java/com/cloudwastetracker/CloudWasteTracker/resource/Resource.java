package com.cloudwastetracker.CloudWasteTracker.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resource {

    @Id
    private String resourceId;
    private String applicationId;
    private String applicationName;
    private String applicationOwner;
    private String accountId;
    private String accountName;
    private String department;
    private String resourceName;
    private String resourceOwner;
    private String itemDescription;
    private String instanceType;
    private String powerOnAt;
    private String shutdownAt;
    private String disbursementCode;
    private String environment;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationOwner() {
        return applicationOwner;
    }

    public void setApplicationOwner(String applicationOwner) {
        this.applicationOwner = applicationOwner;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceOwner() {
        return resourceOwner;
    }

    public void setResourceOwner(String resourceOwner) {
        this.resourceOwner = resourceOwner;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getPowerOnAt() {
        return powerOnAt;
    }

    public void setPowerOnAt(String powerOnAt) {
        this.powerOnAt = powerOnAt;
    }

    public String getShutdownAt() {
        return shutdownAt;
    }

    public void setShutdownAt(String shutdownAt) {
        this.shutdownAt = shutdownAt;
    }

    public String getDisbursementCode() {
        return disbursementCode;
    }

    public void setDisbursementCode(String disbursementCode) {
        this.disbursementCode = disbursementCode;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
