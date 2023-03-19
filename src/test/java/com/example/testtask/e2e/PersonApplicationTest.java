package com.example.testtask.e2e;

import com.example.testtask.dto.PersonDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
class PersonApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetPersonById() {
        long id = 1L;
        String firstName = "John";
        String lastName = "Doe";
        int age = 33;

        ResponseEntity<PersonDto> responseEntity = restTemplate.getForEntity("/api/person/" + id, PersonDto.class);

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        PersonDto personDto = responseEntity.getBody();
        Assertions.assertNotNull(personDto);
        Assertions.assertEquals(firstName, personDto.getFirstName());
        Assertions.assertEquals(lastName, personDto.getLastName());
        Assertions.assertEquals(age, personDto.getAge());
    }
}