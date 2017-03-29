package org.eclipse.scout.boot.ui.security.endpoint;

import org.eclipse.scout.boot.ui.security.ScoutJaasApiIntegrationFilter;
import org.eclipse.scout.boot.ui.spring.AbstractScoutBootServletConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

public abstract class AbstractSecurityScoutBootServletConfiguration extends AbstractScoutBootServletConfiguration {

	@Bean
	public FilterRegistrationBean scoutJaasApiIntegrationFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new ScoutJaasApiIntegrationFilter());
		registrationBean.setOrder(Integer.MAX_VALUE);
		return registrationBean;
	}
}
