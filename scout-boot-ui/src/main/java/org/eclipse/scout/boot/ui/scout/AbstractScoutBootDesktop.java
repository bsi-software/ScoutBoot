package org.eclipse.scout.boot.ui.scout;

import javax.inject.Inject;

import org.eclipse.scout.rt.client.ui.desktop.AbstractDesktop;
import org.eclipse.scout.rt.client.ui.desktop.AbstractDesktopExtension;
import org.eclipse.scout.rt.client.ui.desktop.outline.IOutline;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Bean;
import org.eclipse.scout.rt.platform.config.PlatformConfigProperties.ApplicationNameProperty;
import org.eclipse.scout.rt.platform.util.collection.OrderedCollection;

@Bean
public class AbstractScoutBootDesktop extends AbstractDesktop {

	private final ApplicationNameProperty applicationNameConfig;

	@Inject
	public AbstractScoutBootDesktop(final ApplicationNameProperty applicationNameConfig) {
		super(false);
		this.applicationNameConfig = applicationNameConfig;
		callInitializer();
	}

	@Override
	protected String getConfiguredTitle() {
		return applicationNameConfig.getValue();
	}

	public static class DesktopExtension extends AbstractDesktopExtension {

		@Override
		public void contributeOutlines(OrderedCollection<IOutline> outlines) {
			outlines.addAllLast(BEANS.all(IOutline.class));
		}
	}
}
