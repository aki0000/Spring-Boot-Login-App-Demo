package com.example.spring_boot_login_app_demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
            .requestMatchers(HttpMethod.POST, "/customer/**").hasRole("ADMIN")
            .requestMatchers("/customer/**").hasRole("ADMIN")
            .anyRequest().permitAll()
        .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/customer/display-list")
            .failureUrl("/login?failure")
        .and()
            .exceptionHandling()
            .accessDeniedPage("/access-denied");

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService () {
        UserDetails admin = User.builder()
            .username("admin").password("{noop}admin123").roles("ADMIN").build();
        UserDetails user = User.builder()
            .username("user").password("{noop}user123").roles("USER").build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
