#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.backend.repository;

import ${package}.${artifactId}.backend.entity.TextEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository extends JpaRepository<TextEntity, String> {

}
