package com.hackathon.expense_tracking.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorException extends RuntimeException{
    private HttpStatus status;

    public ErrorException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
