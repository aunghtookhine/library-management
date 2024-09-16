package com.aunghtookhine.library.Exception;

import org.springframework.http.HttpStatus;

public class BookNotFoundException extends CustomException{
    public BookNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
