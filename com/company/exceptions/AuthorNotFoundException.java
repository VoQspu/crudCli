package com.company.exceptions;

public class AuthorNotFoundException extends Exception {
    public String toString() {
        return "Nie znaleziono autora!";
    }
}
