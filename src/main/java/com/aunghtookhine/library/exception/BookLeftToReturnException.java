package com.aunghtookhine.library.exception;

import org.springframework.http.HttpStatus;

public class BookLeftToReturnException extends CustomException {
    public BookLeftToReturnException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
