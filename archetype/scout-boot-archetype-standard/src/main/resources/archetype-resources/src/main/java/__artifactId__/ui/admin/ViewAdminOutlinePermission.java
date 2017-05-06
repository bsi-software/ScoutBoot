#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.ui.admin;

import java.security.BasicPermission;

public class ViewAdminOutlinePermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  public ViewAdminOutlinePermission() {
    super(ViewAdminOutlinePermission.class.getSimpleName());
  }
}
