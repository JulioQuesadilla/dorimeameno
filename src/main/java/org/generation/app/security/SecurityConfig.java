package org.generation.app.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
		/*
	    http
	      .httpBasic().and()
	      .authorizeRequests()
	        .antMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
	        .antMatchers(HttpMethod.PUT, "/api/**").hasRole("USER")
	        .antMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN")
	        .antMatchers(HttpMethod.GET, "/api/**").hasAnyRole("ADMIN","SAYAJIN")
	        
	        .antMatchers("/**").permitAll() //Luego de las restricciones, se permite todo.
	        .anyRequest().authenticated() //Cualquier otra petición, requere autentificación
	        .and().formLogin().permitAll()
	        .and()
	      .csrf().disable();
	      */
		http
		  .csrf().disable()
	      .authorizeRequests() 
	        //.antMatchers("/**").permitAll()
	        .anyRequest().authenticated() //Cualquier otra petición, requiere autentificación
	        .and()
	        .formLogin().permitAll()
	        .and()
	        //Las peticiones para /login pasará por este filtro, para darnos el token
	        .addFilterBefore(new LoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
	        
	      //El siguiente filtro, valorará en las peticiones http, si el token es correcto
	        .addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);


	  }

}
