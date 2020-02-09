package com.cloudwastetracker.CloudWasteTracker.resources;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resources {

    @Id
    private String resourceId;

    private String resourceName;

    public Resources() {

    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

}
