package com.springboot.application.springboot_rest_api.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.springboot.application.springboot_rest_api.service.serviceImp.UserDetailService;

import jakarta.websocket.Session;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	      

	        return http.csrf(customizer->customizer.disable()).authorizeHttpRequests(request->request.anyRequest().authenticated()).httpBasic(Customizer.withDefaults()).sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
}
	 @Bean
	    public InMemoryUserDetailsManager userDetailsService()  {
	      

	       UserDetails userOne = User.withDefaultPasswordEncoder().username("root").password("umauma1995").roles("USER").build();
	        	return new InMemoryUserDetailsManager(userOne);	}}