package ru.spb.iac.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.spb.iac.model.dto.CreatePersonDTO;
import ru.spb.iac.model.dto.HandlePersonsDTO;
import ru.spb.iac.model.dto.UpdatePersonDTO;
import ru.spb.iac.model.entities.Person;
import ru.spb.iac.service.PersonService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest-api")
public class PersonRestController {

    private final Logger LOG = LoggerFactory.getLogger(PersonRestController.class);

    @Autowired
    PersonService personService;

    @PostMapping(value = "/person", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPerson(
            @Valid @RequestBody CreatePersonDTO createPersonDTO,
            UriComponentsBuilder uriComponentsBuilder) {

        LOG.info("Creating new user: {}", createPersonDTO);

        if (createPersonDTO.getId() != null) {
            if (personService.isPersonExist(createPersonDTO.getId())) {
                LOG.info("A person with id " + createPersonDTO.getId() + " already exists!");
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }

        personService.createPerson(createPersonDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/persons/{id}")
                            .buildAndExpand(createPersonDTO.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }

    @PutMapping(value = "/person/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Integer id,
                               @Valid @RequestBody UpdatePersonDTO updatePersonDTO) {

        if (id == null) {
            LOG.info("ID was not specified!");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        LOG.info("Updating person: {}", updatePersonDTO);
        Person currentPerson = personService.getPersonById(id);

        if (currentPerson == null) {
            LOG.info("Person with id {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Person updatedPerson = personService.updatePerson(updatePersonDTO);

        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);

    }

    @GetMapping(value = "/person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Integer id) {

        LOG.info("Getting person with id: {}", id);
        Person person = personService.getPersonById(id);

        if (person == null) {
            LOG.info("Person with id {} not found, please try again!", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<Person>> getAllPersons() {

        LOG.info("Getting all persons");
        List<Person> persons = personService.getAllPersons();

        if (persons == null || persons.isEmpty()) {
            LOG.info("No persons found!");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(persons, HttpStatus.OK);

    }

    @DeleteMapping(value = "/person/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Integer id) {

        LOG.info("Deleting person with id: {}", id);
        Person person = personService.getPersonById(id);

        if (person == null) {
            LOG.info("Unable to delete: person with id {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        personService.deletePersonById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PostMapping(value = "/handle",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> handlePersons(HandlePersonsDTO handlePersonsDTO) {
        return personService.handlePersons(handlePersonsDTO);
    }

}
