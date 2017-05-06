#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.ui.admin.db;

import java.security.BasicPermission;

public class ReadDatabaseAdministrationConsolePermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  public ReadDatabaseAdministrationConsolePermission() {
    super(ReadDatabaseAdministrationConsolePermission.class.getSimpleName());
  }
}
