#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.ui.business.task;

import java.security.BasicPermission;

public class CreateTaskPermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  public CreateTaskPermission() {
    super(CreateTaskPermission.class.getSimpleName());
  }
}
