package com.hackathon.expense_tracking.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonSaveRequest {
    private String first_name;
    private String last_name;
    private String email;
    private String password;

}
