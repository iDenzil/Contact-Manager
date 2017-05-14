package com.webcm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring security configuration
 * 
 * Defines user roles and assigns access to the roles based on the URL pattern
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version 1.0.1, 14.05.2017.
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	/**
	 * Defines who are the valid users and what are their roles.
	 * 
	 * Injects when role check is required. Hardcoded username and password combinations.
	 * 
	 * @param auth Username the authentication is being performed on
	 * @throws Exception Exception handling
	 */
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER", "ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	}

	/**
	 * Access configuration based on the user role and the URL pattern.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/","/*country*/**", "/*city*/**", "/*contact*/**", "/*welcome*/**", "/*settings*/**", "/*about*/**").access("hasRole('USER')").and().formLogin();
			//.antMatchers("/","/*update*/**", "/*delete*/**").access("hasRole('ADMIN')").and().formLogin();
	}
}