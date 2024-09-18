package com.aunghtookhine.library.exception;

import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends CustomException {
    public MemberNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
