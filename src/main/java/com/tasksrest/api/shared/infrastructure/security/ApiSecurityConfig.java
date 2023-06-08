package com.tasksrest.api.shared.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApiSecurityConfig {
    private final KeycloakAuthConverter keycloakAuthConverter;

    public ApiSecurityConfig(KeycloakAuthConverter keycloakAuthConverter) {
        this.keycloakAuthConverter = keycloakAuthConverter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {        
        http.authorizeHttpRequests((authorizeHttpRequests) -> {
            authorizeHttpRequests.requestMatchers("/actuator/**").permitAll();
            authorizeHttpRequests.requestMatchers("/v**/**").authenticated();
        });

        http.oauth2ResourceServer((oauth2ResourceServer) -> {
            oauth2ResourceServer.jwt(jwt -> {
                jwt.jwtAuthenticationConverter(keycloakAuthConverter);
            });
        });
                
        http.sessionManagement(sessionManagement -> {
            sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });
        return http.build();
    }
}