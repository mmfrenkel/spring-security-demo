package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
        // IN MEMORY AUTHENTICATION -- getting up and running
        UserBuilder users = User.withDefaultPasswordEncoder();
        
        auth.inMemoryAuthentication()
            .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
	        .withUser(users.username("mary").password("badpass").roles("MANAGER"))
	        .withUser(users.username("sally").password("xertg34").roles("ADMINISTRATOR"));
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
        // for any request, it must be authenticated, must be logged in
        // announce customization; set where to reference the form and where to send submission
        http.authorizeRequests()
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/showLoginPage")
                .loginProcessingUrl("/authenticateUser")
                .permitAll() // allow anyone to see login page
        	.and()
        		.logout()    // enable logout support
        		.permitAll();
	}
	
}
