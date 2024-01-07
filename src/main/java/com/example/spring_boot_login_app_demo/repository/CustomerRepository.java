package com.example.spring_boot_login_app_demo.repository;

import java.util.List;

import com.example.spring_boot_login_app_demo.entity.Cusotmer;

public interface CustomerRepository {
    List<Cusotmer> selectByCustomerId(String customerId);

    List<Cusotmer> selectByCustomerName(String customerName);

    List<Cusotmer> selectAll();
}
