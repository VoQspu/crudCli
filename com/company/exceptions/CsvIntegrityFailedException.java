package com.company.exceptions;

public class CsvIntegrityFailedException extends Exception {
    @Override
    public String toString() {
        return "Plik csv jest uszkodzony, program zostanie zakończony!";
    }
}
