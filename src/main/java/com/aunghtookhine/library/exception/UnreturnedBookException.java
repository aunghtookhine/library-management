package com.aunghtookhine.library.exception;

import org.springframework.http.HttpStatus;

public class UnreturnedBookException extends CustomException{
    public UnreturnedBookException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
