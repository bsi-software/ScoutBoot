#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.backend.entity;

import ${package}.${artifactId}.backend.entity.converter.UuidConverter;
import ${package}.${artifactId}.model.Document;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class DocumentEntity extends Document {

  @Id
  @Convert(converter = UuidConverter.class)
  @Override
  public UUID getId() {
    return super.getId();
  }

  @Column(nullable = false)
  @Override
  public String getName() {
    return super.getName();
  }

  @Lob
  @Column(length = CONTENT_SIZE_MAX)
  @Override
  public byte[] getData() {
    return super.getData();
  }

}
