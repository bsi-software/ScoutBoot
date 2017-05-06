#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.backend.entity;

import ${package}.${artifactId}.model.Text;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TextEntity extends Text {

  @Id
  @Column(length = ID_LENGTH_MAX)
  @Override
  public String getId() {
    return super.getId();
  }

  @Column(length = TEXT_LENGTH_MAX)
  @Override
  public String getText() {
    return super.getText();
  }
}
