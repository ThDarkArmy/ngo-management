package tda.darkarmy.ngomanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.darkarmy.ngomanagement.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
