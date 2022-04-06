package ntnu.stud.tobakken.oving5.repository;

import ntnu.stud.tobakken.oving5.entity.Equation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EquationRepository extends CrudRepository<Equation, Integer> {
    Optional<List<Equation>> findAllByUser_Username(String username);
}
