package com.hackathon.expense_tracking.controller;


import com.hackathon.expense_tracking.service.ExpensesSummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/expenses")
public class ExpensesSummaryController {

    private final ExpensesSummaryService expensesSummaryService;
    @Autowired
    public ExpensesSummaryController(ExpensesSummaryService expensesSummaryService) {
        this.expensesSummaryService = expensesSummaryService;
    }

    @GetMapping("/calculate/daily")
    public String calculateDailyExpenses() {
        expensesSummaryService.calculateDailyExpenses();
        return "Daily expenses calculated successfully!";
    }


}
