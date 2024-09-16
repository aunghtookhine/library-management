package com.aunghtookhine.library.Exception;

import org.springframework.http.HttpStatus;

import java.util.function.Supplier;

public class MemberNotFoundException extends CustomException {
    public MemberNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
