package com.example.spring_boot_login_app_demo.repository;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import com.example.spring_boot_login_app_demo.entity.Cusotmer;

@JdbcTest
@Sql("JdbcCustomerRepositoryTest.sql")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JdbcCustomerRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    CustomerRepository customerRepository;

    @BeforeEach
    void setup() {
        customerRepository = new JdbcCustomerRepository(jdbcTemplate);
    }

    @Test
    void test_selectByCustomerId() {
        List<Cusotmer> customers = customerRepository.selectByCustomerId("00001");
        assertThat(customers.size()).isEqualTo(1);
        assertThat(customers.get(0).getCustomerId()).isEqualTo("00001");
        assertThat(customers.get(0).getCustomerName()).isEqualTo("TEST TARO");
        assertThat(customers.get(0).getCustomerAddress()).isEqualTo("東京都品川区AAA");
    }

    @Test
    void test_selectByCustomerName() {
        List<Cusotmer> customers = customerRepository.selectByCustomerName("TEST TARO");
        assertThat(customers.size()).isEqualTo(1);
        assertThat(customers.get(0).getCustomerId()).isEqualTo("00001");
        assertThat(customers.get(0).getCustomerName()).isEqualTo("TEST TARO");
        assertThat(customers.get(0).getCustomerAddress()).isEqualTo("東京都品川区AAA");
    }

    @Test
    void test_selectByCustomerAll() {
        List<Cusotmer> customers = customerRepository.selectAll();
        assertThat(customers.size()).isEqualTo(3);
        assertThat(customers.get(0).getCustomerId()).isEqualTo("00001");
        assertThat(customers.get(0).getCustomerName()).isEqualTo("TEST TARO");
        assertThat(customers.get(0).getCustomerAddress()).isEqualTo("東京都品川区AAA");
        assertThat(customers.get(1).getCustomerId()).isEqualTo("00002");
        assertThat(customers.get(1).getCustomerName()).isEqualTo("TEST JIRO");
        assertThat(customers.get(1).getCustomerAddress()).isEqualTo("東京都品川区BBB");
        assertThat(customers.get(2).getCustomerId()).isEqualTo("00003");
        assertThat(customers.get(2).getCustomerName()).isEqualTo("TEST SABURO");
        assertThat(customers.get(2).getCustomerAddress()).isEqualTo("東京都品川区CCC");
    }
}
