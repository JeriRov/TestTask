package com.example.testtask.controller;

import com.example.testtask.dto.PersonDto;
import com.example.testtask.entity.Person;
import com.example.testtask.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable Long id) {
        Person person = personService.getPersonById(id);
        if (person == null) {
            return ResponseEntity.notFound().build();
        }
        int age = personService.getAgeById(id);
        PersonDto personDto = new PersonDto(person.getId(), person.getFirstName(), person.getLastName(), age);
        return ResponseEntity.ok(personDto);
    }
}
