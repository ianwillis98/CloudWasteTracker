package com.cloudwastetracker.CloudWasteTracker.resources;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resources {

    @Id
    public String resourceId;

    public String resourceName;
}
