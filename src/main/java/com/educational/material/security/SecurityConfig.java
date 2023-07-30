package com.educational.material.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private static final String[] AUTH_WHITELIST = {
		"/public/**",
		"/error"
	};
	
	private static final String[] AUTH_FORWARDLIST = {
			"/admin/**"
	};
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorize ->  authorize
				.dispatcherTypeMatchers().permitAll() //permitAll()--> The request requires no authorization to be invoked
				.requestMatchers(AUTH_WHITELIST).permitAll()
				.requestMatchers(AUTH_FORWARDLIST).hasRole("ADMIN")
				.anyRequest().denyAll() //denyAll()--> The request is not allowed under any circumstances.
			 )
		.formLogin().defaultSuccessUrl("/topic/P", true)
		.and().addFilterBefore(new TokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		
		
		return http.build();
		
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails user = User.builder().username("user")
				.password("{noop}abc").roles("USER").build();
		UserDetails admin = User.builder().username("admin")
		.password("{noop}abc").roles("USER","ADMIN").build();
	
				
		return new InMemoryUserDetailsManager(user, admin);
		
	}
	
}
