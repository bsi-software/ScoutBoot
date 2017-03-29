package org.eclipse.scout.boot.ui.spring.minimal;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.eclipse.scout.boot.ui.spring.AbstractScoutBootServletConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public abstract class AbstractMinimalScoutBootServletConfiguration extends AbstractScoutBootServletConfiguration {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginRedirect(HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.sendRedirect("/");
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logoutRedirect(HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.sendRedirect("/");
	}

	@Bean
	public FilterRegistrationBean minimalScoutBootJaasFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new MinimalScoutBootJaasFilter());
		registration.addUrlPatterns("/*");
		registration.setOrder(1);
		return registration;
	}
}
