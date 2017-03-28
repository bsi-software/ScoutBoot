package org.eclipse.scout.boot.ui.spring.minimal;

import java.io.IOException;
import java.security.Principal;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

import javax.security.auth.Subject;
import javax.servlet.FilterChain;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.eclipse.scout.boot.ui.spring.ScoutBootWebappListener;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.security.IPrincipalProducer;
import org.eclipse.scout.rt.server.commons.HttpSessionMutex;
import org.eclipse.scout.rt.server.commons.authentication.ServletFilterHelper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.GenericFilterBean;

public abstract class AbstractMinimalScoutBootServletConfiguration {

	@Bean
	public ServletListenerRegistrationBean<HttpSessionMutex> httpSessionMutex() {
		return new ServletListenerRegistrationBean<>(new HttpSessionMutex());
	}

	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> scoutSpringWebappListener() {
		return new ServletListenerRegistrationBean<>(new ScoutBootWebappListener());
	}

	@Bean
	public FilterRegistrationBean jaasFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new GenericFilterBean() {
			public final void doFilter(final ServletRequest request, final ServletResponse response,
					final FilterChain chain) throws ServletException, IOException {
				final PrivilegedExceptionAction<Object> continueChain = new PrivilegedExceptionAction<Object>() {
					public Object run() throws IOException, ServletException {
						chain.doFilter(request, response);
						return null;
					}
				};
				try {
					final HttpServletRequest req = (HttpServletRequest) request;
					Principal principal = req.getUserPrincipal();
					if (principal == null) {
						principal = BEANS.get(IPrincipalProducer.class).produce(req.getSession(true).getId());
					}
					Subject.doAs(BEANS.get(ServletFilterHelper.class).createSubject(principal), continueChain);
				} catch (PrivilegedActionException e) {
					throw new ServletException(e.getMessage(), e);
				}
			}
		});
		registration.addUrlPatterns("/*");
		registration.setOrder(1);
		return registration;
	}
}
