package com.hackathon.expense_tracking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Transaction", schema = "expensetrackingdb")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transaction_id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "transaction_date")
    private LocalDate transaction_date;

    @Column(name = "description")
    private String description;
}
