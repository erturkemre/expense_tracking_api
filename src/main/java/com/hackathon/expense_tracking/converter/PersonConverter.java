package com.hackathon.expense_tracking.converter;

import com.hackathon.expense_tracking.dto.response.PersonResponse;
import com.hackathon.expense_tracking.entity.Person;

import java.util.List;

public class PersonConverter {

    public static PersonResponse toResponse(Person person){
        return PersonResponse.builder()
                .first_name(person.getFirst_name())
                .last_name(person.getLast_name())
                .email(person.getEmail())
                .totalExpenses(person.getTotalExpenses())
                .build();
    }

    public static List<PersonResponse> toResponse(List<Person> persons) {
        return persons.stream().map(PersonConverter::toResponse).toList();
    }
}
