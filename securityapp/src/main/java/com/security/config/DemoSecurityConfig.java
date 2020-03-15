package com.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Using in memory Code.
		/*UserBuilder builder = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(builder.username("Jhon").password("jhon@123").roles("EMPLOYEE"))
									 .withUser(builder.username("mary").password("mary@123").roles("EMPLOYEE","MANAGER"))
									 .withUser(builder.username("susan").password("susan@123").roles("EMPLOYEE","ADMIN"));*/
		//Using Database for authentication.
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			//.anyRequest()
			//.authenticated()
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/leader/**").hasRole("MANAGER")
			.antMatchers("/system/**").hasRole("ADMIN")
			.and().formLogin()
			.loginPage("/user-login")
			.loginProcessingUrl("/user-login-form")
			.permitAll()
			.and()
			.logout()
			.permitAll()
			.and()
			.exceptionHandling()
			.accessDeniedPage("/access-denied");
	}
	
	
	
	
	
}
