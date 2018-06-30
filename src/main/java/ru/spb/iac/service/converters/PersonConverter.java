package ru.spb.iac.service.converters;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spb.iac.model.dto.CreatePersonDTO;
import ru.spb.iac.model.dto.UpdatePersonDTO;
import ru.spb.iac.model.entities.Person;
import ru.spb.iac.repository.PersonRepository;

@Mapper(componentModel = "spring")
@Component
public abstract class PersonConverter {

    @Autowired
    PersonRepository personRepository;

    public abstract Person convertCreatePersonDTOToPerson(CreatePersonDTO createPersonDTO);

    public Person convertUpdatePersonDTOToPerson(UpdatePersonDTO updatePersonDTO) {
        Person person = personRepository.findPersonById(updatePersonDTO.getId());

        if (updatePersonDTO.getLastName() != null) {
            person.setLastName(updatePersonDTO.getLastName());
        }

        if (updatePersonDTO.getFirstName() != null) {
            person.setFirstName(updatePersonDTO.getFirstName());
        }

        if (updatePersonDTO.getMiddleName() != null) {
            person.setMiddleName(updatePersonDTO.getMiddleName());
        }

        if (updatePersonDTO.getBirthDate() != null) {
            person.setBirthDate(updatePersonDTO.getBirthDate());
        }

        return person;
    }

}
