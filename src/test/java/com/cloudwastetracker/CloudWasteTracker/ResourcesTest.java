package com.cloudwastetracker.CloudWasteTracker;

import com.cloudwastetracker.CloudWasteTracker.resources.Resources;
import com.cloudwastetracker.CloudWasteTracker.resources.ResourcesRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@DataJpaTest
public class ResourcesTest {

    @Autowired
    ResourcesRepository subject;
    
    @Test
    public void testRepositorySetId() throws Exception {
    	Resources r = new Resources();
    	String id = "testid";
    	r.setResourceId(id);
    	assertEquals(id, r.getResourceId());
    }
    
    @Test
    public void testRepositorySetName() throws Exception {
    	Resources r = new Resources();
    	String name = "testname";
    	r.setResourceName(name);
    	assertEquals(name, r.getResourceName());
    }

    @Test
    public void testRepositorySave() throws Exception {
        Resources r = new Resources();
        String id = "testid";
        r.setResourceId(id);
        r.setResourceName("testname");
        subject.save(r);
        assertTrue(subject.findById(id).isPresent());
    }

    @Test
    public void testRepositoryGet() throws Exception {
        Resources r = new Resources();
        r.setResourceId("testid");
        r.setResourceName("testname");
        subject.save(r);

        assertTrue(subject.findById("testid").isPresent());
        Resources r2 = subject.findById("testid").get();
        assertEquals("testid", r2.getResourceId());
        assertEquals("testname", r2.getResourceName());
    }

    @Test
    public void testRepositoryGetAll() throws Exception {
        Resources r = new Resources();
        r.setResourceId("testid");
        r.setResourceName("testname");
        subject.save(r);

        assertTrue(subject.findAll().iterator().hasNext());
    }
}
