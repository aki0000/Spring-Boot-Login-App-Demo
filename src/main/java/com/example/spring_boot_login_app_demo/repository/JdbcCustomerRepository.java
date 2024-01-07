package com.example.spring_boot_login_app_demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.spring_boot_login_app_demo.entity.Cusotmer;

@Repository
public class JdbcCustomerRepository implements CustomerRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public JdbcCustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Cusotmer> selectByCustomerId(String customerId) {
        List<Cusotmer> customers = jdbcTemplate.query("SELECT * FROM cutomers WHERE customer_id = ?",
        new DataClassRowMapper<>(Cusotmer.class),
        customerId);
        return customers;
    }

    @Override
    public List<Cusotmer> selectByCustomerName(String customerName) {
        List<Cusotmer> customers = jdbcTemplate.query("SELECT * FROM cutomers WHERE customer_name = ?",
        new DataClassRowMapper<>(Cusotmer.class),
        customerName);
        return customers;

    }

    @Override
    public List<Cusotmer> selectAll() {
        List<Cusotmer> customers = jdbcTemplate.query("SELECT * FROM cutomers",
        new DataClassRowMapper<>(Cusotmer.class));
        return customers;
    }
}
