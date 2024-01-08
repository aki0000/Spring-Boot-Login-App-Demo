package com.example.spring_boot_login_app_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring_boot_login_app_demo.entity.Cusotmer;
import com.example.spring_boot_login_app_demo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/display-list")
    public String displayList(Model model) {
        List<Cusotmer> customers = customerService.selectAll();
        System.out.println(customers);
        model.addAttribute("customerList", customers);
        return "customer/customerList";
    }
}
