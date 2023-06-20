package com.example.bilyzna1.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration

@RequiredArgsConstructor
public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
//        return http
//                .csrf(csrf -> csrf.disable())
//                .authorizeRequests(auth -> {
//                    auth.requestMatchers("/pijami").permitAll();
//                    auth.requestMatchers("/bilyzna").authenticated();
//                })
//                .httpBasic(Customizer.withDefaults()).build();
//    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        userDetailsManager.createUser(User.withUsername("admin")
//                .password("{bcrypt}$2a$10$A1Rnk9jhGg7TyNBACVv0.e5I1Q6bhJ3s3qNoOVB6rITrZMPM9gfDe")
//                .roles("ADMIN")
//                .build());
//        return userDetailsManager;
//    }
}
