package com.hackathon.expense_tracking.repository;

import com.hackathon.expense_tracking.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Query("SELECT t FROM Transaction t WHERE t.person.person_id = :personId")
    List<Transaction> findAllByPersonId(@Param("personId") Long personId);




}
