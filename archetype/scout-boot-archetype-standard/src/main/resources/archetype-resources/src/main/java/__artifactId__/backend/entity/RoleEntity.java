#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.backend.entity;

import ${package}.${artifactId}.model.Role;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RoleEntity extends Role {

  @Id
  @Override
  public String getId() {
    return super.getId();
  }

  @ElementCollection
  @Override
  public Set<String> getPermissions() {
    return super.getPermissions();
  }
}
