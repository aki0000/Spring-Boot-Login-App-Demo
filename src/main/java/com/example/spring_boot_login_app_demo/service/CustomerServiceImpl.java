package com.example.spring_boot_login_app_demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring_boot_login_app_demo.entity.Cusotmer;
import com.example.spring_boot_login_app_demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Cusotmer> selectByCustomerId(String customerId) {
        return customerRepository.selectByCustomerId(customerId);
    }

    @Override
    public List<Cusotmer> selectByCustomerName(String customerName) {
        return customerRepository.selectByCustomerName(customerName);
    }

    @Override
    public List<Cusotmer> selectAll() {
        return customerRepository.selectAll();
    }
}
