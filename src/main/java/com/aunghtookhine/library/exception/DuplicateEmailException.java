package com.aunghtookhine.library.exception;

import org.springframework.http.HttpStatus;

public class DuplicateEmailException extends CustomException{
    public DuplicateEmailException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
