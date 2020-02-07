package com.cloudwastetracker.CloudWasteTracker.vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("mysql")
public class VendorsRds {

    private JdbcTemplate jdbcTemplate;

    public VendorsRds(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getFirstName() {
        final String sql = "SELECT first_name FROM test WHERE id = ?";
        String name = jdbcTemplate.queryForObject(sql, String.class, "1");
        return name;
    }
}
