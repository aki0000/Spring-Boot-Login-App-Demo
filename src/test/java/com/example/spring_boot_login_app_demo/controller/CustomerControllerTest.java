package com.example.spring_boot_login_app_demo.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.example.spring_boot_login_app_demo.entity.Cusotmer;
import com.example.spring_boot_login_app_demo.security.SecurityConfig;
import com.example.spring_boot_login_app_demo.service.CustomerService;

@WebMvcTest(CustomerController.class)
@Import(SecurityConfig.class)
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    @Test
    @DisplayName("顧客一覧ページにアクセスできる")
    void test_enableToAccessCustomerList() throws Exception {
        mockMvc.perform(
            get("/customer/display-list")
            .with(user("admin").roles("ADMIN"))
            )
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("顧客情報リスト")))
        ;
    }
}
