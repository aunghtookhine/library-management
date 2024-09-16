package com.aunghtookhine.library.Exception;

import org.springframework.http.HttpStatus;

public class DuplicatePhoneNumberException extends CustomException{
    public DuplicatePhoneNumberException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
