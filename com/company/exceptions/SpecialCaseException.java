package com.company.exceptions;

public class SpecialCaseException extends RuntimeException {
    public SpecialCaseException(String message) {
        super(message);
        System.exit(1);
    }
}
