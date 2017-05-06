#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.model;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

/**
 * Application user role
 */
public class Role extends Model<String> {

  public static final String ROOT_ID = "Root";
  public static final Role ROOT = new Role(ROOT_ID);

  private Set<String> permissions = new HashSet<>();

  public Role() {

  }
 
  public Role(String roleId) {
    super(roleId);
  }

  /**
   * Returns the set of permissions associated with this role.
   *
   * @return The set of permissions represented by their fully qualified {@link Permission} class names
   */
  public Set<String> getPermissions() {
    return permissions;
  }

  /**
   * Sets the set of permissions for this role.
   *
   * @param permissions
   *          The set of permissions represented by their fully qualified {@link Permission} class names
   */
  public void setPermissions(Set<String> permissions) {
    this.permissions = permissions;
  }
}
