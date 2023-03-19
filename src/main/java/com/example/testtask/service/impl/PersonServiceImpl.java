package com.example.testtask.service.impl;

import com.example.testtask.entity.Person;
import com.example.testtask.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public int getAgeById(Long id) {
        return 0;
    }

    @Override
    public Person getPersonById(Long id) {
        return null;
    }
}
