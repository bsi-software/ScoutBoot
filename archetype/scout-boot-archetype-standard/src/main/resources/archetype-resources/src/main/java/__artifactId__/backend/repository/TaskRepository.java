#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.backend.repository;

import java.util.List;
import java.util.UUID;

import ${package}.${artifactId}.backend.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {

  List<TaskEntity> findByResponsible(String userId);

}
