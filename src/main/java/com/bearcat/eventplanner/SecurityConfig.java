package com.bearcat.eventplanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    //@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeHttpRequests ->
                authorizeHttpRequests
                        .requestMatchers("/", "/login").permitAll()
                        .anyRequest().authenticated()
            )
            .oauth2Login(oauth2Login ->
                    oauth2Login
                            .loginPage("/login")
                            .defaultSuccessUrl("/home", true)
            );

        return http.build();
    }
}
