package com.example.testtask.service.impl;

import com.example.testtask.entity.Person;
import com.example.testtask.repository.PersonRepository;
import com.example.testtask.service.PersonService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public int getAgeById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Person with id " + id + " not found"));

        LocalDate dateOfBirth = person.getDateOfBirth();
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);

        return period.getYears();
    }

    @Override
    public Person getPersonById(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isEmpty()) {
            throw new NoSuchElementException("Person with id " + id + " not found");
        }
        return personOptional.get();
    }
}
