#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.hello;

import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithNodes;
import org.eclipse.scout.rt.client.ui.form.IForm;
import org.eclipse.scout.rt.platform.Bean;

@Bean
public class HelloPage extends AbstractPageWithNodes {

	@Override
	protected String getConfiguredTitle() {
		return "Hello";
	}

	@Override
	protected Class<? extends IForm> getConfiguredDetailForm() {
		return HelloForm.class;
	}
}
