package br.com.criandoapi.projeto.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class ConfigSecurity  {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSec) throws Exception {
        return httpSec
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/usuarios/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/usuarios/**").authenticated()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}

