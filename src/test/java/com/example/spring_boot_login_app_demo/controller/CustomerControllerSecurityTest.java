package com.example.spring_boot_login_app_demo.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import com.example.spring_boot_login_app_demo.security.SecurityConfig;

@WebMvcTest(CustomerController.class)
@Import(SecurityConfig.class)
class CustomerControllerSecurityTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("顧客一覧ページにadminユーザがアクセスできる")
    void test_customer_enableToAccessByAdminRole() throws Exception {
        mockMvc.perform(
            get("/customer/display-list")
            .with(user("admin").roles("ADMIN"))
        )
        .andExpect(status().isOk());
    }

    @Test
    @DisplayName("顧客一覧ページにuserユーザがアクセスできない")
    void test_customer_unableToAccessByUserRole() throws Exception {
        mockMvc.perform(
            get("/customer/display-list")
            .with(user("user").roles("User"))
        )
        .andExpect(status().isForbidden());
    }
}
