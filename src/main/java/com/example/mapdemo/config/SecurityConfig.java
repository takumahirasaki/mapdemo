package com.example.mapdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/demo/home").permitAll() // このURLは認証不要
                .anyRequest().authenticated() // 他のリクエストは認証必要
            )
            .formLogin() // フォームログインを有効化
            .and()
            .csrf().disable(); // 必要に応じてCSRFを無効化
        return http.build();
    }
}
