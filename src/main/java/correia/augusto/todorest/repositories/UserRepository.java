package correia.augusto.todorest.repositories;

import correia.augusto.todorest.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel,Integer> {
}
