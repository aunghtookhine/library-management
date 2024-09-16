package com.aunghtookhine.library.Exception;

import org.springframework.http.HttpStatus;

public class NoBookLeftToBorrowException extends CustomException{

    public NoBookLeftToBorrowException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
