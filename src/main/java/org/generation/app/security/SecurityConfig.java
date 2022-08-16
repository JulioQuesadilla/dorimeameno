package org.generation.app.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	/*Método de autenticación*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { //Se indica usuario y contraseña en esta clase
		
			auth.inMemoryAuthentication()
				.withUser("juliojulion")
					.password("{noop}123")
					.roles("ADMIN","USER","SAYAJIN")
				.and()
				.withUser("saul")
					.password("{noop}456")
					.roles("USER")
				.and()
				.withUser("perry")
					.password("{noop}456")
					.roles("SAYAJIN");
	}
	
	
	/*Método de Seguridad */
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .httpBasic().and()
	      .authorizeRequests()
	        .antMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
	        .antMatchers(HttpMethod.PUT, "/api/**").hasRole("USER")
	        .antMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN")
	        .antMatchers(HttpMethod.GET, "/api/**").hasAnyRole("ADMIN","SAYAJIN")
	        .and().formLogin().permitAll()
	        .and()
	      .csrf().disable();
	  }

}
