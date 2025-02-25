package com.hackathon.expense_tracking.dto.request;


import com.hackathon.expense_tracking.entity.Person;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionSaveRequest {
    private Person person;
    private Double amount;
    private String description;
}
