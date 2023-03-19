package com.example.testtask.service;

import com.example.testtask.entity.Person;

public interface PersonService {
    int getAgeById(Long id);

    Person getPersonById(Long id);
}
