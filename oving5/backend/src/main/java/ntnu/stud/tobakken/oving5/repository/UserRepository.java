package ntnu.stud.tobakken.oving5.repository;

import ntnu.stud.tobakken.oving5.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {}
