package org.eclipse.scout.boot.ui.spring;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public abstract class AbstractScoutBootWebJarsWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

	public static final String WEBJARS_CONTEXT_PATH = "/webjars";

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.setOrder(-1);
		if (!registry.hasMappingForPattern(WEBJARS_CONTEXT_PATH + "/**")) {
			registry.addResourceHandler(WEBJARS_CONTEXT_PATH + "/**")
					.addResourceLocations("classpath:/META-INF/resources/webjars/");
		}
	}
}
