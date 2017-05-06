#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.ui.business.task;

import ${package}.${artifactId}.model.Task;
import ${package}.${artifactId}.model.service.TaskService;
import ${package}.${artifactId}.ui.business.task.AbstractTaskTablePage.Table.AcceptMenu;

import java.util.Collection;

import javax.inject.Inject;
import org.eclipse.scout.rt.shared.TEXTS;

public class MyTaskTablePage extends AbstractTaskTablePage {

  @Inject
  private TaskService taskService;

  public MyTaskTablePage() {
    getTable().getResponsibleColumn().setDisplayable(false);
    getTable().getAcceptedColumn().setDisplayable(false);
    getTable().getMenuByClass(AcceptMenu.class).setVisible(false);
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("MyTasks");
  }

  @Override
  protected Collection<Task> getTasks() {
    return taskService.getOwn(getUserId());
  }

  @Override
  protected void execPageActivated() {
    reloadPage();
  }
}
