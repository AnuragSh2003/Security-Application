package com.Anurag.SecurityApp.Security.Application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{

        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/posts").permitAll() //only posts page is public for everyone and not other then is public you have to login in first
                        .requestMatchers("posts/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());


        return httpSecurity.build();
    }

    @Bean
    UserDetailsService myInMemoryUserDetailsService(){
        UserDetails normalUser = User
                .withUsername("anurag")
                .password(passwordEncoder().encode("Pass123"))
                .roles("USER")
                .build();

        UserDetails adminUser  = User
                .withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(normalUser , adminUser);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
