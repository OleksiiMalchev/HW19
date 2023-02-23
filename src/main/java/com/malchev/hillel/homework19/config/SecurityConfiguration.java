package com.malchev.hillel.homework19.config;

import com.malchev.hillel.homework19.service.impl.JpaUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    public SecurityConfiguration(AuthenticationManagerBuilder authenticationManagerBuilder,
                                 JpaUserDetailsService jpaUserDetailsService) throws Exception {

        authenticationManagerBuilder.userDetailsService(jpaUserDetailsService);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable().cors().disable()
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/ping").permitAll()
                        .requestMatchers(HttpMethod.GET, "/products","/products/{id}")
                        .hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/products/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/products").hasRole("ADMIN")
                )
                .formLogin()
                .defaultSuccessUrl("/products");
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
