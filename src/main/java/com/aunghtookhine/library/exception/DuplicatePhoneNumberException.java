package com.aunghtookhine.library.exception;

import org.springframework.http.HttpStatus;

public class DuplicatePhoneNumberException extends CustomException{
    public DuplicatePhoneNumberException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
