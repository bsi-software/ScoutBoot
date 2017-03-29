package org.eclipse.scout.boot.ui.security.endpoint;

import org.eclipse.scout.boot.ui.spring.AbstractScoutUIiServletMvcEndpoint;
import org.eclipse.scout.rt.ui.html.UiServlet;

public abstract class AbstractSecurityScoutUIiServletMvcEndpoint extends AbstractScoutUIiServletMvcEndpoint {

	public AbstractSecurityScoutUIiServletMvcEndpoint() {
		super("scout", UiServlet.class);
	}
}