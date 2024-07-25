package com.hackathon.expense_tracking.dto.response;


import com.hackathon.expense_tracking.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionResponse {
    private Person person;
    private Double amount;
    private LocalDate transaction_date;
    private String description;
}
