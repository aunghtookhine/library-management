package com.aunghtookhine.library.exception;

import org.springframework.http.HttpStatus;

public class AlreadyBorrowedException extends CustomException{
    public AlreadyBorrowedException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
