package com.example.bilyzna1.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;



@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;
    private UserAuthProvider userAuthProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .exceptionHandling(customizer -> customizer.authenticationEntryPoint(userAuthenticationEntryPoint))
                .addFilterBefore(new JwtAuthFilter(userAuthProvider), BasicAuthenticationFilter.class)
                .csrf(crf->crf.disable())
                .sessionManagement(sh->sh.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((requests)->requests
                        .requestMatchers(HttpMethod.POST, "/login","/register").permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
//        return http.cors(cors -> cors.configurationSource(corsConfigurationSource()))
//                .csrf(csrf -> csrf.disable())
//                .authorizeRequests(auth -> {
//                    auth.requestMatchers("/pijami").permitAll();
//                    auth.requestMatchers("/bilyzna").authenticated();
//                }).formLogin(login->{
//                    login.loginPage("/login").permitAll();
//                })
//                .httpBasic(Customizer.withDefaults()).build();
//    }
//        @Bean
//        public CorsConfigurationSource corsConfigurationSource () {
//            CorsConfiguration configuration = new CorsConfiguration();
//            configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000/login")); // Replace with your React app's URL
//            configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
//            configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
//
//            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//            source.registerCorsConfiguration("/**", configuration);
//
//            return source;
//        }
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
