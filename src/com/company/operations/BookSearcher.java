package com.company.operations;

import com.company.models.Book;

import java.util.List;
import java.util.Scanner;

public class BookSearcher implements Operationable {


    @Override
    public String getDescription() {
        return "1. Wyszukaj książkę";
    }

    @Override
    public void performAction() {
        System.out.println("Wyszukuję");
    }
}
