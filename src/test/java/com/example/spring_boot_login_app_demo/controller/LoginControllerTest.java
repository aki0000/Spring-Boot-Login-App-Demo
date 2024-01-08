package com.example.spring_boot_login_app_demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import com.example.spring_boot_login_app_demo.security.SecurityConfig;

@WebMvcTest(LoginController.class)
@Import(SecurityConfig.class)
class LoginControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("ログインページにAllユーザがアクセスできる")
    void test_displayLoginForm() throws Exception {
        mockMvc.perform(
            get("/login")
            )
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("ログイン")))
        ;
    }
}
