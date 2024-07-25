package com.hackathon.expense_tracking.converter;
import com.hackathon.expense_tracking.dto.response.TransactionResponse;
import com.hackathon.expense_tracking.entity.Transaction;

import java.time.LocalDate;
import java.util.List;

public class TransactionConverter {

    public static TransactionResponse toResponse(Transaction transaction){
        return TransactionResponse.builder()
                .person(transaction.getPerson())
                .amount(transaction.getAmount())
                .transaction_date(LocalDate.now())
                .description(transaction.getDescription())
                .build();
    }

    public static List<TransactionResponse> toResponse(List<Transaction> transactions) {
        return transactions.stream().map(TransactionConverter::toResponse).toList();
    }
}
