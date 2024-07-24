package com.hackathon.expense_tracking.controller;

import com.hackathon.expense_tracking.entity.Person;
import com.hackathon.expense_tracking.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable long id){
        return personService.getById(id);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPerson();
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.removePerson(id);
    }

    @GetMapping("{id}/total-expenses")
    public float getTotalExpensesByPerson(@PathVariable Long id) {
        return personService.getById(id).getTotalExpenses();
    }
}
