package com.example.testtask.unit.service;

import com.example.testtask.entity.Person;
import com.example.testtask.repository.PersonRepository;
import com.example.testtask.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {
    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    @Test
    void testGetAgeById() {
        Long id = 1L;
        LocalDate dob = LocalDate.of(1990, 1, 1);
        Person person = new Person(id, "John", "Doe", dob);
        when(personRepository.findById(id)).thenReturn(Optional.of(person));

        int age = personService.getAgeById(id);

        assertEquals(33, age);
    }

    @Test
    void testGetAgeByIdNotFound() {
        Long id = 1L;
        LocalDate dob = LocalDate.of(1990, 1, 1);
        Person person = new Person(id, "John", "Doe", dob);
        when(personRepository.findById(id)).thenReturn(Optional.of(person));

        int age = personService.getAgeById(id);

        assertEquals(33, age);
    }

}