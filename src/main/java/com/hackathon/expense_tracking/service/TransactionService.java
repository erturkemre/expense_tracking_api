package com.hackathon.expense_tracking.service;

import com.hackathon.expense_tracking.entity.Transaction;
import com.hackathon.expense_tracking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction getTransaction(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction updateTransaction(Long id, Transaction transaction) {
        if (transactionRepository.existsById(id)) {
            transaction.setTransaction_id(id);
            return transactionRepository.save(transaction);
        }
        return null;
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
    public List<Transaction> getAllTransactionsByPersonId(Long personId) {
        return transactionRepository.findAllByPersonId(personId);
    }
}
