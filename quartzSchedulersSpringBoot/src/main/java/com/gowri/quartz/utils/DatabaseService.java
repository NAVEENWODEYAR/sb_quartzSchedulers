package com.gowri.quartz.utils;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.retry.annotation.Backoff;

/**
 * @author NaveenWodeyar
 * @date 26-Mar-2025
 * @time 9:13:46 pm
 */

@Service
public class DatabaseService {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Retry database operations on SQLException
    @Retryable(value = { org.springframework.dao.DataAccessException.class }, maxAttempts = 5, backoff = @Backoff(delay = 3000))
    public void insertData(String data) {
        String sql = "INSERT INTO data_table (data) VALUES (?)";
        jdbcTemplate.update(sql, data);
        System.out.println("Data inserted: " + data);
    }
}
