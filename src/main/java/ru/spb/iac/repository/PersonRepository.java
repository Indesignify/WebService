package ru.spb.iac.repository;

import org.springframework.data.repository.CrudRepository;
import ru.spb.iac.model.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    Person findPersonById(Integer id);

}
