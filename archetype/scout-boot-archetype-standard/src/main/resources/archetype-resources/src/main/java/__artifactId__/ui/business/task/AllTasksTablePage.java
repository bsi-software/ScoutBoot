#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.ui.business.task;

import ${package}.${artifactId}.model.Task;
import ${package}.${artifactId}.model.service.TaskService;

import java.util.Collection;

import javax.inject.Inject;
import org.eclipse.scout.rt.shared.TEXTS;

public class AllTasksTablePage extends AbstractTaskTablePage {

  @Inject
  private TaskService taskService;

  public AllTasksTablePage() {
    getTable().getReminderColumn().setVisible(false);
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("AllTasks");
  }

  @Override
  protected void execInitPage() {
    setVisiblePermission(new ViewAllTasksPermission());
  }

  @Override
  protected Collection<Task> getTasks() {
    return taskService.getAll();
  }

  @Override
  protected void execPageActivated() {
    // NOOP
  }

}
