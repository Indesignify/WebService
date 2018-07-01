package ru.spb.iac.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spb.iac.model.dto.CreatePersonDTO;
import ru.spb.iac.model.dto.UpdatePersonDTO;
import ru.spb.iac.model.entities.Person;
import ru.spb.iac.repository.PersonRepository;
import ru.spb.iac.service.PersonService;
import ru.spb.iac.service.converters.PersonConverter;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonConverter personConverter;

    @Override
    public Person createPerson(CreatePersonDTO newPersonDTO) {

        Person newPerson = personConverter.convertCreatePersonDTOToPerson(newPersonDTO);

        personRepository.save(newPerson);

        return newPerson;

    }

    @Override
    public Person updatePerson(UpdatePersonDTO updatePersonDTO) {

        Person updatedPerson = personConverter.convertUpdatePersonDTOToPerson(updatePersonDTO);

        return personRepository.save(updatedPerson);

    }

    @Override
    public Person getPersonById(Integer id) {

        return personRepository.findPersonById(id);

    }

    @Override
    public List<Person> getAllPersons() {

        List<Person> allPersons = new ArrayList<>();

        personRepository.findAll().forEach(allPersons::add);

        return allPersons;

    }

    @Override
    public void deletePersonById(Integer id) {

        if (!personRepository.existsById(id)) {
            throw new IllegalArgumentException("No person with id " + id
                                            + " exists, please try again!");
        }

        personRepository.deleteById(id);

    }

    @Override
    public List<Person> handlePersons(List<Person> persons) {
        return null;
    }

    @Override
    public boolean isPersonExist(Integer id) {
        return personRepository.existsById(id);
    }

}
