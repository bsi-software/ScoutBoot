#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId};

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.scout.boot.ui.spring.minimal.AbstractMinimalScoutBootServletConfiguration;
import org.eclipse.scout.boot.ui.spring.minimal.AbstractMinimalScoutUIiServletMvcEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@Controller
@RequestMapping("/")
public class ServletConfiguration extends AbstractMinimalScoutBootServletConfiguration {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginRedirect(HttpServletResponse httpServletResponse) throws IOException {
		redirect(httpServletResponse);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logoutRedirect(HttpServletResponse httpServletResponse) throws IOException {
		redirect(httpServletResponse);
	}

	@Configuration
	public class MvcEndpoint extends AbstractMinimalScoutUIiServletMvcEndpoint {

		@Override
		@RequestMapping("/**")
		public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
			return defaultScoutUIiServletMvcEndpointHandleImplementation(request, response);
		}
	}

	protected void redirect(HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.sendRedirect("/");
	}
}
