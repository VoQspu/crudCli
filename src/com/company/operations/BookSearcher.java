package com.company.operations;

import com.company.models.Book;

import java.util.List;
import java.util.Scanner;

public class BookSearcher implements Operationable {

    List<Book> database;

    public BookSearcher(List<Book> database) {
        this.database = database;
    }

    @Override
    public String getDescription() {
        return "1. Wyszukaj książkę\n";
    }

    @Override
    public void performAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id książki: ");
        int searchedId = Integer.parseInt(scanner.nextLine());

        for (Book element : database) {
            if (element.getId() == searchedId ) {
                System.out.println(element);
            }
        }
    }
}
