package com.educational.material.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfig {
	
	@Autowired private CustomUserDetailsService customUserDetailsService; 
	
	private static final String[] AUTH_WHITELIST = {
		"/public/**",
		"/error",
		"/v2/**",
		"/v3/**",
		"/swagger-resources/**",
		"/webjars/**",
		"/swagger-ui/**"
	};
	
	private static final String[] AUTH_FORWARDLIST = {
			"/admin/**"
	};
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.cors().and().csrf().disable()
			.authorizeHttpRequests(authorize ->  authorize
				.dispatcherTypeMatchers().permitAll() //permitAll()--> The request requires no authorization to be invoked
				.antMatchers(AUTH_WHITELIST).permitAll()
				.anyRequest()
				.authenticated()
			 )
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.formLogin().defaultSuccessUrl("/topic/P", true);
		//.and().addFilterBefore(new TokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		
		
		return http.build();
		
	}
	
	/*@Bean
	public void getAuthenticationManagerBuilder( AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(customUserDetailsService);
	}*/
	
	// to use planetext --> context
	/*@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}*/
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	//@Bean
	/*public UserDetailsService userDetailsService() {
		
		UserDetails user = User.builder().username("user")
				.password("{noop}abc").roles("USER").build();
		UserDetails admin = User.builder().username("admin")
		.password("{noop}abc").roles("USER","ADMIN").build();
	
				
		return new InMemoryUserDetailsManager(user, admin);
		
	}*/
	
	@Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin("*"); // You can restrict this to specific origins
        corsConfig.addAllowedHeader("*");
        corsConfig.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsFilter(source);
    }
	
}
