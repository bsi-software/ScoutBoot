#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.ui.business.task;

import ${package}.${artifactId}.model.Task;
import ${package}.${artifactId}.model.service.TaskService;

import java.util.Collection;

import javax.inject.Inject;
import org.eclipse.scout.rt.shared.TEXTS;

public class InboxTablePage extends AbstractTaskTablePage {

  @Inject
  private TaskService taskService;

  public InboxTablePage() {
    getTable().getResponsibleColumn().setDisplayable(false);
    getTable().getAcceptedColumn().setDisplayable(false);
    getTable().getDoneColumn().setDisplayable(false);
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("InboxTablePage");
  }

  @Override
  protected Collection<Task> getTasks() {
    return taskService.getInbox(getUserId());
  }

  @Override
  protected void execPageActivated() {
    reloadPage();
  }
}
