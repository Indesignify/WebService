package ru.spb.iac.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.spb.iac.model.dto.CreatePersonDTO;
import ru.spb.iac.model.dto.UpdatePersonDTO;
import ru.spb.iac.model.entities.Person;
import ru.spb.iac.repository.PersonRepository;
import ru.spb.iac.service.PersonService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @GetMapping
    public String getHello() {
        return "Testing hello!";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person createPerson(@Valid @RequestBody CreatePersonDTO createPersonDTO) {
        return personService.createPerson(createPersonDTO);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person updatePerson(@PathVariable("id") Integer id,
                               @Valid @RequestBody UpdatePersonDTO updatePersonDTO) {
        return personService.updatePerson(id, updatePersonDTO);
    }

    @GetMapping(value = "/{id}")
    public Person getPersonById(@PathVariable("id") Integer id) {
        return personService.getPersonById(id);
    }

    @GetMapping(value = "/get-all")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @DeleteMapping(value = "/{id}")
    public void deletePerson(@PathVariable("id") Integer id) {
        personService.deletePersonById(id);
    }

    @PostMapping(value = "/handle",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> handlePersons(List<Person> personsToHandle) {
        return personService.handlePersons(personsToHandle);
    }

}
