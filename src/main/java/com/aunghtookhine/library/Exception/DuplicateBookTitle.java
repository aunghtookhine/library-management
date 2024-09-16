package com.aunghtookhine.library.Exception;

import org.springframework.http.HttpStatus;

public class DuplicateBookTitle extends CustomException{
    public DuplicateBookTitle(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
