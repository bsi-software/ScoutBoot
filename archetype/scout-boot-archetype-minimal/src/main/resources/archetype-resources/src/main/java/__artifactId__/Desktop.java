#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId};

import javax.inject.Inject;

import org.eclipse.scout.boot.ui.scout.AbstractScoutBootDesktop;
import org.eclipse.scout.rt.client.ui.desktop.AbstractDesktopExtension;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutlineViewButton;
import org.eclipse.scout.rt.client.ui.desktop.outline.IOutline;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Bean;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.config.PlatformConfigProperties.ApplicationNameProperty;
import org.eclipse.scout.rt.platform.util.collection.OrderedCollection;

import ${package}.${artifactId}.hello.HelloOutline;

@Bean
public class Desktop extends AbstractScoutBootDesktop {

	@Inject
	public Desktop(ApplicationNameProperty applicationNameConfig) {
		super(applicationNameConfig);
	}

	@Override
	protected void execDefaultView() {
		setOutline(HelloOutline.class);
	}

	@Order(10)
	public class HelloOutlineViewButton extends AbstractOutlineViewButton {

		public HelloOutlineViewButton() {
			this(HelloOutline.class);
		}

		protected HelloOutlineViewButton(final Class<? extends HelloOutline> outlineClass) {
			super(Desktop.this, outlineClass);
		}
		
	    @Override
	    protected DisplayStyle getConfiguredDisplayStyle() {
	      return DisplayStyle.TAB;
	    }
	}

	public static class DesktopExtension extends AbstractDesktopExtension {

		@Override
		public void contributeOutlines(OrderedCollection<IOutline> outlines) {
			outlines.addAllLast(BEANS.all(IOutline.class));
		}
	}

}
