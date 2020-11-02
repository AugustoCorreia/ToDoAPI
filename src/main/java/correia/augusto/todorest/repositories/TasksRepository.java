package correia.augusto.todorest.repositories;

import correia.augusto.todorest.models.TasksModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface TasksRepository extends CrudRepository <TasksModel,Integer> {

}
