#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.model.service;

import ${package}.${artifactId}.model.Document;

import java.util.List;
import java.util.UUID;

public interface DocumentService extends ValidatorService<Document> {

  /**
   * Returns all available documents.
   */
  List<Document> getAll();

  /**
   * Returns true if a document with the provided id exists. Returns false otherwise.
   */
  boolean exists(UUID id);

  /**
   * Returns the document specified by the provided id. If no such document exists, null is returned.
   */
  Document get(UUID id);

  /**
   * Persists the provided document.
   */
  void save(Document document);
}
