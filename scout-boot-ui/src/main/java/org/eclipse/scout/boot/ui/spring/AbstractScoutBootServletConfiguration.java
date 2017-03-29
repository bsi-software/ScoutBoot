package org.eclipse.scout.boot.ui.spring;

import javax.servlet.ServletContextListener;

import org.eclipse.scout.rt.server.commons.HttpSessionMutex;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

public abstract class AbstractScoutBootServletConfiguration {

	@Bean
	public ServletListenerRegistrationBean<HttpSessionMutex> httpSessionMutex() {
		return new ServletListenerRegistrationBean<>(new HttpSessionMutex());
	}

	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> scoutSpringWebappListener() {
		return new ServletListenerRegistrationBean<>(new ScoutBootWebappListener());
	}
}
