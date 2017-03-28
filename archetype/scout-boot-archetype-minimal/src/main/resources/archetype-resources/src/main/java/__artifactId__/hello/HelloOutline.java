#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.hello;

import java.util.List;

import org.eclipse.scout.boot.ui.commons.fonts.FontAwesomeIcons;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutline;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.platform.Bean;

@Bean
public class HelloOutline extends AbstractOutline {

	@Override
	protected String getConfiguredTitle() {
		return "Hello";
	}

	@Override
	protected String getConfiguredIconId() {
		return FontAwesomeIcons.fa_globe;
	}

	@Override
	protected void execCreateChildPages(List<IPage<?>> pageList) {
		pageList.add(new HelloPage());
	}
}
