package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FieldValueFinder {
    JdbcTemplate jdbcTemplate;

    public String findFieldValue(String fieldName, String tableName, String condition) {
        String sql = "SELECT " + fieldName + " FROM " + tableName + " WHERE " + condition;
        return jdbcTemplate.queryForObject(sql, String.class);
    }
}
