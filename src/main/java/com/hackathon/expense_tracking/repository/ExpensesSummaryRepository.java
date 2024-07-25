package com.hackathon.expense_tracking.repository;

import com.hackathon.expense_tracking.entity.ExpensesSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesSummaryRepository extends JpaRepository<ExpensesSummary,Long> {

}
