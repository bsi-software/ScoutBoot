#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.ui.admin.db;

import org.eclipse.scout.boot.ui.commons.widgets.BrowserFieldBorderless;
import org.eclipse.scout.rt.client.context.ClientRunContexts;
import org.eclipse.scout.rt.client.job.ModelJobs;
import org.eclipse.scout.rt.client.ui.desktop.IDesktop;
import org.eclipse.scout.rt.client.ui.desktop.notification.DesktopNotification;
import org.eclipse.scout.rt.client.ui.desktop.notification.IDesktopNotification;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.fields.browserfield.AbstractBrowserField;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.platform.Bean;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.util.concurrent.IRunnable;

@Bean
public class DatabaseAdministrationConsoleForm extends AbstractForm {

	protected static final String H2_CONSOLE_URL = "http://localhost:8080/h2-console";
	protected static final String JDBC_URL = "jdbc:h2:~/${artifactId}_db";

	@Override
	protected void execInitForm() {
		execDisplayJdbcUrl();
	}

	@Override
	protected int getConfiguredDisplayHint() {
		return DISPLAY_HINT_VIEW;
	}

	@Order(1000)
	public class MainBox extends AbstractGroupBox {

		@Override
		protected boolean getConfiguredLabelVisible() {
			return false;
		}

		@Override
		protected boolean getConfiguredStatusVisible() {
			return false;
		}

		@Override
		protected boolean getConfiguredBorderVisible() {
			return false;
		}

		@Override
		protected String getConfiguredCssClass() {
			return BrowserFieldBorderless.MAIN_BOX_CSS_CLASS;
		}

		@Order(1000)
		public class BrowserField extends AbstractBrowserField {

			@Override
			protected double getConfiguredGridWeightY() {
				return 1;
			}

			@Override
			protected boolean getConfiguredLabelVisible() {
				return false;
			}

			@Override
			protected boolean getConfiguredStatusVisible() {
				return false;
			}

			@Override
			protected boolean getConfiguredSandboxEnabled() {
				return false;
			}

			@Override
			protected String getConfiguredCssClass() {
				return BrowserFieldBorderless.BROWSER_FIELD_CSS_CLASS;
			}

			@Override
			protected boolean getConfiguredScrollBarEnabled() {
				return true;
			}

			@Override
			protected void execInitField() {
				setLocation(H2_CONSOLE_URL);
			}
		}
	}

	public void execDisplayJdbcUrl() {
		ModelJobs.schedule(new IRunnable() {
			@Override
			public void run() throws Exception {
				IDesktopNotification notification = new DesktopNotification("" + "Connect to JDBC URL:\n" + JDBC_URL);
				IDesktop.CURRENT.get().addNotification(notification);
			}
		}, ModelJobs.newInput(ClientRunContexts.copyCurrent()));
	}
}
