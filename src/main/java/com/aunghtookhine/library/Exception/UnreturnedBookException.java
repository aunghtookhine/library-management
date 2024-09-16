package com.aunghtookhine.library.Exception;

import org.springframework.http.HttpStatus;

public class UnreturnedBookException extends CustomException{
    public UnreturnedBookException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
