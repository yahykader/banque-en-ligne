package org.greta.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource datasource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	       return new BCryptPasswordEncoder();
	}

	  
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		 auth 
	  		.inMemoryAuthentication()
	  		.withUser("user")
	  		.password(passwordEncoder().encode("1234"))
	  		.roles("USER") 
	  .and()
	  		.withUser("admin") 
	  		.password(passwordEncoder().encode("1234"))
	  		.roles("ADMIN","USER");
		
		 
		 /*
		 auth
			  .jdbcAuthentication()
			  .dataSource(datasource)
			  .usersByUsernameQuery("select username as principal ,password as credentials ,active from users where username=?")
			  .authoritiesByUsernameQuery("select username as principal ,role as role  from users_roles where username=?") 
			  .passwordEncoder(new Md4PasswordEncoder())
			  .rolePrefix("ROLE_"); 
			  */
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/operations","/consulterCompte").hasRole("USER");
		http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN");
		http.exceptionHandling().accessDeniedPage("/403");
		
	}
	
}
