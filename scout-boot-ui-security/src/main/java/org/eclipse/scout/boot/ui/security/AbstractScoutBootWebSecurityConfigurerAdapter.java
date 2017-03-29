package org.eclipse.scout.boot.ui.security;

import org.eclipse.scout.boot.ui.spring.AbstractScoutBootWebJarsWebMvcConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public abstract class AbstractScoutBootWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	/** @formatter:off **/
      http
          .authorizeRequests()
          .antMatchers(
              "/index.html",
              "/login.html",
              "/logout.html",
              "/res/**",
              AbstractScoutBootWebJarsWebMvcConfigurerAdapter.WEBJARS_CONTEXT_PATH + "/**")
            .permitAll()
          .anyRequest()
            .authenticated()
            .and()
          .formLogin()
            .loginPage("/login.html")
            .loginProcessingUrl("/auth")
            .defaultSuccessUrl("/", true)
            .failureUrl("/login.html?error")
            .and()
          .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/logout.html")
            .invalidateHttpSession(true)
            .and()
          .csrf()
            .disable(); // Scout provides CSRF protection
  	/** @formatter:on **/
	}
}