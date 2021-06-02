package practice.springboot.demo.reps;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.springboot.demo.entities.Cars;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CarsRepository extends JpaRepository<Cars, Long> {

}
