package it.dstech.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/login", "/user/addUser").permitAll().and()
				.authorizeRequests().anyRequest().authenticated().antMatchers("/student/**", "/corso/**")
				.hasAnyRole("USER", "ADMIN", "DBA").and().logout().permitAll();
		// .and().csrf().disable();
	}

}
