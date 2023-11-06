/**
 * 
 */
package com.cg.neel.igrs.mail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author User
 *
 */
@EnableWebSecurity
public class SecurityMailConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		 	.csrf().disable() //Update in future
		 	.authorizeRequests()
		 	 .antMatchers("/")
		 	 .permitAll();
		
		 return http.build();
	}
}
