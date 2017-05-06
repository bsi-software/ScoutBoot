#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.backend.controller;

import java.security.BasicPermission;

public class ReadApiPermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  public ReadApiPermission() {
    super(ReadApiPermission.class.getSimpleName());
  }
}
