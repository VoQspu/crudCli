package com.company.exceptions;

public class BookNotFoundException extends Exception {
    public String toString() {
        return "Nie znaleziono książki!";
    }
}
