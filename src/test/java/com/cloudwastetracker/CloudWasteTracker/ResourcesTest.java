package com.cloudwastetracker.CloudWasteTracker;

import com.cloudwastetracker.CloudWasteTracker.resources.Resource;
import com.cloudwastetracker.CloudWasteTracker.resources.ResourceRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@DataJpaTest
public class ResourcesTest {

    @Autowired
    ResourceRepository subject;

    @Test
    public void testRepositorySave() throws Exception {
        Resource r = new Resource();
        r.setResourceId("testid");
        r.setResourceName("testname");
        subject.save(r);
    }

    @Test
    public void testRepositoryGet() throws Exception {
        Resource r = new Resource();
        r.setResourceId("testid");
        r.setResourceName("testname");
        subject.save(r);

        assertTrue(subject.findById("testid").isPresent());
        Resource r2 = subject.findById("testid").get();
        assertEquals(r.getResourceId(), r2.getResourceId());
        assertEquals(r.getResourceName(), r2.getResourceName());
    }

    @Test
    public void testRepositoryGetAll() throws Exception {
        Resource r = new Resource();
        r.setResourceId("testid");
        r.setResourceName("testname");
        subject.save(r);

        assertTrue(subject.findAll().iterator().hasNext());
    }
}
