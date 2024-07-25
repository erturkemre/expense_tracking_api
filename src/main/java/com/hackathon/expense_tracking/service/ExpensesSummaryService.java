package com.hackathon.expense_tracking.service;

import com.hackathon.expense_tracking.entity.ExpensesSummary;
import com.hackathon.expense_tracking.entity.Person;
import com.hackathon.expense_tracking.entity.Transaction;
import com.hackathon.expense_tracking.repository.ExpensesSummaryRepository;
import com.hackathon.expense_tracking.repository.PersonRepository;
import com.hackathon.expense_tracking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

@Service
public class ExpensesSummaryService {
    private final PersonRepository personRepository;
    private final TransactionRepository transactionRepository;
    private final ExpensesSummaryRepository expensesSummaryRepository;

    @Autowired
    public ExpensesSummaryService(PersonRepository personRepository, TransactionRepository transactionRepository, ExpensesSummaryRepository expensesSummaryRepository) {
        this.personRepository = personRepository;
        this.transactionRepository = transactionRepository;
        this.expensesSummaryRepository = expensesSummaryRepository;
    }

    @Scheduled(cron = "0 0 * * * *")
    public void calculateDailyExpenses() {
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
