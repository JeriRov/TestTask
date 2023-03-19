package com.example.testtask.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonDto {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
}
