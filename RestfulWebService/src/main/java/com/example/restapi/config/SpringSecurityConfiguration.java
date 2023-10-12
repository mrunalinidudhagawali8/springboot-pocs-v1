package com.example.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
	
	/**
	 * Spring-Security
	 * 
	 * Simply adding spring security dependency in pom will make all your RestApi by default secure.
	 * by not providing any username and password for authentication - SpringSecurity will generate one for you(user, XXXXX)
	 * 
	 * by default any data modification access will not be allowed (POST, PUT, DELETE)
	 * for this reason, we can create a custom FilterChain process so that,
	 * we can disable this CSRF functionality(hence allowing us to make data modification calls)
	 */
	@Bean
	public SecurityFilterChain customFilterChain(HttpSecurity httpSecurity) throws Exception
	{
		//1. To enable authentication of all requests
		httpSecurity.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		
		//2. If a request is not authorised then a authorization window should open
		httpSecurity.httpBasic(withDefaults());
		
		//3.Disable CSRF -> POST, PUT etc.
		httpSecurity.csrf().disable();
		
		return httpSecurity.build();
	}
	
	

}
