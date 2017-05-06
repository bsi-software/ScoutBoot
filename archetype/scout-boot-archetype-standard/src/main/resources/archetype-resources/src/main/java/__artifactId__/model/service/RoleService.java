#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.model.service;

import ${package}.${artifactId}.model.Role;

import java.util.List;

public interface RoleService extends ValidatorService<Role> {

  /**
   * Returns all available roles.
   */
  List<Role> getAll();

  /**
   * Returns true if a role with the provided id exists. Returns false otherwise.
   */
  boolean exists(String roleId);

  /**
   * Returns the role specified by the provided role id. If no such role exists, null is returned.
   */
  Role get(String roleId);

  /**
   * Persists the provided role.
   */
  void save(Role role);

}
