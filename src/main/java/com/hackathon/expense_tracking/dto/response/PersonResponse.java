package com.hackathon.expense_tracking.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonResponse {
    private String first_name;
    private String last_name;
    private String email;
    private float totalExpenses;
}
