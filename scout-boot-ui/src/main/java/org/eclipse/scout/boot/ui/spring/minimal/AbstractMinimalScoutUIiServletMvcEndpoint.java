package org.eclipse.scout.boot.ui.spring.minimal;

import org.eclipse.scout.boot.ui.spring.AbstractScoutUIiServletMvcEndpoint;
import org.eclipse.scout.rt.ui.html.UiServlet;

public abstract class AbstractMinimalScoutUIiServletMvcEndpoint extends AbstractScoutUIiServletMvcEndpoint {

	public AbstractMinimalScoutUIiServletMvcEndpoint() {
		super("scout", UiServlet.class);
	}
}