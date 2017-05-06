#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.ui.business.task;

import java.security.BasicPermission;

public class UpdateTaskPermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  public UpdateTaskPermission() {
    super(UpdateTaskPermission.class.getSimpleName());
  }
}
