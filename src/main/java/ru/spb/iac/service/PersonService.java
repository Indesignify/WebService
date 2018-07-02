package ru.spb.iac.service;

import ru.spb.iac.model.dto.CreatePersonDTO;
import ru.spb.iac.model.dto.HandlePersonsDTO;
import ru.spb.iac.model.dto.UpdatePersonDTO;
import ru.spb.iac.model.entities.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(CreatePersonDTO newPersonDTO);

    Person updatePerson(UpdatePersonDTO updatePersonDTO);

    Person getPersonById(Integer id);

    List<Person> getAllPersons();

    void deletePersonById(Integer id);

    List<Person> handlePersons(HandlePersonsDTO handlePersonsDTO);

    boolean isPersonExist(Integer id);

}
