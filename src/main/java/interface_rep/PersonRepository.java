package interface_rep;

import entity.City;
import entity.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {

    List<Person> findByCity(City city);

    List<Person> findByAgeLessThan(int age, Sort sort);

    List<Person> findByNameAndSurname(String name, String surname);
}
