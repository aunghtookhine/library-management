package com.aunghtookhine.library.Exception;

import org.springframework.http.HttpStatus;

public class RecordNotFoundException extends CustomException{
    public RecordNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
