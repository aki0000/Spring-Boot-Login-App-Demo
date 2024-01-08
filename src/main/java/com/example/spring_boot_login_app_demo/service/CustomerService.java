package com.example.spring_boot_login_app_demo.service;

import java.util.List;

import com.example.spring_boot_login_app_demo.entity.Cusotmer;

public interface CustomerService {
    List<Cusotmer> selectByCustomerId(String customerId);

    List<Cusotmer> selectByCustomerName(String customerName);

    List<Cusotmer> selectAll();
}
