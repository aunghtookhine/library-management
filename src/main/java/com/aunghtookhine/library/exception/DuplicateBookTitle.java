package com.aunghtookhine.library.exception;

import org.springframework.http.HttpStatus;

public class DuplicateBookTitle extends CustomException{
    public DuplicateBookTitle(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
