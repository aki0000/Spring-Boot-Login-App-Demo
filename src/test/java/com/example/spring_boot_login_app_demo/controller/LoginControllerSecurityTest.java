package com.example.spring_boot_login_app_demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.spring_boot_login_app_demo.security.SecurityConfig;

@WebMvcTest(LoginController.class)
@Import(SecurityConfig.class)
public class LoginControllerSecurityTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void test_login_enableToAccessByAdminRole() throws Exception {
        mockMvc.perform(
            get("/login")
            .with(user("admin").roles("ADMIN"))
        )
        .andExpect(status().isOk());
    }

    @Test
    void test_login_enableToAccessByUserRole() throws Exception {
        mockMvc.perform(
            get("/login")
            .with(user("user").roles("User"))
        )
        .andExpect(status().isOk());
    }
}
