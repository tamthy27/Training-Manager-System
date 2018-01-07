package com.fsoft.gst.ptithcm.tms.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fsoft.gst.ptithcm.tms.commonUltil.RolePermisionUltil;

/**
 * The Class WebSecurityConfig.
 * @author NVTT Jun 11, 2017
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/** The user details service. */
	@Autowired
	private UserDetailsService customUserDetailsService;

	/**
	 * Password encoder.
	 * @return the b crypt password encoder
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Configure global.
	 *
	 * @param auth
	 *            the auth
	 * @throws Exception
	 *             the exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}

	/*
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#
	 * configure(org.springframework.security.config.annotation.web.builders.
	 * HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		http.authorizeRequests().antMatchers("/login").permitAll();

		http.authorizeRequests().antMatchers("/home", "/").access("hasAnyRole('" + RolePermisionUltil.S_LOGIN.getRoleUltil() + "')");

		http.authorizeRequests().antMatchers("/category/**").access("hasAnyRole('" + RolePermisionUltil.M_CATEGORY.getRoleUltil() + "')");

		http.authorizeRequests().antMatchers("/course/**").access("hasAnyRole('" + RolePermisionUltil.M_COURSE.getRoleUltil() + "')");

		http.authorizeRequests().antMatchers("/topic/**").access("hasAnyRole('" + RolePermisionUltil.M_TOPIC.getRoleUltil() + "')");
		
		http.authorizeRequests().antMatchers("/trainer-view/**").access("hasAnyRole('" + RolePermisionUltil.T_V_TOPIC.getRoleUltil() + "')");

		http.authorizeRequests().antMatchers("/admin/**").access("hasAnyRole('" + RolePermisionUltil.A_STAFF.getRoleUltil() + "'"
																		+ ",'"+RolePermisionUltil.A_TRAINER.getRoleUltil()+"')");
		http.authorizeRequests().antMatchers("/trainer/**").access("hasAnyRole('" + RolePermisionUltil.P_TRAINER.getRoleUltil() + "'"
												+ ",'"+RolePermisionUltil.AS_TRAINER.getRoleUltil()+"')");

		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		http.authorizeRequests().and().formLogin()

				.loginProcessingUrl("/j_spring_security_check").loginPage("/login").defaultSuccessUrl("/home").failureUrl("/login?error=true")
				.usernameParameter("username").passwordParameter("password")

				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");

	}

}