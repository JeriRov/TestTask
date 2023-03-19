package com.example.testtask.unit.controller;

import com.example.testtask.controller.PersonController;
import com.example.testtask.dto.PersonDto;
import com.example.testtask.entity.Person;
import com.example.testtask.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController personController;

    @Test
    void testGetPersonById() {
        Long id = 1L;
        LocalDate dateOfBirth = LocalDate.of(1990, 1, 1);
        Person person = new Person(id, "John", "Doe", dateOfBirth);
        Mockito.when(personService.getPersonById(id)).thenReturn(person);
        Mockito.when(personService.getAgeById(id)).thenReturn(33);

        ResponseEntity<PersonDto> responseEntity = personController.getPersonById(id);

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        PersonDto personDto = responseEntity.getBody();
        Assertions.assertNotNull(personDto);
        Assertions.assertEquals("John", personDto.getFirstName());
        Assertions.assertEquals("Doe", personDto.getLastName());
        Assertions.assertEquals(33, personDto.getAge());
    }

    @Test
    void testGetPersonByIdNotFound() {
        Long id = 1L;
        Mockito.when(personService.getPersonById(id)).thenReturn(null);

        ResponseEntity<PersonDto> responseEntity = personController.getPersonById(id);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
}