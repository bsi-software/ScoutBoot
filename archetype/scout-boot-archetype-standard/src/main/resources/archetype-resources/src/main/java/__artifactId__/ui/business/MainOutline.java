#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.ui.business;

import ${package}.${artifactId}.ui.business.task.AllTasksTablePage;
import ${package}.${artifactId}.ui.business.task.InboxTablePage;
import ${package}.${artifactId}.ui.business.task.MyTaskTablePage;
import ${package}.${artifactId}.ui.business.task.TodaysTaskTablePage;

import java.util.List;

import org.eclipse.scout.boot.ui.commons.fonts.FontAwesomeIcons;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutline;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Bean;
import org.eclipse.scout.rt.shared.TEXTS;

@Bean
public class MainOutline extends AbstractOutline {

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Tasks");
  }

  @Override
  protected String getConfiguredIconId() {
    return FontAwesomeIcons.fa_calendarCheckO;
  }

  @Override
  protected void execCreateChildPages(List<IPage<?>> pageList) {
    pageList.add(BEANS.get(InboxTablePage.class));
    pageList.add(BEANS.get(TodaysTaskTablePage.class));
    pageList.add(BEANS.get(MyTaskTablePage.class));
    pageList.add(BEANS.get(AllTasksTablePage.class));
  }
}
