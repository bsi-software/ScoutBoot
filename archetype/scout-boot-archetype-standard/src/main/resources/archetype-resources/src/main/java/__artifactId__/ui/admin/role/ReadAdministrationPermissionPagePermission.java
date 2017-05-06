#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.ui.admin.role;

import java.security.BasicPermission;

public class ReadAdministrationPermissionPagePermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  public ReadAdministrationPermissionPagePermission() {
    super(ReadAdministrationPermissionPagePermission.class.getSimpleName());
  }

}
