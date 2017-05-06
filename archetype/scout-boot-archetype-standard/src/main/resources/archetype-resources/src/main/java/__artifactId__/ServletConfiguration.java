#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId};

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.scout.boot.ui.security.endpoint.AbstractSecurityScoutBootServletConfiguration;
import org.eclipse.scout.boot.ui.security.endpoint.AbstractSecurityScoutUIiServletMvcEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Application's servlet configuration 
 */
@Configuration
@EnableWebMvc
@Controller
@RequestMapping("/")
public class ServletConfiguration extends AbstractSecurityScoutBootServletConfiguration {
	
	public static final String API_CONTEXT_PATH = "/api";
	public static final String H2_CONTEXT_PATH = "/h2-console";

	@Configuration
	public class StandaloneMvcEndpoint extends AbstractSecurityScoutUIiServletMvcEndpoint {

		@Override
		@RequestMapping("/**")
		public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
			return defaultScoutUIiServletMvcEndpointHandleImplementation(request, response);
		}
	}
}
