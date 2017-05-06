#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.model.service;

import ${package}.${artifactId}.model.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService extends ValidatorService<Task> {

  List<Task> getAll();

  List<Task> getToday(String userId);

  List<Task> getOwn(String userId);

  List<Task> getInbox(String userId);

  boolean exists(UUID taskId);

  Task get(UUID taskId);

  void save(Task task);

}
