package com.hackathon.expense_tracking.service;

import com.hackathon.expense_tracking.entity.Person;
import com.hackathon.expense_tracking.entity.Transaction;
import com.hackathon.expense_tracking.repository.PersonRepository;
import com.hackathon.expense_tracking.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final TransactionRepository transactionRepository;

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

    @Scheduled(cron = "0 0 * * * *")
    public void calculatePersonTotalExpenses() {
        List<Person> persons = personRepository.findAll();

        for(Person person : persons){
            List<Transaction> transactions = transactionRepository.findAllByPersonId(person.getPerson_id());
            float totalExpenses = 0;

            for(Transaction transaction: transactions){
                totalExpenses += transaction.getAmount();

            }

            person.setTotalExpenses(totalExpenses);

        }
        personRepository.saveAll(persons);


    }


}
