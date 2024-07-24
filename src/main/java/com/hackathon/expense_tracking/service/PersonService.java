package com.hackathon.expense_tracking.service;

import com.hackathon.expense_tracking.entity.Person;
import com.hackathon.expense_tracking.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public Person createPerson(Person person){
        return personRepository.save(person);
    }


    public Person getById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }

    public void removePerson(long id){
        personRepository.deleteById(id);
    }

    public Person updatePerson(Long id, Person person) {
        if (personRepository.existsById(id)) {
            person.setPerson_id(id);
            return personRepository.save(person);
        }
        return null;
    }


}
