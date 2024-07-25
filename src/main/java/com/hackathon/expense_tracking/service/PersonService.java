package com.hackathon.expense_tracking.service;

import com.hackathon.expense_tracking.entity.Person;
import com.hackathon.expense_tracking.entity.Transaction;
import com.hackathon.expense_tracking.exception.ErrorException;
import com.hackathon.expense_tracking.repository.PersonRepository;
import com.hackathon.expense_tracking.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final TransactionRepository transactionRepository;

    public Person createPerson(Person person){
        return personRepository.save(person);
    }


    @Transactional(readOnly = true)
    public Person getById(Long id) {
        Optional<Person> findPerson = personRepository.findById(id);
        if(findPerson.isPresent()){
            findPerson.get();
        }
        throw new ErrorException("Kullanıcı bulunamadı", HttpStatus.NOT_FOUND);
    }

    @Transactional(readOnly = true)
    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }

    public void removePerson(long id){
        personRepository.deleteById(id);
    }

    @Transactional
    public Person updatePerson(Long id, Person person) {
        if (personRepository.existsById(id)) {
            person.setPerson_id(id);
            return personRepository.save(person);
        }else{
            throw new ErrorException("Islem basarısız",HttpStatus.FAILED_DEPENDENCY);
        }

    }




}
